package egen.io.service;

import egen.io.entity.Alert;

import java.util.List;

/**
 * Created by Ananth on 7/21/2017.
 */
public interface AlertsService {
     List<Alert> getHighAlerts();
     List<Alert> getAlertsByVIN(String vin);
}
