package Selenium;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HO_42 {
    static String url = "https://www.v1.training-support.net/selenium/input-events";
    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    // The side currently facing the front carries the "active" class.
    static final By FRONT_SIDE = By.cssSelector("#D3Cube .active h1");

    @BeforeAll
    static void init() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    static String frontValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(FRONT_SIDE)).getText();
    }

    @Test
    void cubeInputEvents() {
        driver.get(url);

        WebElement cube = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("D3Cube")));

        // Left click and print the value on the front.
        actions.click(cube).perform();
        System.out.println("Left click - front side: " + frontValue());

        // Double click (random side) and print the number.
        actions.doubleClick(cube).perform();
        System.out.println("Double click - front side: " + frontValue());

        // Right click and print the value on the front.
        actions.contextClick(cube).perform();
        System.out.println("Right click - front side: " + frontValue());
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
