package ge.davidgogishvili.projects.coordinates.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class VehicleLocations {

    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="vehicle_locations_seq-generator")
    @SequenceGenerator(name="vehicle_locations_seq-generator", sequenceName="vehicle_locations_id_seq", allocationSize = 1)
    @Id
    private Integer id;


    @Column (name = "longitude")
    private Double longitude;

    @Column (name = "latitude")
    private Double latitude;

    @Column (name = "car_number")
    private String  carNumber;

    public VehicleLocations(String carNumber, Double longitude, Double latitude) {

        this.carNumber = carNumber;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public VehicleLocations() {

    }


}
