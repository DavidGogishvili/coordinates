

package ge.davidgogishvili.projects.coordinates.Services;

import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocationHistory;
import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocations;
import ge.davidgogishvili.projects.coordinates.Models.VehicleLocationsCreateModel;
import ge.davidgogishvili.projects.coordinates.Models.VehicleLocationsHistoryCreateModel;

public interface LocationService {

    VehicleLocations createVehicleLocations(VehicleLocationsCreateModel vehicleLocationsCreateModel);

    VehicleLocationHistory createVehicleLocationsHistory(VehicleLocationsHistoryCreateModel vehicleLocationsHistoryCreateModel);
}
