package egen.io.controller;

import egen.io.VehicleProperties;
import egen.io.entity.VehicleReadings;
import egen.io.exception.BadRequestException;
import egen.io.service.VehicleReadingsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ananth on 6/28/2017.
 */

@CrossOrigin(origins = "http://mocker.egen.io")
@RequestMapping(value="/readings")
@RestController
public class VehicleReadingsController {

    @Autowired
    VehicleReadingsService service;
    final static VehicleProperties property = new VehicleProperties();

    final static Logger logger = Logger.getLogger(VehicleReadingsController.class);

   @RequestMapping(method = RequestMethod.POST)
    public String insertVehicleReadings(@RequestBody VehicleReadings readings) {
       if(readings!=null){
           logger.info("Request to update the vehicle readings -  start "+System.currentTimeMillis());
           return service.insertVehicleReadings(readings);
       }else {
           logger.error(property.getPropertyValue("errorReadings"));
            throw new BadRequestException(property.getPropertyValue("nullReadings"));
       }
    }

    @RequestMapping(value="/getVehicleReadingsByVIN/{vin}",method = RequestMethod.GET)
    public List<VehicleReadings> getVehicleReadingsByVIN(@PathVariable String vin){
       return service.getVehicleReadingsByVIN(vin);

    }

    public static void main(String args[]) {

    }

}
