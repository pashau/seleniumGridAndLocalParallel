package objects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class CasPage extends BasePage {

    //*********Constructor*********
    public CasPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements by using Page Factory*********
    @FindBy(how = How.ID, using = "username")
    public WebElement usernameInput;

    @FindBy(how = How.ID, using = "password")
    public WebElement passwordInput;

    @FindBy(how = How.NAME, using = "submit-login")
    public WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//a[starts-with(@href, '/member/register.php')]")
    public WebElement registerLink;

    @FindBy(how = How.XPATH, using = "//*[@id='msg' and @class='note warning']")
    public WebElement errorMessage;


    //*********Page Methods*********
    public CasPage AndIloginFromCas(String username, String password) {
        writeText(usernameInput, username);
        writeText(passwordInput, password);
        click(loginButton);
        return this;
    }

    public CasPage ThenIVerifyErrorMsgContains(String expectedText) {
        assertThat(readText(errorMessage), containsString(expectedText));
        return this;
    }
    public CasPage ThenIVerifyErrorMsgNotContains(String expectedText) {
        assertThat(readText(errorMessage), not(containsString(expectedText)));
        return this;
    }
}