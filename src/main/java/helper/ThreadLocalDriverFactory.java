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

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    static Constants conf = Constants.instance();

    public synchronized static void setDriver(String browser) {
        if(conf.IS_REMOTE){
            // RemoteDriver
            if (browser.equals("FIREFOX")) { try {
                tlDriver.set(new RemoteWebDriver(new URL(conf.GRID_URL), getFirefoxOptions()));
                    } catch (MalformedURLException e) { e.printStackTrace(); }
            } else if (browser.equals("CHROME")) { try {
                tlDriver.set(new RemoteWebDriver(new URL(conf.GRID_URL), getChromeOptions()));
                    } catch (MalformedURLException e) { e.printStackTrace(); }
            }
        } else {
            // LocalDriver
            if (browser.equals("FIREFOX")) {
                tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(getFirefoxOptions()));
            } else if (browser.equals("CHROME")) {
                //tlDriver.set(new ChromeDriver(getChromeOptions()));
                tlDriver = ThreadLocal.withInitial(() -> new ChromeDriver(getChromeOptions()));
            }
        }
    }

    public synchronized static WebDriver getDriver() {
        System.out.println("###DEBUG#T#TLDriverFactory#getDriver() 1");
        return tlDriver.get();
    }


//    public  void setDriverAndWait(){
//        setDriver(conf.BROWSER);
//        wait = new WebDriverWait(getDriver(), 15);
//    }

//    public static synchronized WebDriverWait getWait (WebDriver driver) {
//        return new WebDriverWait(driver,20);
//    }
}