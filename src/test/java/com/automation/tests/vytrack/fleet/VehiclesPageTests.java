package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehiclesPageTests {


    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");

    // CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(), 'Fleet')]");
    private By subtitleBy = By.className("oro-subtitle");

    private By pageNumberBy = By.xpath("//input[@type='number']");

    private WebDriver driver;

    @Test
    public void verifyPageSubTitle() {
        WebElement sibTitleElement = driver.findElement(subtitleBy);
        System.out.println(sibTitleElement.getText());

        String expected = "All Cars";
        String actual = sibTitleElement.getText();

        Assert.assertEquals(actual, expected);
    }

    /**
     * ################ TASK 5 minutes
     * <p>
     * Given user is on the vytrack landing page
     * When user logs on as a store manager
     * Then user navigates to Fleet --> Vehicles
     * And user verifies that page number is equals to "1"
     */
    @Test
    public void verifyPageNumber() {
        WebElement pageNumberElement = driver.findElement(pageNumberBy);
//        System.out.println(pageNumberElement.getAttribute("value"));
        String expected = "1";
        String actual = pageNumberElement.getAttribute("value");
        Assert.assertEquals(actual, expected);
    }


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        BrowserUtils.wait(5);

//        driver.findElement(fleetBy).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        BrowserUtils.wait(5);

        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(5);
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
