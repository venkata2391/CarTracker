package egen.io.repository;

import egen.io.entity.VehicleReadings;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Ananth on 6/28/2017.
 */
@Repository
public class VehicleReadingsRepositoryImpl implements VehicleReadingsRepository {

    @PersistenceContext
    EntityManager entityManager;

  //  VehicleProperties properties = new VehicleProperties();

    public void updateVehicleReadings(VehicleReadings readings) {
              entityManager.persist(readings);

    }
}
