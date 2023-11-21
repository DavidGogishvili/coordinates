//package ge.davidgogishvili.projects.coordinates.Services;
//import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocations;
//import ge.davidgogishvili.projects.coordinates.Repositories.VehicleLocationsRepo;
//import lombok.AllArgsConstructor;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class CoordinateService {
//
//    private VehicleLocationsRepo vehicleLocationsRepo;
//
//    public void saveCoordinatesToDatabase (MultipartFile file) {
//        if (CoordinateUploadService.isValidExcelFile(file)) {
//            try {
//                List<VehicleLocations> vehicleLocations = CoordinateUploadService.getCoordinatesDataFromExcel(file.getInputStream());
//                this.vehicleLocationsRepo.saveAll(vehicleLocations);
//            } catch (IOException e) {
//                try {
//                    throw new IllegalAccessException("The file is not valid");
//                } catch (IllegalAccessException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        }
//    }
//}


package ge.davidgogishvili.projects.coordinates.Services;

import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocationHistory;
import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocations;
import ge.davidgogishvili.projects.coordinates.Repositories.VehicleLocationHistoryRepo;
import ge.davidgogishvili.projects.coordinates.Repositories.VehicleLocationsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CoordinateService {

    private VehicleLocationsRepo vehicleLocationsRepo;
    private VehicleLocationHistoryRepo vehicleLocationHistoryRepo;

    public void saveCoordinatesToDatabase(MultipartFile file) {
        if (CoordinateUploadService.isValidExcelFile(file)) {
            try {
                List<VehicleLocations> vehicleLocations = CoordinateUploadService.getCoordinatesDataFromExcel(file.getInputStream());

                this.vehicleLocationsRepo.saveAll(vehicleLocations);

                for (VehicleLocations location : vehicleLocations) {
                    VehicleLocationHistory historyEntry = createHistoryEntry(location);
                    this.vehicleLocationHistoryRepo.save(historyEntry);
                }
            } catch (IOException e) {
                throw new RuntimeException("Error processing the file", e);
            }
        } else {
            throw new IllegalArgumentException("Invalid file format");
        }
    }

    private VehicleLocationHistory createHistoryEntry(VehicleLocations location) {
        VehicleLocationHistory historyEntry = new VehicleLocationHistory();
        historyEntry.setCarNumber(location.getCarNumber());
        historyEntry.setLongitude(location.getLongitude());
        historyEntry.setLatitude(location.getLatitude());
        historyEntry.setLastContactDate(LocalDateTime.now());
        return historyEntry;
    }
}
