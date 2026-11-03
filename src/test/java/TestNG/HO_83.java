import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HO_83 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Create Firefox driver instance
        driver = new FirefoxDriver();

        // Open the target practice page
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void verifyPageTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Target Practice";

        System.out.println("Page Title: " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void incorrectBlackButtonAssertion() {
        // Locate the black button
        WebElement blackButton = driver.findElement(
                By.cssSelector("button.black")
        );

        // Incorrect assertion: button is displayed, so this test should fail
        Assert.assertFalse(
                blackButton.isDisplayed(),
                "Black button should not be displayed"
        );
    }

    @Test(enabled = false)
    public void skippedTestUsingEnabledFalse() {
        System.out.println("This method will not run.");
    }

    @Test
    public void skippedTestUsingSkipException() {
        throw new SkipException("Skipping this test intentionally.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after all tests are finished
        if (driver != null) {
            driver.close();
        }
    }
}