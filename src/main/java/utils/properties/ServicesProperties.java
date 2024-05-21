package utils.properties;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ServicesProperties {

    private static Properties prop = null;

    private ServicesProperties() throws IOException {
        throw new IllegalStateException();
    }
    public static void loadProperties() throws IOException {
        if (prop == null) {
            prop = new Properties();
            File objclasspathRoot = new File(System.getProperty("user.dir"));
            String strFilePath = objclasspathRoot.getAbsolutePath();
            prop.load(new FileReader(strFilePath + "/services.properties"));
        }
    }

    public static String getProperties(String properties) throws IOException {
        loadProperties();
        return prop.getProperty(properties);
    }
}