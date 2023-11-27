package ge.davidgogishvili.projects.coordinates.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Vehicles {

    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="vehicles_seq-generator")
    @SequenceGenerator(name="vehicles_seq-generator", sequenceName="vehicles_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column (name = "number")
    private String carNumber;

    @Column (name = "driver")
    private String driver;

    @Column (name = "vehicle_type")
    private String vehicleType;

    @Column (name = "length")
    private Double length;

    @Column (name = "width")
    private Double width;

    @Column (name = "height")
    private Double height;

    @Column (name = "load_capacity")
    private String capacity;

    @Column (name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "vehicles", cascade = CascadeType.ALL)
    private List<VehicleLocations> vehicleLocations;
}
