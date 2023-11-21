

package ge.davidgogishvili.projects.coordinates.Services;

import ge.davidgogishvili.projects.coordinates.Entities.VehicleLocations;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CoordinateUploadService {



    public static boolean isValidExcelFile(MultipartFile file) {
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    public static List<VehicleLocations> getCoordinatesDataFromExcel(InputStream inputStream) throws IOException {
        List<VehicleLocations> coordinates = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowIndex = 0;
            for (Row row : sheet) {
                if (rowIndex == 0) {
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                VehicleLocations vehicleLocations = new VehicleLocations();

                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex) {
                        case 0 -> vehicleLocations.setLongitude(cell.getNumericCellValue());
                        case 1 -> vehicleLocations.setLatitude(cell.getNumericCellValue());
                        case 2 -> vehicleLocations.setCarNumber(cell.getStringCellValue());
                        default ->  {

                        }
                    }
                    cellIndex ++;
                }
                coordinates.add(vehicleLocations);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return coordinates;

    }


}
