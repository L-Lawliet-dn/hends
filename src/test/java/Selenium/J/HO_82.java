package Selenium.J;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HO_82 {
    static WebDriver driver;
    String url = "https://v1.training-support.net/selenium/popups";

    @BeforeAll
    static void beforeAll(){
        driver = new ChromeDriver();
    }

    @Test
    void tooltipTest() {
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Sign In']")
        ));

        actions.moveToElement(signInButton).perform();

        System.out.println(signInButton.getAttribute("data-tooltip"));

        signInButton.click();

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("username")
        ));

        username.sendKeys("admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");

        WebElement logInButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Log in']")
        ));

        logInButton.click();

        System.out.println(driver.findElement(By.id("action-confirmation")).getText());


    }

    @AfterAll
    static void quit(){
        driver.quit();
    }
}
