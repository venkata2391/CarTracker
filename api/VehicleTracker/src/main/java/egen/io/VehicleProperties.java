package egen.io;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Ananth on 6/28/2017.
 */
public class VehicleProperties {


        private Properties myProperties;

        public VehicleProperties() {
            try {
                myProperties = new Properties();
                InputStream myPropertiesInputStream = this.getClass().getClassLoader()
                                        .getResourceAsStream("errorMessages.properties");
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
