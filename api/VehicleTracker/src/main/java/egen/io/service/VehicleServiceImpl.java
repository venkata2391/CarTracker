package egen.io.service;

import egen.io.entity.Vehicle;
import egen.io.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ananth on 6/24/2017.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;
    public List<Vehicle> listAllVehicles(){
        return repository.listAllVehicles();
    }


    @Transactional
    public List<Vehicle> insertListOfVehicles(List<Vehicle> vehicles) {
        if (vehicles!=null) {
            return repository.insertListOfVehicles(vehicles);
        }else{
            return null;
        }
    }

}
