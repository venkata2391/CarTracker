package egen.io.repository;

import egen.io.VehicleProperties;
import egen.io.entity.Alert;
import egen.io.entity.Vehicle;
import egen.io.entity.VehicleReadings;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Ananth on 6/28/2017.
 */
@Repository
public class VehicleReadingsRepositoryImpl implements VehicleReadingsRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    VehicleRepository repository;

    final static Logger logger = Logger.getLogger(VehicleReadingsRepositoryImpl.class);
    final static  VehicleProperties properties = new VehicleProperties();

    public String insertVehicleReadings(VehicleReadings readings) {
        try {
            logger.info("inserting vehicle reading for vehicle with VIN "+readings.getVin()+" is successful");
            entityManager.persist(readings);
            return properties.getPropertyValue("successReadings");
        }
        catch(Exception exception){
            logger.error("Exception occurred while inserting the vehicle readings"+ exception.getLocalizedMessage());
            return exception.getLocalizedMessage();
        }

    }

    public void insertAlert(Alert alert) {
        entityManager.persist(alert);
    }

    public List<VehicleReadings> getVehicleReadingsByVIN(String vin){

        TypedQuery<VehicleReadings> query = entityManager.createQuery("SELECT vr FROM VehicleReadings vr where vr.vin LIKE :vin",VehicleReadings.class).setParameter("vin",vin);
        return query.getResultList();
    }
}
