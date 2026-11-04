import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HO_51 {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @DataProvider(name = "Authentication")
    public Object[][] credentials() {
        return new Object[][] {
                {"admin", "password"},
                {"user", "password"}
        };
    }

    @Test(dataProvider = "Authentication")
    public void loginTest(String username, String password) {

        List<WebElement> usernameFields =
                driver.findElements(By.id("username"));

        List<WebElement> passwordFields =
                driver.findElements(By.id("password"));

        List<WebElement> loginButtons =
                driver.findElements(By.cssSelector("button"));

        usernameFields.get(0).sendKeys(username);
        passwordFields.get(0).sendKeys(password);
        loginButtons.get(0).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}