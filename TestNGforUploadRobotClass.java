package Day6;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert; // Native TestNG Assertions
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGforUploadRobotClass {
        WebDriver driver;

        @BeforeMethod
        public void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        public void testFileUploadUsingRobot() throws Exception {
            driver.get("file:///C:/Users/CCST/Downloads/SeleniumMaterial-20260915T091244Z-1-001/SeleniumMaterial/fileUpload.html");
            Thread.sleep(2000);

            WebElement fileInput = driver.findElement(By.id("fileInput"));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", fileInput);
            Thread.sleep(3000);

            String filePath = "C:\\Users\\CCST\\Downloads\\welcome.html";

            StringSelection selection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);

            // --- TESTNG ASSERTION ---
            String expectedFileName = "welcome.html";
            String actualValue = fileInput.getAttribute("value");

            System.out.println("Current Value in File Input: " + actualValue);

            // Validates if the path string contains the uploaded file name
            Assert.assertFalse(actualValue.contains(expectedFileName),
                    "Assertion Failed: File 'welcome.html' was not successfully uploaded!");
        }

        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }


