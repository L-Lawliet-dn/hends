package Selenium.J;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HO_42 {
    static WebDriver driver;
    String url = "https://v1.training-support.net/selenium";

    @BeforeAll
    static void beforeAll(){
        driver = new ChromeDriver();
    }

    void inputEnabled(WebDriver driver){
        WebElement textInput = driver.findElement(By.id("input-text"));
        System.out.println("The text input is "+(textInput.isEnabled()?"enabled":"not enabled"));
    }

    @Test
    void dynamicTest(){
        driver.get(url);
        driver.findElement(By.xpath("//div[contains(text(), 'Dynamic Controls')]")).click();

        inputEnabled(driver);

        WebElement toggle = driver.findElement(By.xpath("//button[text()='Enable Input']"));
        toggle.click();

        inputEnabled(driver);
    }

    @AfterAll
    static void quit(){
        driver.quit();
    }
}
