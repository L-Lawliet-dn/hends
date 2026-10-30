package Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HO_36 {
    static WebDriver driver;
    String url = "https://v1.training-support.net";

    @BeforeAll
    static void beforeAll(){
        driver = new FirefoxDriver();
    }

    @Test
    void Homepage(){
        driver.get(url);

        System.out.println(driver.getTitle());
        driver.findElement(By.id("about-link")).click();

        System.out.println(driver.getTitle());
    }

    @AfterAll
    static void quit(){
        driver.quit();
    }
}
