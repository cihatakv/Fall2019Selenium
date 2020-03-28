package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {
    private WebDriver driver;
    private WebDriverWait wait;
    private String username = "tester";
    private String password = "test";

    private String URL = "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders";

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createADriver("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.get(URL);
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password, Keys.ENTER);
    }

    @Test
    public void checkBoxTest() {
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//table[@class ='SampleTable']//td[1]/input"));
//        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checked']"));
        for (WebElement checkBox : checkBoxes) {
            Assert.assertTrue(checkBox.isSelected());
        }
    }

    /**
     * :: TASK for 10 minutes ::
     * Go to web orders page
     * Verify that Steve Johns zip code is 21233
     * Then update his zip code to 20002
     * Then verify that Steve Johns zip code is 20002
     */
    @Test
    public void updateZipCode() {
        String expected = "21233";
        // WebElement zipcode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
        String actual = driver.findElement(By.xpath("//table[@class ='SampleTable']//tr[4]//td[9]")).getText();

        Assert.assertEquals(actual, expected);

        // driver.findElement(By.xpath(" //td[text()='Steve Johns']//following-sibling::td/input")).click();
        driver.findElement(By.xpath("//table[@class ='SampleTable']//tr[4]//td[13]//input")).click();

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).clear();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("20002");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();

        String expectedNew = "20002";
        String actualNew = driver.findElement(By.xpath("//table[@class ='SampleTable']//tr[4]//td[9]")).getText();
        Assert.assertEquals(actualNew, expectedNew);

    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
