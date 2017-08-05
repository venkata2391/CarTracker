package egen.io.repository;

import egen.io.entity.Alert;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Ananth on 7/21/2017.
 */
@Repository
public class AlertsRepositoryImpl implements AlertsRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Alert> getHighAlerts(){

        TypedQuery<Alert> query = entityManager.createQuery("SELECT alert FROM Alert alert where alert.priority LIKE :priority",Alert.class).setParameter("priority","HIGH");
        return query.getResultList();
    }
    public List<Alert> getAlertsByVIN(String vin){

        TypedQuery<Alert> query = entityManager.createQuery("SELECT alert FROM Alert alert where alert.vin LIKE :vin",Alert.class).setParameter("vin",vin);
        return query.getResultList();
    }
}
