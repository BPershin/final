package proj.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
    private static final Properties properties = new Properties();
    private static  TestProperties instance = null;

    private TestProperties() {
        try {
            properties.load(new FileInputStream("src/environment.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static TestProperties getInstance() {
        if (instance == null) {
            instance = new TestProperties();
        }
        return instance;
    }

    public static Properties getProperties() {
        return properties;
    }
}
