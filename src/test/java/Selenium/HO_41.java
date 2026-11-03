package Selenium;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HO_41 {
    static String url = "https://v1.training-support.net/selenium/ajax";
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    static void init() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void ajaxContent() {
        driver.get(url);

        // Click the "Change Content" button.
        driver.findElement(By.xpath("//button[contains(text(),'Change Content')]")).click();

        // Wait for "HELLO!" and print the message.
        By hello = By.cssSelector("#ajax-content h1");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(hello, "HELLO!"));
        String helloMessage = driver.findElement(hello).getText();
        System.out.println("Message: " + helloMessage);
        Assertions.assertEquals("HELLO!", helloMessage);

        // Wait for the text to change to contain "I'm late!" and print the new message.
        By late = By.cssSelector("#ajax-content h3");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(late, "I'm late!"));
        String lateMessage = driver.findElement(late).getText();
        System.out.println("New message: " + lateMessage);
        Assertions.assertTrue(lateMessage.contains("I'm late!"));
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
