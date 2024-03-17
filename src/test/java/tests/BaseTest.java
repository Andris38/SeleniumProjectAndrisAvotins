package tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.github.javafaker.Faker;
import pageObjects.HomePage;
import pageObjects.QAProjectLoginPage;
import pageObjects.RegistrationPage;

public class BaseTest {
    private WebDriver driver;
    QAProjectLoginPage qaProjectLoginPage;
    HomePage homePage;
    RegistrationPage registrationPage;

    Faker faker;

    @BeforeMethod
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        faker = new Faker();
        initiatePageObjects();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }

    private void initiatePageObjects() {
        qaProjectLoginPage = new QAProjectLoginPage(driver);
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    public void navigateToPage(String url) {
        driver.navigate().to(url);
    }
}
