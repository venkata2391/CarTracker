package egen.io;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Ananth on 6/28/2017.
 */
public class VehicleProperties {


        private Properties myProperties;

        public VehicleProperties() {
            File file = new File("../../resources/errorMessages.properties");
            try {
                myProperties = new Properties();
                FileInputStream myPropertiesInputStream = new FileInputStream(file);
                myProperties.load(myPropertiesInputStream);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String getPropertyValue(String key) {
            return myProperties.getProperty(key);
        }

    }
