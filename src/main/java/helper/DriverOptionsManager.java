package helper;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.HashMap;
import java.util.Map;

public class DriverOptionsManager {

    //Get Chrome Options
    public static ChromeOptions getChromeOptions() {
        var options = new ChromeOptions();
        
        // 1. Grundlegende Argumente
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        
        // 2. Chrome Preferences (lösen das Password Manager & Leak Detection Problem)
        Map<String, Object> prefs = new HashMap<>();
        
        // Deaktiviert die Warnung "Passwort in einer Datenpanne gefunden"
        prefs.put("profile.password_manager_leak_detection", false); 
        
        // Deaktiviert den Standard-Chrome-Prompt "Passwort speichern?"
        prefs.put("credentials_enable_service", false); 
        
        // Deaktiviert den Passwort-Manager komplett
        prefs.put("profile.password_manager_enabled", false);
        
        options.setExperimentalOption("prefs", prefs);
        
        return options;
    }

    //Get Firefox Options
    public static FirefoxOptions getFirefoxOptions() {
        var options = new FirefoxOptions();
        options.addPreference("network.proxy.type", 0);
        options.setAcceptInsecureCerts(true);
        return options;
    }
}