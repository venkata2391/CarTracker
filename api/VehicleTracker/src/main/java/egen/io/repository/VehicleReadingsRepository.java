package egen.io.repository;

import egen.io.entity.Alert;
import egen.io.entity.VehicleReadings;

import java.util.List;

/**
 * Created by Ananth on 6/28/2017.
 */
public interface VehicleReadingsRepository {

    String insertVehicleReadings(VehicleReadings readings);

    void insertAlert(Alert alert);
     List<VehicleReadings> getVehicleReadingsByVIN(String vin);

}
