package egen.io.controller;

import egen.io.VehicleProperties;
import egen.io.entity.Vehicle;

import egen.io.exception.BadRequestException;
import egen.io.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import java.util.List;



/**
 * Created by Ananth on 6/24/2017.
 */

//@CrossOrigin(origins ={"http://mocker.egen.io","http://localhost:63342/*"})
@RequestMapping(value="/vehicles")
@RestController
public class VehicleController {

    @Autowired
    VehicleService service;

    final static  Logger logger = Logger.getLogger("VehicleController.class");
    final static VehicleProperties property = new VehicleProperties();

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String insertListOfVehicles(@RequestBody List<Vehicle> vehicles){
        logger.info("request for inserting  list of vehicles - start "+System.currentTimeMillis());
        if(vehicles.size()!=0) {
            return service.insertListOfVehicles(vehicles);
        }
        else{
            logger.error("Insertion of Vehicles failed as no vehicles present in the request body");
            throw new BadRequestException(property.getPropertyValue("nullVehicles"));
        }
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> listAllVehicles(){
        logger.info("Request for showing list of vehicles - start "+System.currentTimeMillis());
        return service.listAllVehicles();
    }



}
