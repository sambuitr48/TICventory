package co.cue.edu.ticventory.ticventory.inventory;

import co.cue.edu.ticventory.ticventory.inventory.builder.ResourceBuilder;
import co.cue.edu.ticventory.ticventory.inventory.builder.ResourceFactory;
import co.cue.edu.ticventory.ticventory.inventory.composite.InventoryComponent;
import co.cue.edu.ticventory.ticventory.inventory.composite.ResourceGroup;
import co.cue.edu.ticventory.ticventory.inventory.composite.ResourceLeaf;
import co.cue.edu.ticventory.ticventory.inventory.dto.ResourceDTO;
import co.cue.edu.ticventory.ticventory.inventory.facade.InventoryFacade;
import co.cue.edu.ticventory.ticventory.inventory.memento.ResourceMemento;
import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.inventory.model.ResourceType;
import co.cue.edu.ticventory.ticventory.inventory.model.Sede;
import co.cue.edu.ticventory.ticventory.inventory.repository.ResourceRepository;
import co.cue.edu.ticventory.ticventory.inventory.service.InventoryService;
import co.cue.edu.ticventory.ticventory.inventory.template.SpecificInventoryProcessor;
import co.cue.edu.ticventory.ticventory.inventory.state.AvailableState;
import co.cue.edu.ticventory.ticventory.inventory.state.ReservedState;
import co.cue.edu.ticventory.ticventory.inventory.state.ResourceState;
import co.cue.edu.ticventory.ticventory.inventory.template.InventoryProcessor;
import co.cue.edu.ticventory.ticventory.inventory.domain.ResourceStatus;

public class Main {
    public static void main(String[] args) {
        // 1. Builder Pattern
        System.out.println("=== Builder Pattern ===");
        Resource resource1 = new ResourceBuilder()
                .setCode("R001")
                .setDescription("Laptop Dell")
                .setResourceType(new ResourceType("Electronics", "Electronic Device"))
                .setSedeLocation(Sede.PRINCIPAL)
                .setBrand("Dell")
                .setState(ResourceStatus.AVAILABLE)
                .build();
        System.out.println("Resource created using Builder: " + resource1.getDescription());

        // 2. Factory Pattern
        System.out.println("\n=== Factory Pattern ===");
        Resource resource2 = ResourceFactory.createResource(
                "R002", "Printer HP", new ResourceType("Electronics", "Printing Device"),
                Sede.ANOVA, "HP", ResourceStatus.RESERVED);
        System.out.println("Resource created using Factory: " + resource2.getDescription());

        // 3. Memento Pattern
        System.out.println("\n=== Memento Pattern ===");
        ResourceMemento savedState = resource1.saveToMemento();
        resource1.setState(ResourceStatus.UNAVAILABLE);
        System.out.println("Resource state changed to: " + resource1.getState());
        resource1.restoreFromMemento(savedState);
        System.out.println("Resource state restored to: " + resource1.getState());

        // 4. Composite Pattern
        System.out.println("\n=== Composite Pattern ===");
        InventoryComponent group = new ResourceGroup();
        group.add(new ResourceLeaf(resource1));
        group.add(new ResourceLeaf(resource2));
        System.out.println("Resources in the group:");
        group.showDetails();

        // 5. State Pattern
        System.out.println("\n=== State Pattern ===");
        ResourceState availableState = new AvailableState();
        ResourceState reservedState = new ReservedState();
        availableState.handle();
        reservedState.handle();

        // 6. Facade Pattern
        System.out.println("\n=== Facade Pattern ===");
        ResourceRepository repository = new ResourceRepository();
        InventoryService service = new InventoryService(repository);
        InventoryFacade facade = new InventoryFacade(service);
        ResourceDTO resourceDTO = new ResourceDTO();
        resourceDTO.setCode("R003");
        resourceDTO.setDescription("Projector Epson");
        resourceDTO.setType(new ResourceType("Electronics", "Projection Device"));
        resourceDTO.setLocation("PRINCIPAL");
        resourceDTO.setBrand("Epson");
        resourceDTO.setStatus(ResourceStatus.AVAILABLE);
        facade.addResource(resourceDTO);
        ResourceDTO fetchedResource = facade.getResource("R003");
        System.out.println("Resource fetched through Facade: " + fetchedResource.getDescription());

        // 7. Template Pattern
        System.out.println("\n=== Template Pattern ===");
        InventoryProcessor processor = new SpecificInventoryProcessor();
        processor.processInventory();
    }
}
