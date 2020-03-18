package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTests {

    private WebDriver driver;

    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");

    // CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";


    @Test(description = "verify that warning ")
    public void invalidUsername() {
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(5);
        WebElement warningElement = driver.findElement(warningMessageBy);
        // If warning message is not visible, test will fail.
        assertTrue(warningElement.isDisplayed());
    }

    @Test
    public void loginAsStoreManager() {
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);

        String expected = "Dashboard";
        String actual = driver.getTitle();
        assertEquals(actual, expected, "Page title is not correct");
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void teardown() {
        // if webDriver object is alive
        if (driver != null) {
            // close the browser, close session
            driver.quit();
            // destroy webDriver object for sure
            driver = null;
        }
    }

}
