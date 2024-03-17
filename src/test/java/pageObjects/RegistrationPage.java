package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import models.UserModel;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "email-confirm")
    private WebElement emailConfirmInput;

    @FindBy(id = "birth_date")
    private WebElement birthDateInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "password-confirm")
    private WebElement passwordConfirmInput;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkboxInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerButton;

    @FindBy(xpath = " //div[@class='card-header']")
    private WebElement cardHeader;


    //We pass user object created in test directly in the method
    public void registerUser(UserModel user, Boolean agreeToTerms) {
        nameInput.sendKeys(user.getName());
        lastNameInput.sendKeys(user.getLastName());
        emailInput.sendKeys(user.getEmailAddress());
        emailConfirmInput.sendKeys(user.getEmailAddress());
        birthDateInput.sendKeys(user.getBirthDate());
        //we need to press escape or do some other action to close date picker
        actions.sendKeys(Keys.ESCAPE).build().perform();
        passwordInput.sendKeys(user.getPassword());
        passwordConfirmInput.sendKeys(user.getPassword());
        if (agreeToTerms) {
            checkboxInput.click();
        }
        registerButton.click();
    }

    public String getCardHeaderText(){
        return cardHeader.getText();
    }
}
