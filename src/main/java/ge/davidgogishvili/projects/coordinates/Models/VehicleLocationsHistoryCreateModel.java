package ge.davidgogishvili.projects.coordinates.Models;

import java.time.LocalDateTime;

public record VehicleLocationsHistoryCreateModel(
        Double latitude,
        Double longitude,
        String carNumber,
        Integer vehicleId,
        LocalDateTime LastContactDate

) {
}
