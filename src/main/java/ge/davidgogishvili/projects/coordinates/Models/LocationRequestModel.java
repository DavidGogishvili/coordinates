package ge.davidgogishvili.projects.coordinates.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class LocationRequestModel {

    public Integer id;

    public String carNumber;

    public Double longitude;

    public Double latitude;

    public LocalDateTime getLastContactDate(LocalDateTime now) {
        return LocalDateTime.now();
    }
}
