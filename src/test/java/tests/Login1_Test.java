package tests;

import helper.Customer;
import objects.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class Login1_Test extends BaseTest {

    private static final Customer BUYER = Customer.getBuyerGmbh();

//    @BeforeAll
//    public static void setup() {
//        super.setup();
//        BUYER = Customer.getBuyerGmbh();
//    }

    @Test
    public void validLoginTest_validUserNameValidPassword() {
        page.getPage(HomePage.class)
                .GivenIAmAtHomePage()
                .WhenIOpenLoginBox()
                .AndIloginSuccessful(BUYER.getLoginName(), BUYER.getPw())
                .ThenIVerifySuccessfulLogin("My Sedo")
        ;
    }

    @Test
    public void invalidLoginTest_InvalidUserNameInvalidPassword() {
        page.getPage(HomePage.class)
                .GivenIAmAtHomePage()
                .WhenIOpenLoginBox()
                .AndIloginUnsuccessful("invalidUser", "invalidPass")
                .ThenIVerifyErrorMsgContains("The username and password entered do not match our records. Please ensure that you enter your Sedo username and not your email address.")
        ;
    }

    @Test
    public void invalidLoginTest_EmptyUserEmptyPassword() {
        page.getPage(HomePage.class)
                .GivenIAmAtHomePage()
                .WhenIOpenLoginBox()
                .AndIloginUnsuccessful("", "")
                .ThenIVerifyErrorMsgContains("Username is a required field.")
                .ThenIVerifyErrorMsgContains("Password is a required field.")
        ;

    }
}
