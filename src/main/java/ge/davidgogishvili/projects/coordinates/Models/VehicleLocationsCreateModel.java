package ge.davidgogishvili.projects.coordinates.Models;

import lombok.Data;
import lombok.Getter;

public record VehicleLocationsCreateModel (



    Double latitude,
    Double longitude,
    String carNumber,
    Integer vehicleId


)
{

}
