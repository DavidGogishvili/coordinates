package ge.davidgogishvili.projects.coordinates.Models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LocationRequestModel {

    private Integer vehicleId;
    private String carNumber;
    private Double latitude;
    private Double longitude;

    public Integer vehicleId() {
        return vehicleId;
    }
}
