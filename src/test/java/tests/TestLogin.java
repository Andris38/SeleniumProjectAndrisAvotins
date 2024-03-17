package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

    @Test
    public void testLoginWithWrongCredentials() {
        qaProjectLoginPage.login("test@asdsa.com", "test");
        Assert.assertEquals(qaProjectLoginPage.getErrorMessage(), "These credentials do not match our records.");
    }

    @Test
    public void testLoginWithNoPassword() {
        qaProjectLoginPage.login("test@asdsa.com", "");
        Assert.assertEquals(qaProjectLoginPage.getValidationErrorMessage(qaProjectLoginPage.passwordInput), "Please fill in this field.");
    }

    @Test
    public void testLoginWithNoUsername() {
        qaProjectLoginPage.login("", "test");
        Assert.assertEquals(qaProjectLoginPage.getValidationErrorMessage(qaProjectLoginPage.emailInput), "Please fill in this field.");
    }

    @Test
    public void testLoginWithNoUsernameNoPassword() {
        qaProjectLoginPage.login("", "");
        Assert.assertEquals(qaProjectLoginPage.getValidationErrorMessage(qaProjectLoginPage.emailInput), "Please fill in this field.");
    }

    @Test
    public void testWrongEmailInput() {
        String username = "dasda";
        qaProjectLoginPage.login(username, "asdas");
        //Method String format allows us to use template and insert predefined strings. Example here : https://codegym.cc/groups/posts/string-format
        Assert.assertEquals(qaProjectLoginPage.getValidationErrorMessage(qaProjectLoginPage.emailInput),
                String.format("Please include an '@' in the email address. '%s' is missing an '@'.", username));
    }

    @Test
    public void testSuccessfulLogin() {
        qaProjectLoginPage.login("emilysinclair@gmail.com", "qwerty123456#");
        Assert.assertEquals(homePage.getWelcomeMessage(), "Welcome, Sinclair! You are logged in!");
    }

    @BeforeMethod
    public void navigateToLoginPage(){
        navigateToPage("https://qaproject.acodemy.lv/login");
    }

}




