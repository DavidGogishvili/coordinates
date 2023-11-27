package ge.davidgogishvili.projects.coordinates.Implementations;

import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocationHistory;
import ge.davidgogishvili.projects.coordinates.Models.VehicleLocationsCreateModel;
import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocations;
import ge.davidgogishvili.projects.coordinates.Models.VehicleLocationsHistoryCreateModel;
import ge.davidgogishvili.projects.coordinates.Repositories.VehicleLocationHistoryRepo;
import ge.davidgogishvili.projects.coordinates.Repositories.VehicleLocationsRepo;
import ge.davidgogishvili.projects.coordinates.Repositories.VehiclesRepo;
import ge.davidgogishvili.projects.coordinates.Services.LocationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final VehicleLocationsRepo vehicleLocationsRepo;
    private final VehicleLocationHistoryRepo vehicleLocationHistoryRepo;
    private final VehiclesRepo vehiclesRepo;

    @Override
    public VehicleLocations createVehicleLocations(VehicleLocationsCreateModel vehicleLocationsCreateModel) {
        Integer vehicleId = vehicleLocationsCreateModel.vehicleId();

        if (!vehiclesRepo.existsById(vehicleId)) {
            throw new EntityNotFoundException("ავტომობილი ასეთი აიდით არ არსებობს!");
        }

        VehicleLocations vehicleLocations = new VehicleLocations();
        vehicleLocations.setLongitude(vehicleLocationsCreateModel.longitude());
        vehicleLocations.setLatitude(vehicleLocationsCreateModel.latitude());
        vehicleLocations.setCarNumber(vehicleLocationsCreateModel.carNumber());
        vehicleLocations.setVehicleId(vehicleLocationsCreateModel.vehicleId());




        vehicleLocationsRepo.save(vehicleLocations);

        return vehicleLocations;


    }

    @Override
    public VehicleLocationHistory createVehicleLocationsHistory(VehicleLocationsHistoryCreateModel vehicleLocationsHistoryCreateModel) {
        Integer vehiclesId = vehicleLocationsHistoryCreateModel.vehicleId();
        if (!vehiclesRepo.existsById(vehiclesId)) {
            throw new EntityNotFoundException("ავტომობილი ასეთი აიდით არ არსებობს!");
        }
        VehicleLocationHistory vehicleLocationHistory = new VehicleLocationHistory();
        vehicleLocationHistory.setLongitude(vehicleLocationsHistoryCreateModel.longitude());
        vehicleLocationHistory.setLatitude(vehicleLocationsHistoryCreateModel.latitude());
        vehicleLocationHistory.setCarNumber(vehicleLocationsHistoryCreateModel.carNumber());
        vehicleLocationHistory.setVehicleId(vehicleLocationsHistoryCreateModel.vehicleId());
        vehicleLocationHistory.setLastContactDate(LocalDateTime.now());


        vehicleLocationHistoryRepo.save(vehicleLocationHistory);
        return vehicleLocationHistory;
    }


}
