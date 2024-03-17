package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QAProjectLoginPage extends BasePage {

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(className = "btn-primary")
    WebElement loginButton;

    @FindBy(className = "invalid-feedback")
    WebElement loginErrorMessage;

    public QAProjectLoginPage(WebDriver driver) {
        super(driver);
    }

    //login method
    public void login(String username, String password) {
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    //method were we get login error message. First we wait for that message to appear
    public String getErrorMessage() {
        waitForElementToAppear(By.className("invalid-feedback"));
        return loginErrorMessage.getText();
    }

    //method where we pass webelement and get back HTML validation message
    public String getValidationErrorMessage(WebElement element) {
        return element.getAttribute("validationMessage");
    }

}
