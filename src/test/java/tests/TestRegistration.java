package tests;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import models.UserModel;

public class TestRegistration extends BaseTest {

    @Test
    public void testSuccessfulUserRegistration() {
        //we just create user object with constructor passing all the parameters
        UserModel user = new UserModel(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(),
                DateFormatUtils.format(faker.date().birthday(), "MM/dd/YYYY"), faker.internet().password());
        //we call method register user where we pass user object and set agreeToTerms&Conditions to true
        registrationPage.registerUser(user, true);
        //we get user last name from our user object and assert the message after we register in the homepage
        Assert.assertEquals(homePage.getWelcomeMessage(), "Welcome, " + user.getLastName() + "! You are logged in!");
    }

    @Test
    public void testUnSuccessfulUserRegistrationCheckboxNotChecked() {
        //we just create user object with constructor passing all the parameters
        UserModel user = new UserModel(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(),
                DateFormatUtils.format(faker.date().birthday(), "MM/dd/YYYY"), faker.internet().password());
        //we call method register user where we pass user object and set agreeToTerms&Conditions to true
        registrationPage.registerUser(user, false);
        //we assert that we are still on the register page
        Assert.assertEquals(registrationPage.getCardHeaderText(), "Register");
    }

    @BeforeMethod
    public void navigateToLoginPage() {
        navigateToPage("https://qaproject.acodemy.lv/register");
    }

}
