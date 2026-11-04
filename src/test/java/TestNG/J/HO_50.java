import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HO_50 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test
    public void loginTest() {
        String username = "admin";
        String password = "password";

        WebElement usernameFields = driver.findElement(By.id("username"));
        WebElement passwordFields = driver.findElement(By.id("password"));
        WebElement loginButtons = driver.findElement(By.cssSelector("button"));

        usernameFields.sendKeys(username);
        passwordFields.sendKeys(password);
        loginButtons.click();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}