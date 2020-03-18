package com.automation.tests.warmUp;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class March4 {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = DriverFactory.createADriver("chrome");

        ebayTest();

        amazonTest();

        wikiTest();

        driver.quit();

    }

    public static void ebayTest() throws InterruptedException {
        driver.get("http://www.ebay.com");

        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("java book");

        Thread.sleep(2000);

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        Thread.sleep(2000);

        WebElement result = driver.findElement(By.tagName("h1"));
        System.out.println("result.getText() = " + result.getText().split(" ")[0]);

        Thread.sleep(2000);


    }

    public static void amazonTest() throws InterruptedException {
        driver.navigate().to("http://amazon.com");

//        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
//        searchBox.sendKeys("Apple Watch", Keys.ENTER);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple watch", Keys.ENTER);

        Thread.sleep(2000);

        if (driver.getTitle().contains("apple watch"))
            System.out.println("TEST PASSED");
        else
            System.out.println("TEST FAILED");

        Thread.sleep(2000);


    }

    public static void wikiTest() throws InterruptedException {
        driver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("selenium driver", Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        Thread.sleep(2000);
        String link = driver.getCurrentUrl();
        if (link.endsWith("Selenium_(software)"))
            System.out.println("TEST PASSED");
        else
            System.out.println("TEST FAILED");

    }
}

/*
Go to ebay
enter search term
click on search button
print number of results
go to amazon
Go to ebay
enter search term
click on search button
verify title contains search term
Go to wikipedia.org
enter search term `selenium webdriver`
click on search button
click on search result `Selenium (software)`
verify url ends with `Selenium_(software)`
 */