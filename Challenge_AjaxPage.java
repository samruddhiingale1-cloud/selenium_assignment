import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Challenge_AjaxPage {

        public static void main(String[] args) {

                    WebDriver driver = new ChromeDriver();
                    driver.get("file:///C:/Users/CCST/Downloads/SeleniumMaterial-20260915T091244Z-1-001/SeleniumMaterial/challenge_AjaxPage.html");


                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                    try {

                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("spinner")));


                        WebElement WelcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Welcome!!")));


                        WebElement loadQuoteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("Load Quote")));
                        loadQuoteBtn.click();


                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("Fetching quote")));


                        WebElement quoteMessage = driver.findElement(By.id("Quote message"));
                        if (quoteMessage.isDisplayed()) {
                            System.out.println("Validation Passed: Quote message is displayed.");
                        } else {
                            System.out.println("Validation Failed: Quote message is hidden.");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {

                        driver.quit();
                    }
                }
            }
