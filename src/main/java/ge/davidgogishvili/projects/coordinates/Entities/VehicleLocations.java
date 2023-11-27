package ge.davidgogishvili.projects.coordinates.Entities;

import ge.davidgogishvili.projects.coordinates.Repositories.VehiclesRepo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class VehicleLocations {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_locations_seq-generator")
    @SequenceGenerator(name = "vehicle_locations_seq-generator", sequenceName = "vehicle_locations_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "car_number")
    private String carNumber;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Vehicles vehicles;

    @Column (name = "vehicle_id")
    private Integer vehicleId;

    public VehicleLocations() {
    }

}
