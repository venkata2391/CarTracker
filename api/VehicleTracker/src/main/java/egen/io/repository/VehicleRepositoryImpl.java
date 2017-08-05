package egen.io.repository;

import egen.io.VehicleProperties;
import egen.io.entity.Vehicle;
import egen.io.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import org.apache.log4j.Logger;
/**
 * Created by Ananth on 6/24/2017.
 */
@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    final static VehicleProperties properties = new VehicleProperties();
    final static Logger logger = Logger.getLogger(VehicleRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

        public List<Vehicle> listAllVehicles(){
            try {
                logger.debug("retrieving list of vehicles - In vehicle Repository");
                TypedQuery<Vehicle> query = entityManager.createQuery("SELECT vehicle FROM Vehicle vehicle", Vehicle.class);
                return query.getResultList();
            }
            catch (Exception exception){
                throw new BadRequestException(" retrieving of vehicles failed");
            }
    }

     public String insertListOfVehicles(List<Vehicle> vehicles) {
        try {
            logger.debug("Inserting list of vehicles - In vehicle Repository");
            for (Vehicle vehicle : vehicles) {
                if (entityManager.find(Vehicle.class, vehicle.getVin()) == null) {
                    logger.info("inserting vehicle with VIN "+vehicle.getVin());
                    entityManager.persist(vehicle);
                } else {
                    logger.info("updating vehicle with VIN "+vehicle.getVin());
                    entityManager.merge(vehicle);
                }
            }
        }
        catch(Exception exception){
            logger.error("Exception while Inserting list of vehicles "+ exception.getLocalizedMessage());
            return exception.getLocalizedMessage();
        }
        return properties.getPropertyValue("insertVehicles");
    }

    public Vehicle findVehicleByVIN(String vin){
            return entityManager.find(Vehicle.class,vin);
    }
}
