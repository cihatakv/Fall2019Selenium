package com.automation.tests.day2.mySelf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationToRegister {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");

        driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().window().maximize();
        WebElement search = driver.findElement(By.name("email_create")); // name="email_create"
        search.sendKeys("tellioglu@yahoo.com", Keys.ENTER);

        Thread.sleep(3000);

        WebElement gender = driver.findElement(By.id("id_gender1")); // name="id_gender"

        gender.click();

        // customer_firstname
        WebElement customer_firstname = driver.findElement(By.id("customer_firstname")); // name="email_create"
        Thread.sleep(2000);
        customer_firstname.sendKeys("Telli", Keys.TAB);

        // customer_lastname
        WebElement customer_lastname = driver.findElement(By.id("customer_lastname"));
        Thread.sleep(2000);
        customer_lastname.sendKeys("Oglu", Keys.TAB);

        // email
        WebElement email = driver.findElement(By.id("email"));
        Thread.sleep(2000);
        email.sendKeys("tellioglu@yahoo.com", Keys.TAB);

        // passwd
        WebElement password = driver.findElement(By.id("passwd"));
        Thread.sleep(2000);
        password.sendKeys("Password12345", Keys.TAB);

        // days
        WebElement days = driver.findElement(By.id("days"));
        Thread.sleep(2000);
        days.sendKeys("1", Keys.TAB);

        // months
        WebElement months = driver.findElement(By.id("months"));
        Thread.sleep(2000);
        months.sendKeys("January", Keys.TAB);

        // years
        WebElement years = driver.findElement(By.id("years"));
        Thread.sleep(2000);
        years.sendKeys("1980", Keys.TAB);

        // firstname
        WebElement firstname = driver.findElement(By.id("firstname"));
        Thread.sleep(2000);
        firstname.sendKeys("Telli", Keys.TAB);

        // lastname
        WebElement lastname = driver.findElement(By.id("lastname"));
        Thread.sleep(2000);
        lastname.sendKeys("Oglu", Keys.TAB);

        // company
        WebElement company = driver.findElement(By.id("company"));
        Thread.sleep(2000);
        company.sendKeys("H", Keys.TAB);

        // address1
        WebElement address1 = driver.findElement(By.id("address1"));
        Thread.sleep(2000);
        address1.sendKeys("123 Main St", Keys.TAB);

        // city
        WebElement city = driver.findElement(By.id("city"));
        Thread.sleep(2000);
        city.sendKeys("Houston", Keys.TAB);

        // id_state
        WebElement id_state = driver.findElement(By.id("id_state"));
        Thread.sleep(2000);
        id_state.sendKeys("Texas", Keys.TAB);

        // postcode
        WebElement postcode = driver.findElement(By.id("postcode"));
        Thread.sleep(2000);
        postcode.sendKeys("77025", Keys.TAB);

        // id_country
        WebElement id_country = driver.findElement(By.id("id_country"));
        Thread.sleep(2000);
        id_country.sendKeys("United States", Keys.TAB);

        // phone_mobile
        WebElement phone_mobile = driver.findElement(By.id("phone_mobile"));
        Thread.sleep(2000);
        phone_mobile.sendKeys("7137137133", Keys.TAB);

        // alias
        WebElement alias = driver.findElement(By.id("alias"));
        Thread.sleep(2000);
        alias.sendKeys("home_address", Keys.TAB);

        Thread.sleep(3000);

        // submitAccount
        WebElement submitAccount = driver.findElement(By.id("submitAccount"));
        Thread.sleep(2000);
        submitAccount.click();


        Thread.sleep(12000);
        driver.close();


    }
}
