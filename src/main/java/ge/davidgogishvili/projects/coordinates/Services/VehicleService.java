package ge.davidgogishvili.projects.coordinates.Services;

import ge.davidgogishvili.projects.coordinates.Entities.Vehicles;
import ge.davidgogishvili.projects.coordinates.Models.VehicleCreateModel;

import java.util.List;



public interface VehicleService {



    List<Vehicles> search(String carNumber, String driver, String vehicleType, Double length, Double width, Double height, String capacity, Boolean status);

    Vehicles createVehicles (Vehicles vehicles);

}
