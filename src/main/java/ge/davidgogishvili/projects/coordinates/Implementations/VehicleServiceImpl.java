package ge.davidgogishvili.projects.coordinates.Implementations;

import ge.davidgogishvili.projects.coordinates.Entities.Vehicles;
import ge.davidgogishvili.projects.coordinates.Repositories.VehiclesRepo;
import ge.davidgogishvili.projects.coordinates.Services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

   private final VehiclesRepo vehicleRepo;


    @Override
    public List<Vehicles> search(String carNumber, String driver, String vehicleType, Double length, Double width, Double height, String capacity, Boolean status) {
        return vehicleRepo.findAll();

    }


    @Override
    public Vehicles createVehicles (Vehicles vehicles) {

        vehicles.setCarNumber(vehicles.getCarNumber());
        vehicles.setDriver(vehicles.getDriver());
        vehicles.setVehicleType(vehicles.getVehicleType());
        vehicles.setLength(vehicles.getLength());
        vehicles.setWidth(vehicles.getWidth());
        vehicles.setHeight(vehicles.getHeight());
        vehicles.setCapacity(vehicles.getCapacity());
        vehicles.setStatus(true);
        return vehicleRepo.save(vehicles);

    }
}
