package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import static helper.DriverOptionsManager.getChromeOptions;
import static helper.DriverOptionsManager.getFirefoxOptions;

public class ThreadLocalDriverFactory {

    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static final Constants conf = Constants.instance();

    public static void setDriver(String browser) {
        WebDriver driver;
        if (conf.IS_REMOTE) {
            try {
                URL gridUrl = new URL(conf.GRID_URL);
                driver = browser.equalsIgnoreCase("FIREFOX")
                    ? new RemoteWebDriver(gridUrl, getFirefoxOptions())
                    : new RemoteWebDriver(gridUrl, getChromeOptions());
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Grid URL: " + conf.GRID_URL, e);
            }
        } else {
            driver = browser.equalsIgnoreCase("FIREFOX")
                ? new FirefoxDriver(getFirefoxOptions())
                : new ChromeDriver(getChromeOptions());
        }
        tlDriver.set(driver);
    }
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }

//    public  void setDriverAndWait(){
//        setDriver(conf.BROWSER);
//        wait = new WebDriverWait(getDriver(), 15);
//    }

//    public static synchronized WebDriverWait getWait (WebDriver driver) {
//        return new WebDriverWait(driver,20);
//    }
}