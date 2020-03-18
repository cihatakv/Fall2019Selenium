package com.automation.tests.OfficeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class vyTrackTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("https://qa3.vytrack.com");
        BrowserUtils.wait(2);
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        BrowserUtils.wait(2);
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        BrowserUtils.wait(2);
        password.submit();

        // //span[.='Contacts']/following-sibling::a
        // another xpath => (//a[@href='/contact'])[4]

        BrowserUtils.wait(2);
        WebElement contactLink = driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        BrowserUtils.wait(2);
        contactLink.click();
        BrowserUtils.wait(4);

        WebElement createContactLink = driver.findElement(By.linkText("Create Contact"));
        BrowserUtils.wait(2);
        createContactLink.click();

        BrowserUtils.wait(2);

        String currentTitle = driver.getTitle();
        BrowserUtils.wait(2);

        if (currentTitle.equalsIgnoreCase("Create Contact - Contacts - Customers"))
            System.out.println("Title is expected");
        else
            System.out.println("Title is NOT expected");

        BrowserUtils.wait(2);


        HashMap<String, String> contact1 = new HashMap<>();
        contact1.put("First Name", "John");
        contact1.put("Last Name", "Smith");
        contact1.put("Phone", "512-236-4545");
        contact1.put("Street Address", "400 Main Street");
        contact1.put("City", "Tysons");
        contact1.put("State", "VA");
        contact1.put("Zip Code", "22102");
        contact1.put("Sales Group", "true");
        contact1.put("Country", "United States");


        System.out.println("contact1 = " + contact1);


        driver.quit();
    }
}
