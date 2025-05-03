package testrunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import setup.Setup;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.List;

public class AdminTableDataSaveRunner extends Setup {

    @Test(priority = 1, description = "Check if admin can get table data")
    public void doAdminSaveTableData() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("admin@test.com", "admin123");
        String headerActual = driver.findElement(By.tagName("h2")).getText();
        String headerExpected = "Admin Dashboard";
        Assert.assertTrue(headerActual.contains(headerExpected));
        Assert.assertTrue(driver.findElement(By.className("total-count")).isDisplayed());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr")));

        String[] headers = {
                "First Name", "Last Name", "Email", "Phone Number",
                "Address", "Gender", "Registration Date"
        };

        StringBuilder data = new StringBuilder();

        int[] widths = {12, 12, 30, 15, 65, 10, 18};

        for (int i = 0; i < headers.length; i++) {
            String fmt = "%-" + widths[i] + "s | ";
            System.out.printf(fmt, headers[i]);
            data.append(String.format(fmt, headers[i]));
        }
        System.out.println();
        data.append(System.lineSeparator());

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            for (int i = 0; i < widths.length && i < columns.size(); i++) {
                String cellData = columns.get(i).getText().trim();
                String fmt = "%-" + widths[i] + "s | ";
                System.out.printf(fmt, cellData);
                data.append(String.format(fmt, cellData));
            }
            System.out.println();
            data.append(System.lineSeparator());
        }

        Path filePath = Paths.get("src/test/resources/admin_table_data.txt");
        try {
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, data.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            Assert.assertTrue(Files.size(filePath) > 0, "File created and data written successfully.");
        } catch (IOException e) {
            Assert.fail("Failed to write data to file: " + e.getMessage());
        }

    }

}
