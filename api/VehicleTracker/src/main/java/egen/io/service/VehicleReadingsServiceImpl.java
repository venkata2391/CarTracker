package egen.io.service;

import egen.io.VehicleProperties;
import egen.io.entity.Alert;
import egen.io.entity.Vehicle;
import egen.io.entity.VehicleReadings;
import egen.io.repository.VehicleReadingsRepository;
import egen.io.repository.VehicleRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ananth on 6/28/2017.
 */
@Service
public class VehicleReadingsServiceImpl implements VehicleReadingsService {

    @Autowired
    VehicleReadingsRepository readingsRepository;

    @Autowired
    VehicleRepository repository;

    final static Logger logger = Logger.getLogger(VehicleReadingsRepository.class);
    VehicleProperties properties = new VehicleProperties();

    @Transactional
    public String insertVehicleReadings(VehicleReadings readings) {
        logger.info("Inserting vehicle readings - In Service");
        if(readingsRepository.insertVehicleReadings(readings).equals(properties.getPropertyValue("successReadings"))){
            this.checkAlerts(readings);
            return readingsRepository.insertVehicleReadings(readings);
        }
        else{
            return properties.getPropertyValue("errorReadings");
        }
    }

    public void checkAlerts(VehicleReadings readings) {

       Vehicle vehicle = repository.findVehicleByVIN(readings.getVin());

         if(readings.getEngineRpm()>vehicle.getRedlineRpm()){
             Alert alert = new Alert();
             alert.setTimestamp(readings.getTimestamp());
            alert.setPriority("HIGH");
            logger.info(readings+" "+vehicle);
            alert.setVin(readings.getVin());
            alert.setAlertType("High Engine RPM");
            readingsRepository.insertAlert(alert);

        }
        if(readings.getFuelVolume()< (0.1*vehicle.getMaxFuelVolume())){
            Alert alert = new Alert();
            alert.setTimestamp(readings.getTimestamp());
            alert.setPriority("MEDIUM");
            alert.setVin(readings.getVin());
            alert.setAlertType("Low Fuel");
            readingsRepository.insertAlert(alert);
        }
        if((readings.getTires().getFrontLeft()<32 || readings.getTires().getFrontLeft()>36)&&
                (readings.getTires().getFrontRight()<32 || readings.getTires().getFrontRight()>36)&&
                (readings.getTires().getRearLeft()<32 || readings.getTires().getRearLeft()>36)&&
                (readings.getTires().getRearRight()<32 || readings.getTires().getRearRight()>36)
                || readings.getCheckEngineLightOn()==true || readings.getEngineCoolantLow() ==true){
            Alert alert = new Alert();
            alert.setTimestamp(readings.getTimestamp());
            alert.setPriority("LOW");
            alert.setVin(readings.getVin());
            alert.setAlertType("Tire Pressure");
            readingsRepository.insertAlert(alert);
         }
       if(readings.getCheckEngineLightOn()==true || readings.getEngineCoolantLow() ==true) {
           Alert alert = new Alert();
           alert.setTimestamp(readings.getTimestamp());
           alert.setPriority("LOW");
           alert.setVin(readings.getVin());
           alert.setAlertType("Engine Light on or Engine Coolant Low");
           readingsRepository.insertAlert(alert);
       }
    }

   public List<VehicleReadings> getVehicleReadingsByVIN(String vin){
        return readingsRepository.getVehicleReadingsByVIN(vin);
    }
}
