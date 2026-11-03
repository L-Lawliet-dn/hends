package Selenium;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HO_39 {
    static String url = "https://v1.training-support.net/selenium/drag-drop";
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
    void dragBallIntoDropzones() {
        driver.get(url);

        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        // Drag the ball into Dropzone 1 and verify.
        actions.clickAndHold(ball).moveToElement(dropzone1).release().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(dropzone1, "Dropped!"));
        System.out.println("Dropzone 1 text: " + dropzone1.findElement(By.tagName("p")).getText());
        Assertions.assertEquals("Dropped!", dropzone1.findElement(By.tagName("p")).getText());

        // Drag the ball into Dropzone 2 and verify.
        actions.clickAndHold(ball).moveToElement(dropzone2).release().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(dropzone2, "Dropped!"));
        System.out.println("Dropzone 2 text: " + dropzone2.findElement(By.tagName("p")).getText());
        Assertions.assertEquals("Dropped!", dropzone2.findElement(By.tagName("p")).getText());
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
