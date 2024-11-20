package co.cue.edu.ticventory.ticventory.inventory.service;

import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.inventory.domain.ResourceStatus;

public class ResourceService {
    public void changeStatus(Resource resource, ResourceStatus newStatus) {
        resource.setState(newStatus);
    }
}
