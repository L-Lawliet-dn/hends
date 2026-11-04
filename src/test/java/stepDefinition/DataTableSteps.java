package stepDefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on Login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @When("User enters login credentials")
    public void user_enters_login_credentials(DataTable dataTable) {

        // Convert the DataTable into a List of Maps.
        // The first table row supplies the column names.
        List<Map<String, String>> credentials = dataTable.asMaps(
                String.class,
                String.class
        );

        // Read the first data row.
        String usernameText = credentials.get(0).get("username");
        String passwordText = credentials.get(0).get("password");

        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("username"))
        );

        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys(usernameText);
        password.sendKeys(passwordText);

        driver.findElement(
                By.xpath("//button[contains(text(), 'Submit')]")
        ).click();
    }

    @Then("Read the page title and confirmation message")
    public void read_the_page_title_and_confirmation_message() {
        System.out.println("Page title: " + driver.getTitle());

        WebElement confirmationMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".content")
                )
        );

        System.out.println(
                "Confirmation message: " + confirmationMessage.getText()
        );
    }

    @And("Close the Browser")
    public void close_the_browser() {
        if (driver != null) {
            driver.quit();
        }
    }
}