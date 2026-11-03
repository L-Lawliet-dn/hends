package Selenium.J;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HO_44 {
    static WebDriver driver;
    String url = " https://v1.training-support.net/selenium/dynamic-attributes";

    @BeforeAll
    static void beforeAll(){
        driver = new ChromeDriver();
    }

    @Test
    void loginTest(){
        driver.get(url);
        String uName = "admin";
        String pWord = "password";

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(uName);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pWord);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[1]/div/div/button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement target_div = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))
        );

        System.out.println(target_div.getText());
    }

    @AfterAll
    static void quit(){
        driver.quit();
    }
}
