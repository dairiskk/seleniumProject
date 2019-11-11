package Helpers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {

    private static Properties props = null;
    private static ConfigReader instance = null;
    private static final String DEFAULT_PROPERTIES = "config.properties";
    private static final String CONFIG_PATH =System.getProperty("user.dir")+ File.separator;

    private ConfigReader() {
        props = new Properties();
        try {
            if (Files.isReadable(Paths.get(CONFIG_PATH + DEFAULT_PROPERTIES))) {
                File initialFile = new File(CONFIG_PATH + DEFAULT_PROPERTIES);
                InputStream targetStream = new FileInputStream(initialFile);
                props.load(targetStream);
            } else {
                throw new IOException("Properties file does not exist");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static synchronized ConfigReader getInstance() {
        if (instance == null) instance = new ConfigReader();
        return instance;
    }

    public String getValue(String key) {
        if (System.getProperty(key) != null) {
            return System.getProperty(key);
        } else if (props.containsKey(key)) {
            return props.getProperty(key);
        }
        return null;
    }
}
