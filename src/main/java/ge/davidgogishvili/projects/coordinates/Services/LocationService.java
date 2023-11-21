package ge.davidgogishvili.projects.coordinates.Services;

import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocationHistory;
import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocations;
import ge.davidgogishvili.projects.coordinates.Models.LocationRequestModel;
import ge.davidgogishvili.projects.coordinates.Repositories.VehicleLocationHistoryRepo;
import ge.davidgogishvili.projects.coordinates.Repositories.VehicleLocationsRepo;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Setter
@AllArgsConstructor
public class LocationService {


    private final VehicleLocationsRepo vehicleLocationsRepo;
    private final VehicleLocationHistoryRepo vehicleLocationHistoryRepo;


    public void storeLocation(LocationRequestModel request) {

        VehicleLocations vehiclelocations = new VehicleLocations(request.getCarNumber(),
                request.getLongitude(), request.getLatitude());
        VehicleLocationHistory vehicleLocationHistory = new VehicleLocationHistory(request.getLastContactDate(LocalDateTime.now()),
                request.getLongitude(), request.getLatitude(), request.getCarNumber());

        vehicleLocationsRepo.save(vehiclelocations);
        vehicleLocationHistoryRepo.save(vehicleLocationHistory);

    }
}
