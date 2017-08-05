package egen.io.controller;

import egen.io.entity.Alert;
import egen.io.service.AlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Ananth on 7/21/2017.
 */
@CrossOrigin
@RequestMapping("/alerts")
@RestController
public class AlertsController {

    @Autowired
    AlertsService alertsService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Alert> getHighAlerts(){
        return alertsService.getHighAlerts();
    }

    @RequestMapping(value = "/getAlertsByVIN/{vin}",method = RequestMethod.GET)
    public List<Alert> getAlertsByVIN(@PathVariable("vin") String vin){
        return alertsService.getAlertsByVIN(vin);
    }
}
