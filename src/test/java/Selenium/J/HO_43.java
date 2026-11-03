package Selenium.J;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HO_43 {
    static WebDriver driver;
    String url = "https://v1.training-support.net/selenium/tables";

    @BeforeAll
    static void beforeAll(){
        driver = new ChromeDriver();
    }

    @Test
    void tableTests(){
        driver.get(url);

        List<WebElement> rows = driver.findElements(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/table/tbody/tr"));
        System.out.println("Number of rows in table 1:"+rows.size());
        List<WebElement> cols = rows.get(0).findElements(By.xpath("./td"));
        System.out.println("Number of columns in table 1:"+cols.size());
        System.out.println((rows.get(1).findElements(By.xpath("./td"))).get(1).getText());
    }

    @AfterAll
    static void quit(){
        driver.quit();
    }
}
