package co.cue.edu.ticventory.ticventory.auth;

import co.cue.edu.ticventory.ticventory.auth.controller.AuthController;
import co.cue.edu.ticventory.ticventory.auth.dto.UserDTO;
import co.cue.edu.ticventory.ticventory.auth.mapper.UserMapper;
import co.cue.edu.ticventory.ticventory.auth.model.User;
import co.cue.edu.ticventory.ticventory.auth.service.AuthFacade;
import co.cue.edu.ticventory.ticventory.auth.service.AuthProxy;
import co.cue.edu.ticventory.ticventory.auth.service.AuthService;
import co.cue.edu.ticventory.ticventory.auth.repository.UserRepositoryImpl;
import co.cue.edu.ticventory.ticventory.auth.state.AuthContext;
import co.cue.edu.ticventory.ticventory.auth.state.AuthenticatedState;
import co.cue.edu.ticventory.ticventory.auth.state.UnauthenticatedState;
import co.cue.edu.ticventory.ticventory.auth.strategy.AuthenticationStrategy;
import co.cue.edu.ticventory.ticventory.auth.strategy.PasswordAuthentication;
import co.cue.edu.ticventory.ticventory.auth.strategy.TokenAuthentication;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializar dependencias
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        AuthService authService = new AuthService();
        authService.setUserRepository(userRepository);
        AuthProxy authProxy = new AuthProxy(authService);
        AuthFacade authFacade = new AuthFacade(authProxy);
        UserMapper userMapper = new UserMapper();
        AuthController authController = new AuthController(authFacade);
        AuthContext authContext = new AuthContext(new UnauthenticatedState());

        // Menú interactivo
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Autenticación ===");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Cerrar Sesión");
            System.out.println("4. Listar Usuarios");
            System.out.println("5. Ver Estado de Autenticación");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el ID del usuario: ");
                    String id = scanner.nextLine();
                    System.out.print("Ingrese el nombre de usuario: ");
                    String username = scanner.nextLine();
                    System.out.print("Ingrese el rol (ADMIN, USER, GUEST): ");
                    String role = scanner.nextLine();
                    System.out.print("Ingrese la contraseña: ");
                    String password = scanner.nextLine();
                    UserDTO newUser = new UserDTO(id, username, role, password);
                    User user = UserMapper.toEntity(newUser);
                    userRepository.save(user);
                    System.out.println("Usuario creado exitosamente.");
                }
                case 2 -> {
                    System.out.print("Seleccione el método de autenticación (1. Contraseña, 2. Token): ");
                    int method = scanner.nextInt();
                    scanner.nextLine();
                    AuthenticationStrategy strategy;
                    if (method == 1) {
                        strategy = new PasswordAuthentication(userRepository);
                    } else if (method == 2) {
                        strategy = new TokenAuthentication();
                    } else {
                        System.out.println("Método de autenticación inválido.");
                        break;
                    }
                    authFacade.setAuthenticationStrategy(strategy);
                    System.out.print("Ingrese su nombre de usuario o token: ");
                    String loginIdentifier = scanner.nextLine();
                    System.out.print("Ingrese su contraseña (o presione Enter si es un token): ");
                    String loginCredential = scanner.nextLine();
                    boolean loginSuccess = authFacade.login(loginIdentifier, loginCredential);
                    if (loginSuccess) {
                        authContext.setState(new AuthenticatedState());
                        System.out.println("Inicio de sesión exitoso.");
                    } else {
                        System.out.println("Credenciales incorrectas.");
                    }
                }
                case 3 -> {
                    authFacade.logout();
                    authContext.setState(new UnauthenticatedState());
                    System.out.println("Sesión cerrada.");
                }
                case 4 -> {
                    if (authContext.getState() instanceof AuthenticatedState) {
                        System.out.println("Usuarios registrados:");
                        List<User> userList = userRepository.findAll();
                        for (User existingUser : userList) {
                            System.out.println("- " + existingUser.getUsername() + " (Rol: " + existingUser.getRole() + ")");
                        }
                    } else {
                        System.out.println("Debe iniciar sesión para listar usuarios.");
                    }
                }
                case 5 -> System.out.println("Estado de autenticación: " + authContext.getStatus());
                case 6 -> {
                    running = false;
                    System.out.println("Saliendo...");
                }
                default -> System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}
