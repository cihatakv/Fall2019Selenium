package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(2);

        WebElement btn1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        btn1.click();

        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());

        //click on button #2
        WebElement btn2 = driver.findElement(By.xpath("//button[text()='Button 2']"));
        btn2.click();
        System.out.println(result.getText());

//        WebElement btn3 = driver.findElement(By.xpath("//button[@onclick='button3()']"));
//        btn3.click();
//        System.out.println(result.getText());

        WebElement btn3 = driver.findElement(By.xpath("//button[starts-with(@id,'button_')"));
        btn3.click();
        System.out.println(result.getText());


        WebElement btn4 = driver.findElement(By.xpath("button[contains(@id,'_button')][1]"));
        btn4.click();
        System.out.println(result.getText());


        BrowserUtils.wait(2);
        driver.quit();
    }
}
