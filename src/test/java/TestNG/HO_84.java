import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        Reporter.log("Creating Firefox driver instance", true);

        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        Reporter.log("Opening JavaScript Alerts page", true);

        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }

    @BeforeMethod
    public void switchToPage() {
        Reporter.log("Switching focus back to the main page", true);

        driver.switchTo().defaultContent();
    }

    @Test
    public void simpleAlertTestCase() {
        Reporter.log("Running Simple Alert test case", true);

        // Open simple alert
        driver.findElement(By.xpath("//button[contains(text(),'Simple Alert')]")).click();

        // Switch focus to alert
        Alert alert = driver.switchTo().alert();

        // Get and print alert text
        String alertText = alert.getText();
        System.out.println("Simple Alert Text: " + alertText);
        Reporter.log("Simple Alert Text: " + alertText, true);

        // Assertion
        Assert.assertFalse(alertText.isEmpty(), "Simple alert text should not be empty.");

        // Close the alert
        alert.accept();

        Reporter.log("Simple Alert test completed successfully", true);
    }

    @Test
    public void confirmAlertTestCase() {
        Reporter.log("Running Confirm Alert test case", true);

        // Open confirm alert
        driver.findElement(By.xpath("//button[contains(text(),'Confirm Alert')]")).click();

        // Switch focus to alert
        Alert alert = driver.switchTo().alert();

        // Get and print alert text
        String alertText = alert.getText();
        System.out.println("Confirm Alert Text: " + alertText);
        Reporter.log("Confirm Alert Text: " + alertText, true);

        // Assertion
        Assert.assertFalse(alertText.isEmpty(), "Confirm alert text should not be empty.");

        // Close the confirmation alert
        alert.accept();

        Reporter.log("Confirm Alert test completed successfully", true);
    }

    @Test
    public void promptAlertTestCase() {
        Reporter.log("Running Prompt Alert test case", true);

        // Open prompt alert
        driver.findElement(By.xpath("//button[contains(text(),'Prompt Alert')]")).click();

        // Switch focus to alert
        Alert alert = driver.switchTo().alert();

        // Get and print alert text
        String alertText = alert.getText();
        System.out.println("Prompt Alert Text: " + alertText);
        Reporter.log("Prompt Alert Text: " + alertText, true);

        // Assertion
        Assert.assertFalse(alertText.isEmpty(), "Prompt alert text should not be empty.");

        // Enter text into the prompt input box
        alert.sendKeys("Hello from TestNG");

        // Close the prompt alert
        alert.accept();

        Reporter.log("Prompt Alert test completed successfully", true);
    }

    @AfterTest
    public void tearDown() {
        Reporter.log("Closing the browser", true);

        if (driver != null) {
            driver.close();
        }
    }
}