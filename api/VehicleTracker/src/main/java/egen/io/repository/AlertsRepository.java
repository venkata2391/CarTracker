package egen.io.repository;

import egen.io.entity.Alert;
import egen.io.entity.VehicleReadings;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Ananth on 7/21/2017.
 */
public interface AlertsRepository {
     List<Alert> getHighAlerts();
     List<Alert> getAlertsByVIN(String vin);
}
