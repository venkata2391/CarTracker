package egen.io.service;

import egen.io.entity.VehicleReadings;
import egen.io.repository.VehicleReadingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Ananth on 6/28/2017.
 */
@Service
public class VehicleReadingsServiceImpl implements VehicleReadingsService {

    @Autowired
    VehicleReadingsRepository readingsRepository;

    @Transactional
    public void updateVehicleReadings(VehicleReadings readings) {

        readingsRepository.updateVehicleReadings(readings);
    }

}
