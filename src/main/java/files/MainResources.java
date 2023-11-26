package files;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainResources {

    public static void main(String[] args) {

        InputStream resourceAsStream = MainResources.class.getResourceAsStream("/settings.properties");

        if (resourceAsStream != null) {
            Properties properties = new Properties();
            try {
                properties.load(resourceAsStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String property = properties.getProperty("some.setting");

            if (property != null) {
                System.out.println(property);
            }
        }
    }

}
