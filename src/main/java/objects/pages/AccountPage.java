package objects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {

    private final By productTitle = By.className("title");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return readText(productTitle);
    }

    public void logout() {
        click(menuButton);
        click(logoutLink);
    }
}