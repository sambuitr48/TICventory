package co.cue.edu.ticventory.ticventory.inventory;
/**
 * Esta clase es una fábrica que se encarga de crear objetos de tipo Resource.
 * Utiliza el patrón de diseño Factory para abstraer la creación del objeto y permitir la construcción de un Resource sin necesidad de preocuparse por los detalles internos de su construcción.
 */
public class ResourceFactory {
    /**
     * Método estático para crear un objeto Resource.
     *
     * @param code El código del recurso.
     * @param description La descripción del recurso.
     * @param resourceType El tipo de recurso (ResourceType).
     * @param sedeLocation La sede donde se encuentra el recurso (Sede).
     * @param brand La marca del recurso.
     * @param state El estado actual del recurso (ResourceState).
     * @return Un nuevo objeto Resource con los atributos proporcionados.
     */
    public static Resource createResource(String code, String description, ResourceType resourceType, Sede sedeLocation, String brand, ResourceState state) {
        return new ResourceBuilder()
                .setCode(code)
                .setDescription(description)
                .setResourceType(resourceType)
                .setSedeLocation(sedeLocation)
                .setBrand(brand)
                .setState(state)
                .build();
    }
}
