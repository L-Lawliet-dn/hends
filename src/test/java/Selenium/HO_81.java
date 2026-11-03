package Selenium;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HO_81 {
    static String url = "https://v1.training-support.net/selenium/input-events";
    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    @BeforeAll
    static void init() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @Test
    void pressKeys() {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("keyPressNotify")));

        // Press the first letter of the name in caps (SHIFT + m -> "M").
        actions.keyDown(Keys.SHIFT).sendKeys("m").keyUp(Keys.SHIFT).perform();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("keyPressed"), "M"));
        String pressed = driver.findElement(By.id("keyPressed")).getText();
        System.out.println("Key pressed: " + pressed);
        Assertions.assertEquals("M", pressed);

        // CTRL + a to select all the text on the page.
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        // CTRL + c to copy the selected text.
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
