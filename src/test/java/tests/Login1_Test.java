package tests;

import helper.Constants;
import helper.ThreadLocalDriverFactory;
import objects.pages.AccountPage;
import objects.pages.LoginPage;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Login1_Test extends BaseTest {

    @Test
    @DisplayName("Successful Login Test")
    public void testSuccessfulLogin() {
        var loginPage = new LoginPage(ThreadLocalDriverFactory.getDriver());
        var accountPage = new AccountPage(ThreadLocalDriverFactory.getDriver());

        loginPage.login("standard_user", "secret_sauce");
        
        String title = accountPage.getPageTitle();
        assertEquals("Products", title, "The page title should be 'Products' after login");
        
        accountPage.logout();
    }
}
