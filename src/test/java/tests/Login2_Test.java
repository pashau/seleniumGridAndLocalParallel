package tests;

import helper.ThreadLocalDriverFactory;
import objects.pages.LoginPage;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Login2_Test extends BaseTest {

    @Test
    @DisplayName("Invalid Login Test")
    public void testInvalidLogin() {
        var loginPage = new LoginPage(ThreadLocalDriverFactory.getDriver());

        loginPage.login("locked_out_user", "secret_sauce");
        
        String error = loginPage.getErrorMessage();
        assertTrue(error.contains("Sorry, this user has been locked out"), 
            "Expected a lockout error message for the locked_out_user");
    }
}
