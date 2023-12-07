package ge.davidgogishvili.projects.coordinates.Services;

import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocationHistory;
import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocations;
import ge.davidgogishvili.projects.coordinates.Repositories.VehicleLocationHistoryRepo;
import ge.davidgogishvili.projects.coordinates.Repositories.VehicleLocationsRepo;
import ge.davidgogishvili.projects.coordinates.Repositories.VehiclesRepo;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data
@Service
public class LocationsService {

    private final VehicleLocationsRepo vehicleLocationsRepo;

   private final VehicleLocationHistoryRepo vehicleLocationHistoryRepo;


    private final VehiclesRepo vehiclesRepo;


    @Transactional
    public void createVehiclesLocations(VehicleLocations vehicleLocations, VehicleLocationHistory vehicleLocationHistory) {
        vehicleLocations.setVehicleId(vehicleLocations.getVehicleId());
        vehicleLocationHistory.setVehicleId(vehicleLocationHistory.getVehicleId());
        vehicleLocations.setCarNumber(vehicleLocations.getCarNumber());
        vehicleLocationHistory.setCarNumber(vehicleLocations.getCarNumber());
        vehicleLocations.setLatitude(vehicleLocations.getLatitude());
        vehicleLocationHistory.setLatitude(vehicleLocationHistory.getLatitude());
        vehicleLocations.setLongitude(vehicleLocations.getLongitude());
        vehicleLocationHistory.setLongitude(vehicleLocations.getLongitude());
        vehicleLocationHistory.setLastContactDate(LocalDateTime.now());

        vehicleLocationsRepo.save(vehicleLocations);
        vehicleLocationHistoryRepo.save(vehicleLocationHistory);
    }
}
