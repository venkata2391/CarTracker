package egen.io.repository;

import egen.io.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Ananth on 6/24/2017.
 */
@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

        public List<Vehicle> listAllVehicles(){
            TypedQuery<Vehicle> query =  entityManager.createQuery("SELECT vehicle FROM Vehicle vehicle",Vehicle.class);
            return query.getResultList();
    }

     public List<Vehicle> insertListOfVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles){
            if(entityManager.find(Vehicle.class,vehicle.getVin())==null) {
                entityManager.persist(vehicle);
            }
            else{
                entityManager.merge(vehicle);
            }
        }
        return vehicles;
    }

}
