package objects.fragments;

import objects.pages.CasPage;
import objects.pages.HomePage;
import objects.pages.MySedoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//TODO: Maybe include in HomePage? or in Header?
public class LoginBox extends HomePage {

    //*********Constructor*********
    public LoginBox(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements by using Page Factory*********
    @FindBy(how = How.NAME, using = "user")
    public WebElement usernameInput;

    @FindBy(how = How.NAME, using = "pass")
    public WebElement passwordInput;

    @FindBy(how = How.NAME, using = "login")
    public WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@id='loginbox-wrapper']//a")
    public WebElement toggleLoginBoxButton;


    //*********Page Methods*********
    public MySedoPage AndIloginSuccessful(String username, String password){
        writeText(usernameInput,username);
        writeText(passwordInput, password);
        click(loginButton);
        return new PageFactory().initElements(driver, MySedoPage.class);
    }

    public CasPage AndIloginUnsuccessful(String username, String password){
        writeText(usernameInput,username);
        writeText(passwordInput, password);
        click(loginButton);
        return new PageFactory().initElements(driver, CasPage.class);
    }

    public HomePage AndICloseLoginBox(){
        click(toggleLoginBoxButton);
        return new PageFactory().initElements(driver, HomePage.class);
    }
}
