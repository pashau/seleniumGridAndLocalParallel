package tests;

import helper.Customer;
import objects.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class Login2_Test extends BaseTest {
    private static final Customer SELLER = Customer.getSellerGmbh();

    @Test
    public void validLoginTest_validUserNameValidPassword2() {
        page.getPage(HomePage.class)
                .GivenIAmAtHomePage()
                .WhenIOpenLoginBox()
                .AndIloginSuccessful(SELLER.getLoginName(), SELLER.getPw())
                .ThenIVerifySuccessfulLogin("My Sedo")
                .ThenIVerifyCustomerName(SELLER.getForename());
        ;
    }

    @Test
    public void invalidLoginTest_InvalidUserNameInvalidPassword2() {
        page.getPage(HomePage.class)
                .GivenIAmAtHomePage()
                .WhenIOpenLoginBox()
                .AndIloginUnsuccessful("invalidUser", "invalidPass")
                .ThenIVerifyErrorMsgContains("The username and password entered do not match our records. Please ensure that you enter your Sedo username and not your email address.")
        ;
    }

    @Test
    public void invalidLoginTest_EmptyUserEmptyPassword2() {
        page.getPage(HomePage.class)
                .GivenIAmAtHomePage()
                .WhenIOpenLoginBox()
                .AndIloginUnsuccessful("", "")
                .ThenIVerifyErrorMsgContains("Username is a required field.")
                .ThenIVerifyErrorMsgContains("Password is a required field.")
        ;
    }
}
