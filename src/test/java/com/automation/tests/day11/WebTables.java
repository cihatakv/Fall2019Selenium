package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // driver = DriverFactory.createADriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false); // to run browser without GUI. Makes browser invisible
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }

    // No Class or ID attributes to signify groupings of rows and columns
    //
    //"Last Name",	"First Name",	"Email"	,"Due"	,"Web Site"	,"Action"
    @Test
    public void getColumnNames() {
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[@id='table1']//thead//tr[1]//th"));
        for (WebElement tableHeader : columnNames) {
            System.out.print(tableHeader.getText() + "\t");
        }
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);
    }

    @Test
    public void verifyRowCount() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
        Assert.assertEquals(rows.size(), 4);
    }

    @Test
    public void getSpecificColumn() {
//        List<String> expectedWebsites = Arrays.asList("http://www.jsmith.com", "http://www.jdoe.com", "http://www.timconway.com", "http://www.frank.com");
//        List<WebElement> actualwebSites = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
//        System.out.println(BrowserUtils.getTextFromWebElements(actualwebSites));
//        Assert.assertEquals(BrowserUtils.getTextFromWebElements(actualwebSites), expectedWebsites);
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));
    }

    @Test
    public void deleteLink() {
        // first way :
        //once you find email cell in the first table that has this email (jdoe@hotmail.com) then go to following sibling has linkText delete :
        //td element with email and td element that contains delete => are siblings
        ////td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']
        //to make it easier :
        //go back to parent and find link that has text delete
        //td is child of tr
        ////td[text()='fbach@yahoo.com']/..//a[text()='delete']
        //even more simple way :
        //it is more hardcoded! but easiest => you provide index so it s not flexible, if index is change ilocator will never find it
        //go to find email in the first table go to parent go to second link inside this element
        ////table[1]//td[text()='jsmith@gmail.com']/..//a[2]

        WebElement deleteLink = driver.findElement(By.xpath("//td[text()='jsmith@gmail.com']//following-sibling::td/a[text()='delete']"));
//        WebElement deleteLink = driver.findElement(By.xpath("//td[text()='fbach@yahoo.com']/..//a[text()='delete']"));
//        WebElement deleteLink = driver.findElement(By.xpath("//table[1]//td[text()='jsmith@gmail.com']/..//a[2]"));
        deleteLink.click();
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        Assert.assertEquals(rows.size(), 3);
        List<WebElement> newRow = driver.findElements(By.xpath("//table[1]//tbody//tr//td[3]"));
        Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());
    }

    /**
     *
     */
    @Test
    public void getColumnIndexByName() {
        String columnName = "Email";
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        int index = 0;
        for (int i = 0; i < columnNames.size(); i++) {
            if (columnNames.get(i).getText().equals(columnName)) {
                index = i + 1;
                break;
            }
        }
        Assert.assertEquals(index, 3);
    }

    @Test
    public void getSpecificCell() {
        String expected = "http://www.jdoe.com";

        int row = 3;
        int column = 5;

        String xpath = "//table[1]//tbody//tr[" + row + "]//td[" + column + "]";
        WebElement cell = driver.findElement(By.xpath(xpath));

        Assert.assertEquals(cell.getText(), expected);
    }
}
