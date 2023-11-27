package ge.davidgogishvili.projects.coordinates.Controllers;

import ge.davidgogishvili.projects.coordinates.Entities.Vehicles;
import ge.davidgogishvili.projects.coordinates.Models.VehicleCreateModel;
import ge.davidgogishvili.projects.coordinates.Services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vehicles")
public class VehiclesController {
    private final VehicleService vehiclesService;

    @GetMapping("/vehicleSearch")
    public List <Vehicles> search (String carNumber, String driver, String vehicleType,
                                   Double length, Double width, Double height, String capacity, Boolean status) {
        return vehiclesService.search (carNumber, driver, vehicleType, length, width, height, capacity, status);
    }


    @PostMapping("addVehicles")
    public ResponseEntity<Vehicles> createVehicle(@RequestBody Vehicles vehicles) {
         vehiclesService.createVehicles(vehicles);
         return ResponseEntity.ok(vehicles);
    }
}
