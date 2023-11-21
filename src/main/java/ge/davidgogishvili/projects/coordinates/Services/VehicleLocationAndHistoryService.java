package ge.davidgogishvili.projects.coordinates.Services;

import ge.davidgogishvili.projects.coordinates.Entities.Vehicles;
import ge.davidgogishvili.projects.coordinates.Models.VehicleCreateModel;

import java.util.List;

public interface VehicleLocationAndHistoryService {

    List <Vehicles> search (String number, String driver,
                              String vehicleType, Double length, Double width, Double height, String capacity);


    Vehicles createVehicles (Integer id, VehicleCreateModel vehicleCreateModel);
}
