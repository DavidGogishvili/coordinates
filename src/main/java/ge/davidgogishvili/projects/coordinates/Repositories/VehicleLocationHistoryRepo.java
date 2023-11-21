package ge.davidgogishvili.projects.coordinates.Repositories;

import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleLocationHistoryRepo extends JpaRepository <VehicleLocationHistory, Integer> {
}
