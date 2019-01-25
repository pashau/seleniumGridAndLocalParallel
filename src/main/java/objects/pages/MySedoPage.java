package objects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

//Login-Area
public class MySedoPage extends BasePage {

    //*********Constructor*********
    public MySedoPage (WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********


    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.XPATH, using = "//*[@id='logo']/a")
    public WebElement SedoLogoLink;

    @FindBy(how = How.XPATH, using = "//main//h1")
    public WebElement contentHeadText;

    @FindBy(how = How.XPATH, using = "(//div[@class='contenthead'])[1]")
    public WebElement welcomeText;

    //*********Page Methods*********
    //Go to Homepage
    public HomePage AndIGoToHomePage(){
        click(SedoLogoLink);
        return new PageFactory().initElements(driver, HomePage.class);
    }

    public MySedoPage ThenIVerifySuccessfulLogin(String expectedText) {
        assertThat(readText(contentHeadText), containsString(expectedText));
        return this;
    }

    public MySedoPage ThenIVerifyCustomerName(String expectedName) {
        assertThat(readText(welcomeText), containsString(expectedName));
        return this;
    }
}
