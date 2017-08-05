package egen.io.repository;

import egen.io.entity.Vehicle;
import egen.io.entity.VehicleReadings;

import java.util.List;

/**
 * Created by Ananth on 6/24/2017.
 */
public interface VehicleRepository {

    List<Vehicle> listAllVehicles();

    String insertListOfVehicles(List<Vehicle> vehicles);

    Vehicle findVehicleByVIN(String vin);

}
