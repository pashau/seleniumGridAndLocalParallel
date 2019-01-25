package objects.pages;

import helper.Constants;
import objects.fragments.LoginBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage (WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    private static Constants conf = Constants.instance();
    private String baseURL = conf.BASEURL_MAP.get(conf.TEST_ENVIRONMENT);

    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.XPATH, using = "//*[@id='loginbox-wrapper']//a")
    public WebElement toggleLoginBoxButton;

    //*********Page Methods*********
    //Go to Homepage
    public HomePage GivenIAmAtHomePage(){

        driver.get(baseURL);
        return this;
    }

    //Open/Close to LoginBox
    public LoginBox WhenIOpenLoginBox(){
        click(toggleLoginBoxButton);
        return new PageFactory().initElements(driver, LoginBox.class);
    }
}
