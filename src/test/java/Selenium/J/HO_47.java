package Selenium.J;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HO_47 {
    static WebDriver driver;
    String url = "https://v1.training-support.net/selenium/tab-opener";

    @BeforeAll
    static void beforeAll(){
        driver = new ChromeDriver();
    }

    @Test
    void alertTest(){
        driver.get(url);

        driver.findElement(By.id("launcher")).click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[driver.getWindowHandles().toArray().length - 1].toString());
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.className("content")));

        driver.findElement(By.id("actionButton")).click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[driver.getWindowHandles().toArray().length - 1].toString());
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.className("content")));


        Set<String> all_handles = driver.getWindowHandles();
        for(String handle:all_handles){
            System.out.println(handle);
        }
    }

    @AfterAll
    static void quit(){
        driver.quit();
    }
}
