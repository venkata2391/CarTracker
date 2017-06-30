package egen.io.controller;

import egen.io.entity.VehicleReadings;
import egen.io.service.VehicleReadingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ananth on 6/28/2017.
 */

//@CrossOrigin(origins = "http://mocker.egen.io")
@RequestMapping(value="/readings")
@RestController
public class VehicleReadingsController {

    @Autowired
    VehicleReadingsService service;

   @RequestMapping(method = RequestMethod.POST)
    public void updateVehicleReadings(@RequestBody VehicleReadings readings) {
        service.updateVehicleReadings(readings);
    }
}
