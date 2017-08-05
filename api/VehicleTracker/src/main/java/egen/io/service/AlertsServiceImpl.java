package egen.io.service;

import egen.io.entity.Alert;
import egen.io.repository.AlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ananth on 7/21/2017.
 */
@Service
public class AlertsServiceImpl implements AlertsService {

    @Autowired
    AlertsRepository repository;

    public List<Alert> getHighAlerts(){

        List<Alert> alerts = repository.getHighAlerts();
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        List<Alert> highAlerts = new ArrayList<Alert>();

        for(Alert alert : alerts){
               Long diff = timestamp.getTime() - alert.getTimestamp().getTime();
              diff = diff/(1000*60*60*24);
              if(diff<=2){
                  highAlerts.add(alert);
              }
        }
        return highAlerts;
    }

    public List<Alert> getAlertsByVIN(String vin){
        return repository.getAlertsByVIN(vin);
    }

}
