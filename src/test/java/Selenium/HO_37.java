package Selenium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HO_37 {

    WebDriver driver;
    @BeforeAll
    void  beforeAll()
    {
        driver = new FirefoxDriver();
    }

    @Test
    public void HO_37()
    {
        driver.get("https://v1.training-support.net");
        System.out.println(driver.getTitle());

        driver.findElement(By.id());
    }
}
