package ge.davidgogishvili.projects.coordinates.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class VehicleLocationHistory {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_location_history_seq-generator")
    @SequenceGenerator(name = "vehicle_location_history_seq-generator", sequenceName = "vehicle_location_history_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "last_contact_date")
    private LocalDateTime lastContactDate;

    @Column(name = "car_number")
    private String carNumber;

    public VehicleLocationHistory(LocalDateTime lastContactDate, Double longitude, Double latitude, String carNumber) {
        this.lastContactDate = lastContactDate;
        this.latitude = latitude;
        this.longitude = longitude;
        this.carNumber = carNumber;
    }

    public VehicleLocationHistory() {
    }
}

