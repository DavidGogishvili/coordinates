package ge.davidgogishvili.projects.coordinates.Repositories;

import ge.davidgogishvili.projects.coordinates.Entities.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehiclesRepo extends JpaRepository <Vehicles, Integer> {

}
