package ge.davidgogishvili.projects.coordinates.Controllers;

import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocationHistory;
import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocations;
import ge.davidgogishvili.projects.coordinates.Models.LocationRequestModel;
import ge.davidgogishvili.projects.coordinates.Repositories.VehicleLocationHistoryRepo;
import ge.davidgogishvili.projects.coordinates.Repositories.VehicleLocationsRepo;
import ge.davidgogishvili.projects.coordinates.Repositories.VehiclesRepo;
import ge.davidgogishvili.projects.coordinates.Services.LocationsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("locations")
public class LocationsController {

    private final LocationsService locationsService;




    public LocationsController(LocationsService locationsService) {
        this.locationsService = locationsService;

    }


    @PostMapping("/create")
    public ResponseEntity<String> createVehiclesLocations(@RequestBody LocationRequestModel request) {
        try {
            VehicleLocations vehicleLocations = new VehicleLocations();
            vehicleLocations.setVehicleId(request.getVehicleId());
            vehicleLocations.setCarNumber(request.getCarNumber());
            vehicleLocations.setLatitude(request.getLatitude());
            vehicleLocations.setLongitude(request.getLongitude());

            VehicleLocationHistory vehicleLocationHistory = new VehicleLocationHistory();
            vehicleLocationHistory.setVehicleId(request.getVehicleId());
            vehicleLocationHistory.setCarNumber(request.getCarNumber());
            vehicleLocationHistory.setLatitude(request.getLatitude());
            vehicleLocationHistory.setLongitude(request.getLongitude());
            vehicleLocationHistory.setLastContactDate(LocalDateTime.now());

            locationsService.createVehiclesLocations(vehicleLocations, vehicleLocationHistory);

            return new ResponseEntity<>("Locations created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
                     return new ResponseEntity<>("Failed to create locations", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}






