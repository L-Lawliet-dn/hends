import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleFormExcelTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Create Firefox browser instance
        driver = new FirefoxDriver();

        // Open Simple Form page
        driver.get("https://v1.training-support.net/selenium/simple-form");

        // Maximize browser window
        driver.manage().window().maximize();
    }

    @DataProvider(name = "formData")
    public Object[][] getExcelData() throws IOException {

        String excelPath = "src/test/resources/SimpleFormData.xlsx";

        FileInputStream fileInputStream = new FileInputStream(excelPath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();
        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();

        // Ignore the first row because it contains column headings
        Object[][] data = new Object[rowCount - 1][columnCount];

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);

            for (int j = 0; j < columnCount; j++) {
                data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
            }
        }

        workbook.close();
        fileInputStream.close();

        return data;
    }

    @Test(dataProvider = "formData")
    public void submitSimpleForm(String firstName, String lastName,
                                 String email, String contact,
                                 String message) {

        // Fill First Name field
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(firstName);

        // Fill Last Name field
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(lastName);

        // Fill Email field
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);

        // Fill Contact Number field
        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys(contact);

        // Fill Message field
        driver.findElement(By.id("message")).clear();
        driver.findElement(By.id("message")).sendKeys(message);

        // Click Submit button
        driver.findElement(
                By.xpath("//button[contains(text(), 'Submit')]")
        ).click();

        // Switch to alert and read its message
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();

        System.out.println("Alert message: " + alertMessage);

        // Verify that the alert contains the submitted first name
        Assert.assertTrue(
                alertMessage.contains(firstName),
                "Alert message does not contain the first name."
        );

        // Close the alert
        alert.accept();
    }

    @AfterClass
    public void tearDown() {
        // Close browser after all Excel rows have been tested
        if (driver != null) {
            driver.quit();
        }
    }
}