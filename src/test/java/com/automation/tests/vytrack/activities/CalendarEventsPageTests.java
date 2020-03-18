package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CalendarEventsPageTests {
    private WebDriver driver;
    private Actions actions;
    private String URL = "http://qa2.vytrack.com/user/login";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By calendarEventsBy = By.cssSelector("a[title='Create Calendar event']");

    private By currentUserBy = By.cssSelector("#user-menu > a");
    private By ownerBy = By.xpath("//span[@class='select2-chosen']");

    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");

    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");

    private String storeManagerUserName = "storemanager55";
    private String storeManagerPassword = "UserUser123";

    /**
     * Go to Activities --> Calendar Events
     * Verify that Create Calendar Event button is displayed
     */
    @Test
    public void verifyCreateButton() {
        WebElement calendarEventsElement = driver.findElement(calendarEventsBy);
        Assert.assertTrue(calendarEventsElement.isDisplayed());
    }

    /**
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Default owner name should be current user
     * Default title should be blank
     * Default start date should be current date
     * Default start time should be current time
     */

    // //span[@class='select2-chosen']
    @Test
    public void verifyDefaultValues() {
        driver.findElement(calendarEventsBy).click();
        BrowserUtils.wait(3);
        String currentUserName = driver.findElement(currentUserBy).getText().trim();
        String defaultOwnerName = driver.findElement(ownerBy).getText().trim();
        Assert.assertTrue(defaultOwnerName.equalsIgnoreCase(currentUserName));

        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());


        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");
        Assert.assertEquals(actualDate, expectedDate);
        String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:mm a"));

//        String expectedTime = LocalTime.now(ZoneId.of("America/Los_Angeles")).format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");

        Assert.assertEquals(actualTime, expectedTime);


    }


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createADriver("chrome");
        driver.get(URL);
        driver.manage().window().maximize();
        actions = new Actions(driver);
        BrowserUtils.wait(3);
        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtils.wait(3);

        //Hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        driver.findElement(By.linkText("Calendar Events")).click();
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
