package ge.davidgogishvili.projects.coordinates.Implementations;

import ge.davidgogishvili.projects.coordinates.Entities.Vehicles;
import ge.davidgogishvili.projects.coordinates.Models.VehicleCreateModel;
import ge.davidgogishvili.projects.coordinates.Repositories.VehiclesRepo;
import ge.davidgogishvili.projects.coordinates.Services.VehicleLocationAndHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleLocationAndHistoryService {

   private final VehiclesRepo vehicleRepo;


    @Override
    public List<Vehicles> search(String number, String driver, String vehicleType, Double length, Double width,
                                 Double height, String capacity) {
        return vehicleRepo.findAll();
    }

    @Override
    public Vehicles createVehicles (Integer id, VehicleCreateModel vehicleCreateModel) {

        var vehicles = new Vehicles ();
        vehicles.setCarNumber(vehicleCreateModel.car_number());
        vehicles.setDriver(vehicleCreateModel.driver());
        vehicles.setVehicleType(vehicleCreateModel.vehicleType());
        vehicles.setLength(vehicleCreateModel.length());
        vehicles.setWidth(vehicleCreateModel.width());
        vehicles.setHeight(vehicleCreateModel.height());
        vehicles.setCapacity(vehicleCreateModel.capacity());
        vehicleRepo.save(vehicles);
        return vehicles;

    }
}
