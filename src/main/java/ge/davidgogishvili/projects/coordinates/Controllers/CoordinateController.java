package ge.davidgogishvili.projects.coordinates.Controllers;
import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocations;
import ge.davidgogishvili.projects.coordinates.Models.LocationRequestModel;
import ge.davidgogishvili.projects.coordinates.Repositories.VehicleLocationsRepo;
import ge.davidgogishvili.projects.coordinates.Services.CoordinateService;
import ge.davidgogishvili.projects.coordinates.Services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Coordinates")
public class CoordinateController {

    private final CoordinateService coordinateService;
    private final VehicleLocationsRepo vehicleLocationsRepo;
    private final LocationService locationService;

    @Autowired
    public CoordinateController(
            CoordinateService coordinateService,
            VehicleLocationsRepo vehicleLocationsRepo,
            LocationService locationService) {
        this.coordinateService = coordinateService;
        this.vehicleLocationsRepo = vehicleLocationsRepo;
        this.locationService = locationService;
    }

    @PostMapping("/UploadEcxelFileAndRecieveCoordinates")
    public ResponseEntity<?> uploadCoordinates(@RequestParam("file") MultipartFile file) {
        coordinateService.saveCoordinatesToDatabase(file);
        return ResponseEntity.ok(Map.of("Message", "აიტვირთა!"));
    }

    @GetMapping("/calculateDistance")
    public double getDistance() {
        List<VehicleLocations> coordinates = vehicleLocationsRepo.findAll();
        if (coordinates.size() >= 2) {
            VehicleLocations firstCoordinate = coordinates.get(0);
            VehicleLocations secondCoordinate = coordinates.get(1);
            return distance(
                    firstCoordinate.getLatitude(),
                    secondCoordinate.getLatitude(),
                    firstCoordinate.getLongitude(),
                    secondCoordinate.getLongitude());
        } else {
            return 0.0;
        }
    }

    @PostMapping("/RecieveAndStoreCoordinatesRemotely")
    public String storeLocation(@RequestBody LocationRequestModel request) {
        locationService.storeLocation(request);
        return "ეგარი!";
    }

    private double distance(double lat1, double lat2, double lon1, double lon2) {
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.tan(lat2);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        double r = 6371;

        return c * r;
    }
}
