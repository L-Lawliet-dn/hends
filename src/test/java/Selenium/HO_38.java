package Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HO_38 {
    static String url = "https://v1.training-support.net/selenium/target-practice";
    static WebDriver driver;

    @BeforeAll
    static void init() {
        driver = new FirefoxDriver();
    }

    @Test
    void locate() {
        driver.get(url);

        // XPath: 3rd header -> print its text
        WebElement thirdHeader = driver.findElement(By.xpath("//h3[@id='third-header']"));
        System.out.println("3rd header text: " + thirdHeader.getText());

        // XPath: 5th header -> print its color
        WebElement fifthHeader = driver.findElement(By.xpath("//h5[contains(@class,'header')]"));
        System.out.println("5th header color: " + fifthHeader.getCssValue("color"));

        // Other locator: violet button -> print all its classes
        WebElement violetButton = driver.findElement(By.cssSelector("button.violet"));
        System.out.println("Violet button classes: " + violetButton.getAttribute("class"));

        // Other locator: grey button -> print its text
        WebElement greyButton = driver.findElement(By.cssSelector("button.grey"));
        System.out.println("Grey button text: " + greyButton.getText());
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
