package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on Login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/selenium/login-form");
    }

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("username"))
        );

        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(
                By.xpath("//button[contains(text(), 'Submit')]")
        );

        username.sendKeys("admin");
        password.sendKeys("password");
        submitButton.click();
    }

    @Then("Read the page title and confirmation message")
    public void read_the_page_title_and_confirmation_message() {
        String pageTitle = driver.getTitle();

        WebElement confirmationMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".content")
                )
        );

        System.out.println("Page Title: " + pageTitle);
        System.out.println("Confirmation Message: "
                + confirmationMessage.getText());
    }

    @And("Close the Browser")
    public void close_the_browser() {
        if (driver != null) {
            driver.quit();
        }
    }
}