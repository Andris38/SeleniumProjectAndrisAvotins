package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='card-header' and text()='Dashboard']/parent::div[@class='card']")
    WebElement dashBoardCard;

    @FindBy(xpath = "//div[@class='card-header' and text()='Select Project']/parent::div[@class='card']")
    WebElement selectCard;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeMessage() {
        return dashBoardCard.findElement(By.className("card-body")).getText();
    }

}
