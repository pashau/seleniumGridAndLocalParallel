package tests;

import helper.Constants;
import helper.PageGenerator;
import helper.ThreadLocalDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseTest {
    protected PageGenerator page;
    protected WebDriver driver;
    private Constants conf = Constants.instance();
    protected Logger LOG = LogManager.getLogger();

    @BeforeAll
    public static void setup(){
        //TO STUFF
    }


    @BeforeEach
    public void init(TestInfo testInfo) {

        //Set & Get ThreadLocal Driver with Browser
        ThreadLocalDriverFactory.setDriver(conf.BROWSER);
        driver = ThreadLocalDriverFactory.getDriver();
        page = new PageGenerator(driver);

        String testCaseName = testInfo.getTestMethod().get().getName();
        LOG.info("starting testcase: " + testCaseName);
    }

    @AfterEach
    public void finalize (TestInfo testInfo) {
        String testCaseName = testInfo.getTestMethod().get().getName();
        LOG.info("Test Method AfterInvocation is started. " + Thread.currentThread().getId());
        takeScreenshot(generateScreenshotName(testCaseName));
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    public static void tearDown(){
        //TO STUFF
    }

    private void takeScreenshot(String filename) {
        LOG.trace("Taking screenshot...");
        File screenshot;

        // Take screenshot (remote or local)
        if (conf.IS_REMOTE) {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        } else {
            screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        }

        // Save screenshot in target folder
        String folderName = "target/screens/" + this.getClass().getSimpleName();
        try {
            FileUtils.copyFile(screenshot, new File(folderName + "/" + filename));
        } catch (IOException e) {
            LOG.warn("Could not save screenshot: ", e);
        }
        LOG.trace("Screenshot saved successfully. File name: " + filename);
    }

    protected String generateScreenshotName(String testCaseName) {
        String currentDate = new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS").format(new Date());
        return testCaseName + "_" + currentDate + ".jpg";
    }
}
