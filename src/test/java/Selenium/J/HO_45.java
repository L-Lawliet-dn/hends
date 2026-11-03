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

public class HO_45 {
    static WebDriver driver;
    String url = "https://v1.training-support.net/selenium/selects";

    @BeforeAll
    static void beforeAll(){
        driver = new ChromeDriver();
    }

    @Test
    void dropdownTest(){
        driver.get(url);

        Select dropdown = new Select(driver.findElement(By.id("single-select")));
        dropdown.selectByContainsVisibleText("Option 2");
        dropdown.selectByIndex(3);
        dropdown.selectByValue("4");

        List<WebElement> options = dropdown.getOptions();
        for(WebElement option:options){
            System.out.println(option.getText());
        }
    }

    @AfterAll
    static void quit(){
        driver.quit();
    }
}
