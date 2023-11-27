package ge.davidgogishvili.projects.coordinates.Controllers;

import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocationHistory;
import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocations;
import ge.davidgogishvili.projects.coordinates.Models.VehicleLocationsCreateModel;
import ge.davidgogishvili.projects.coordinates.Models.VehicleLocationsHistoryCreateModel;
import ge.davidgogishvili.projects.coordinates.Services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("locations")
public class LocationServiceController {

    private final LocationService locationsService;

    @PostMapping("{vehicleId}/createLocations")
    public VehicleLocations createVehicleLocations(@RequestBody VehicleLocationsCreateModel vehicleLocationsCreateModel) {
        return locationsService.createVehicleLocations(vehicleLocationsCreateModel);
    }


    @PostMapping("{vehicleId}/createLocationsHistory")
    public VehicleLocationHistory createVehicleLocationsHistory(@RequestBody VehicleLocationsHistoryCreateModel vehicleLocationsHistoryCreateModel) {
        return locationsService.createVehicleLocationsHistory(vehicleLocationsHistoryCreateModel);
    }

}

