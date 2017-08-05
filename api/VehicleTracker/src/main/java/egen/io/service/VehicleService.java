package egen.io.service;

import egen.io.entity.Vehicle;
import egen.io.entity.VehicleReadings;

import java.util.List;

/**
 * Created by Ananth on 6/24/2017.
 */
public interface VehicleService {
     List<Vehicle> listAllVehicles();
     String insertListOfVehicles(List<Vehicle> vehicles);
}
