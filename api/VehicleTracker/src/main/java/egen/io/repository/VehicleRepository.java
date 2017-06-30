package egen.io.repository;

import egen.io.entity.Vehicle;
import egen.io.entity.VehicleReadings;

import java.util.List;

/**
 * Created by Ananth on 6/24/2017.
 */
public interface VehicleRepository {

    List<Vehicle> listAllVehicles();

    List<Vehicle> insertListOfVehicles(List<Vehicle> vehicles);

}
