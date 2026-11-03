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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HO_40 {
    static String url = "https://v1.training-support.net/selenium";
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    static void init() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void toggleCheckbox() {
        driver.get(url);

        // Open the "Dynamic Controls" page.
        driver.findElement(By.xpath("//div[@class='header'][contains(text(),'Dynamic Controls')]")).click();
        wait.until(ExpectedConditions.urlContains("dynamic-controls"));

        By checkboxContainer = By.id("dynamicCheckbox");
        WebElement toggleButton = driver.findElement(By.id("toggleCheckbox"));

        // Click the toggle button and wait till the checkbox disappears.
        toggleButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkboxContainer));
        System.out.println("Checkbox visible after first click: " + driver.findElement(checkboxContainer).isDisplayed());
        Assertions.assertFalse(driver.findElement(checkboxContainer).isDisplayed());

        // Click the button again, wait till the checkbox appears, then check it.
        toggleButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxContainer));
        WebElement checkbox = driver.findElement(By.xpath("//input[@name='toggled']"));
        checkbox.click();
        System.out.println("Checkbox selected: " + checkbox.isSelected());
        Assertions.assertTrue(checkbox.isSelected());
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
