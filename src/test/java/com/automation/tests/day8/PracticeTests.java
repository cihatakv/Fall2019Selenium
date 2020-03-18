package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Create a class called PracticeTests
 * <p>
 * - setup before/after methods
 * - in before method - instantiate webdriver and navigate to: http://practice.cybertekschool.com/
 * - in after method - just close webdriver.
 * <p>
 * - create a test called loginTest
 * - go to "Form Authentication" page
 * - enter valid credentials
 * username: tomsmith
 * password: SuperSecretPassword
 * <p>
 * - verify that following sub-header message is displayed: "Welcome to the Secure Area. When you are done click logout below."
 */

public class PracticeTests {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        //ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

    }

    @Test
    public void loginTest() {
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(3);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(actual, expected, "Sub-Header message is not matching!");
    }


    @Test
    public void forgotPasswordTest() {
        driver.findElement(By.linkText("Forgot Password")).click();

        driver.findElement(By.name("email")).sendKeys("telliogluakil@gmail.com" + Keys.ENTER);

        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.tagName("h4")).getText();

        Assert.assertEquals(actual, expected, "Text is not matching in H4 tag");

    }

    @Test
    public void checkBoxTest() {
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Checkboxes")).click();
        BrowserUtils.wait(3);

        //xpath = //input[@type='']
        // xpath = //input[1]
        // css = input:nth-of-type(1)
        driver.findElements(By.tagName("input")).get(0).click();
        BrowserUtils.wait(3);

        Assert.assertTrue(driver.findElements(By.tagName("input")).get(0).isSelected(), "Checkbox #1 is not selected!");

    }

    @AfterMethod
    public void teardown() {
        //close browser and destroy webdriver object
        driver.quit();
    }
}
