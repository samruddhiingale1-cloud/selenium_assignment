package Day6;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadRobotClass {

        public static void main(String[] args) throws Exception {

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("file:///C:/Users/CCST/Downloads/SeleniumMaterial-20260915T091244Z-1-001/SeleniumMaterial/fileUpload.html");
            Thread.sleep(2000);

            WebElement fileInput = driver.findElement(By.id("fileInput"));
            Actions actions = new Actions(driver);
            actions.moveToElement(fileInput).click().perform();
            Thread.sleep(2000);

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
            String expectedFileName = "welcome.html";
            String actualValue = fileInput.getAttribute("value");

            System.out.println("Current Value in File Input: " + actualValue);


            assert actualValue.contains(expectedFileName) : "Assertion Failed: File was not successfully uploaded!";


            if (actualValue.contains(expectedFileName)) {
                System.out.println("Assertion Passed: File successfully uploaded!");
            } else {
                System.out.println("Verification Failed: File name mismatch.");
            }

            driver.quit();
        }
    }






