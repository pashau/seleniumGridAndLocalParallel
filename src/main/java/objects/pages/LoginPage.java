package objects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String pass) {
        writeText(usernameField, user);
        writeText(passwordField, pass);
        click(loginButton);
    }

    public String getErrorMessage() {
        return readText(errorMessage);
    }
}
