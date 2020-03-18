package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    private WebDriver driver;

    @Test
    public void googleSearchTest() {
        driver.get("https://www.google.com");
        BrowserUtils.wait(2);
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        //since every search item has a tag name <h3>
        //it's the easiest way to collect all of them
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement searchItem : searchItems) {
            String var = searchItem.getText();
            if (!var.isEmpty()) {
                System.out.println(var);
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }
    }

    @Test
    public void amazonSearch() {
        driver.get("http://www.amazon.com");
        driver.manage().window().maximize();
        BrowserUtils.wait(1);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        BrowserUtils.wait(1);
        List<WebElement> searchItems = driver.findElements(By.xpath("//*[@id='booksTitle']/div[1]"));
        searchItems.get(0).click();

        System.out.println(driver.getTitle());
        String title = driver.findElement(By.id("ebooksProductTitle")).getText();
        String expected = "\n" +
                "Java: Programming Basics for Absolute Beginners (Step-By-Step Java Book 1)";
        Assert.assertEquals(title, expected);

//        WebElement productTitle = driver.findElement(By.id("id"));
//        String productTitleString = searchItems.get(0).getText();
//        System.out.println(productTitleString);
//        Assert.assertTrue(productTitleString.contains("Java"));

        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.get("http://amazon.com");
//        driver.manage().window().maximize();
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+Keys.ENTER);
//        List<WebElement>searchItems= driver.findElements(By.tagName("h2"));
//        searchItems.get(0).click();
//        String productTitleString = searchItems.get(0).getText();
//        System.out.println(productTitleString);
//        Assert.assertTrue(productTitleString.contains("Java"));

    }

    @BeforeMethod
    public void setup() {
        //setup webdriver
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        //close browser and destroy webdriver object
        driver.quit();
    }
}
