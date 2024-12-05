package co.cue.edu.ticventory.ticventory;

import co.cue.edu.ticventory.ticventory.inventory.controller.InventoryController;
import co.cue.edu.ticventory.ticventory.inventory.dto.ResourceDTO;
import co.cue.edu.ticventory.ticventory.inventory.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class InventoryControllerTest {

    @Mock
    private InventoryService inventoryService;

    @InjectMocks
    private InventoryController inventoryController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(inventoryController).build();
    }

    @Test
    public void testAddResource_success() throws Exception {
        doNothing().when(inventoryService).addResource(any(ResourceDTO.class));

        mockMvc.perform(post("/resources")
                        .contentType("application/json")
                        .content("{\"code\":\"code123\",\"description\":\"Test Resource\"}"))
                .andExpect(status().isOk());

        verify(inventoryService, times(1)).addResource(any(ResourceDTO.class));
    }

    @Test
    public void testGetResource_success() throws Exception {
        when(inventoryService.getResource("code123")).thenReturn(new ResourceDTO("code123", "Test Resource", null, null, null, null));

        mockMvc.perform(get("/resources/code123"))
                .andExpect(status().isOk());

        verify(inventoryService, times(1)).getResource("code123");
    }

    @Test
    public void testGetResource_notFound() throws Exception {
        when(inventoryService.getResource("invalid_code")).thenReturn(null);

        mockMvc.perform(get("/resources/invalid_code"))
                .andExpect(status().isNotFound());

        verify(inventoryService, times(1)).getResource("invalid_code");
    }

    @Test
    public void testGetAllResources_success() throws Exception {
        when(inventoryService.getAllResources()).thenReturn(List.of(
                new ResourceDTO("code123", "Test Resource 1", null, null, null, null),
                new ResourceDTO("code124", "Test Resource 2", null, null, null, null)
        ));

        mockMvc.perform(get("/resources"))
                .andExpect(status().isOk());

        verify(inventoryService, times(1)).getAllResources();
    }

    @Test
    public void testDeleteResource_success() throws Exception {
        doNothing().when(inventoryService).deleteResource("code123");

        mockMvc.perform(delete("/resources/code123"))
                .andExpect(status().isOk());

        verify(inventoryService, times(1)).deleteResource("code123");
    }
}
