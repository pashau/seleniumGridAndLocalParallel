package helper;

import com.google.common.collect.ImmutableMap;
import java.io.*;
import java.util.*;
import java.util.Map;
import java.util.Properties;

/*
 * constants & Properties
 * https://www.codeproject.com/Articles/189489/Java-Properties-Example-using-Singleton-Pattern
 */
public class Constants {
    // Properties (user configurable)
    public final String BROWSER;
    public final boolean IS_REMOTE;
    public final String TEST_ENVIRONMENT;

    // Constants (not user configurable)
    private static final String PATH_CONFIGFILE = "target/test-classes/config.properties";
    public static final String GRID_URL = "http://localhost:4444/wd/hub";
    public static final Map<String, String> BASEURL_MAP = ImmutableMap.of(
            "DEMO", "https://www.saucedemo.com/",
            "TEST", "https://www.saucedemo.com/"
    );

    private Constants() {
            Properties props = new Properties();
        try (InputStream file = new FileInputStream(new File(PATH_CONFIGFILE))) {
            props.load(file);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to load config.properties from " + PATH_CONFIGFILE, e);
        }

        this.BROWSER = props.getProperty("browser");
        this.TEST_ENVIRONMENT = props.getProperty("testEnvironment");
        this.IS_REMOTE = Boolean.parseBoolean(props.getProperty("isRemote"));
    }

    private static class Holder {
        private static final Constants INSTANCE = new Constants();
        }

    public static Constants instance() {
        return Holder.INSTANCE;
    }
}