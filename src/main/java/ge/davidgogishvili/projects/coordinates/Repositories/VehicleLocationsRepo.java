package ge.davidgogishvili.projects.coordinates.Repositories;

import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleLocationsRepo extends JpaRepository<VehicleLocations, Integer> {
}
