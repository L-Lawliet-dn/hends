package Selenium;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HO_37 {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    static void beforeAll() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Wait for and return the first element that is actually visible.
    static WebElement getVisibleElement(By locator) {
        return wait.until(webDriver ->
                webDriver.findElements(locator)
                        .stream()
                        .filter(WebElement::isDisplayed)
                        .findFirst()
                        .orElse(null)
        );
    }

    @Test
    public void HO_37() {
        driver.get("https://v1.training-support.net");
        System.out.println(driver.getTitle());

        // Click the visible Login button.
        getVisibleElement(
                By.cssSelector("button.ui.button[onclick='showLogin()']")
        ).click();

        // Type into the visible modal fields.
        getVisibleElement(
                By.cssSelector("input[name='username']")
        ).sendKeys("admin");

        getVisibleElement(
                By.cssSelector("input[name='password']")
        ).sendKeys("password");

        // Click the visible green Login button in the popup.
        getVisibleElement(
                By.cssSelector("button.ui.green.button")
        ).click();
    }

    @AfterAll
    static void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }
}