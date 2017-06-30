package egen.io.controller;

import egen.io.entity.Vehicle;

import egen.io.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Ananth on 6/24/2017.
 */

@CrossOrigin(origins = "http://mocker.egen.io")
@RestController
@RequestMapping(value="/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;

    @RequestMapping(method = RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> insertListOfVehicles(@RequestBody List<Vehicle> vehicles){

            return service.insertListOfVehicles(vehicles);
    }


    @RequestMapping(value="/vehicles",method = RequestMethod.GET)
    public List<Vehicle> listAllVehicles(){
        return service.listAllVehicles();
    }

}
