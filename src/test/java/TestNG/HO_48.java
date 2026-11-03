package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HO_48 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net");
    }

    @Test
    public void aboutUsTest() {
        // Title of the home page.
        String title = driver.getTitle();
        System.out.println("Home page title: " + title);
        Assert.assertEquals(title, "Training Support");

        // Click the "About Us" button.
        driver.findElement(By.id("about-link")).click();

        // Title of the new page.
        String newTitle = driver.getTitle();
        System.out.println("New page title: " + newTitle);
        Assert.assertEquals(newTitle, "About Training Support");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
