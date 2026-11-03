package Selenium.J;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HO_46 {
    static WebDriver driver;
    String url = "https://v1.training-support.net/selenium/javascript-alerts";

    @BeforeAll
    static void beforeAll(){
        driver = new ChromeDriver();
    }

    @Test
    void alertTest(){
        driver.get(url);

        driver.findElement(By.id("confirm")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirm")).click();
        driver.switchTo().alert().dismiss();
    }

    @AfterAll
    static void quit(){
        driver.quit();
    }
}
