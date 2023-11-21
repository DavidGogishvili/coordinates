package ge.davidgogishvili.projects.coordinates.Controllers;

import ge.davidgogishvili.projects.coordinates.Entities.Vehicles;
import ge.davidgogishvili.projects.coordinates.Models.VehicleCreateModel;
import ge.davidgogishvili.projects.coordinates.Services.VehicleLocationAndHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vehicles")
public class VehiclesController {
    private final VehicleLocationAndHistoryService vehiclesService;

    @GetMapping("/vehicleSearch")
    public List <Vehicles> search (String number, String driver, String vehicleType,
                                   Double length, Double width, Double height, String capacity) {
        return vehiclesService.search (number, driver, vehicleType, length, width, height, capacity);
    }


    @PostMapping("addVehicles/{id}")
    public Vehicles createVehicles(@PathVariable Integer id, @RequestBody VehicleCreateModel vehicleCreateModel){
        return vehiclesService.createVehicles(id, vehicleCreateModel);
    }
}
