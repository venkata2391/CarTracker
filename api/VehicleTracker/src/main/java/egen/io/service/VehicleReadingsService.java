package egen.io.service;

import egen.io.entity.VehicleReadings;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Ananth on 6/28/2017.
 */
public interface VehicleReadingsService {
    String insertVehicleReadings(VehicleReadings readings);
    List<VehicleReadings> getVehicleReadingsByVIN( String vin);
    void checkAlerts(VehicleReadings readings);

}
