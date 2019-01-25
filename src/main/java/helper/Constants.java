package helper;

import com.google.common.collect.ImmutableMap;

import java.io.*;
import java.util.Map;
import java.util.Properties;
/*
 * constants & Properties
 * https://www.codeproject.com/Articles/189489/Java-Properties-Example-using-Singleton-Pattern
 */
public class Constants {
    static private Constants _instance = null;
    // Properties (user configurable)
    public static String BROWSER = null;
    public static boolean IS_REMOTE = true;
    public static String TEST_ENVIRONMENT = null;
    // Constants (not user configurable)
    private static final String PATH_CONFIGFILE = "target/test-classes/config.properties";
    public static final String GRID_URL = "http://selenium.stack.blaaaaa.de:30445/wd/hub"; // dummy
    public static final Map<String, String> BASEURL_MAP = ImmutableMap.of(
            "LIVE", "http://www.sedo.com/",
            "INTEGRATION", "http://integration.blaaaaa.de/",
            "STAGE", "http://stage.blaaaaa.de/"
    );

    private Constants(){
        try{
            InputStream file = new FileInputStream(new File(PATH_CONFIGFILE)) ;
            Properties props = new Properties();
            props.load(file);
            BROWSER = props.getProperty("browser");
            TEST_ENVIRONMENT = props.getProperty("testEnvironment");
            IS_REMOTE = Boolean.parseBoolean(props.getProperty("isRemote"));
        }
        catch(Exception e){
            System.out.println("error" + e);
        }
    }

    static public Constants instance(){
        if (_instance == null) {
            _instance = new Constants();
        }
        return _instance;
    }
}