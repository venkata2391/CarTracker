package egen.io.service;

import egen.io.entity.Vehicle;
import egen.io.repository.VehicleRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ananth on 6/24/2017.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    final static Logger logger  =  Logger.getLogger(VehicleServiceImpl.class);

    @Autowired
    VehicleRepository repository;
    public List<Vehicle> listAllVehicles(){
        logger.info("retrieving list of vehicles  -  In service Layer");
        return repository.listAllVehicles();
    }


    @Transactional
    public String insertListOfVehicles(List<Vehicle> vehicles) {
        logger.info("Insertion of vehicles  -  In service Layer");
        return repository.insertListOfVehicles(vehicles);
    }

}
