package tests;

import helper.Constants;
import helper.ThreadLocalDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void setUp() {
        // 1. Treiber initialisieren (Chrome/Firefox je nach Config)
        ThreadLocalDriverFactory.setDriver(Constants.instance().BROWSER);
        
        // 2. Zur Demo-URL navigieren <--- DAS HAT GEFEHLT
        String baseUrl = Constants.instance().BASEURL_MAP.get("DEMO");
        ThreadLocalDriverFactory.getDriver().get(baseUrl);
    }

    @AfterEach
    public void tearDown() {
        // Treiber sauber schließen
        ThreadLocalDriverFactory.quitDriver();
    }
}