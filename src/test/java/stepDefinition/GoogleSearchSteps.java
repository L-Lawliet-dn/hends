package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on Google Home Page")
    public void user_is_on_google_home_page() {
        // Initialize Chrome browser and wait instance
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();

        // Open Google home page
        driver.get("https://www.google.com/");
    }

    @When("User types in Cheese and hits ENTER")
    public void user_types_in_cheese_and_hits_enter() {
        // Find Google search input box
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("q"))
        );

        // Type Cheese and press ENTER
        searchBox.sendKeys("Cheese");
        searchBox.sendKeys(Keys.ENTER);
    }

    @Then("Show how many search results were shown")
    public void show_how_many_search_results_were_shown() {
        // Wait until Google result statistics are displayed
        WebElement resultStats = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("result-stats"))
        );

        // Print search result information
        System.out.println("Google Search Results: " + resultStats.getText());
    }

    @And("Close the browser")
    public void close_the_browser() {
        // Close the browser
        if (driver != null) {
            driver.close();
        }
    }
}