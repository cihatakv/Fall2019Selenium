package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForIFrame {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");

        BrowserUtils.wait(2);

        driver.switchTo().frame("mce_0_ifr");

        WebElement textInput = driver.findElement(By.id("tinymce"));

        System.out.println(textInput.getText());

        BrowserUtils.wait(2);

        textInput.clear();
        BrowserUtils.wait(2);
        textInput.sendKeys("Hello, World");


        driver.switchTo().defaultContent();


        BrowserUtils.wait(1);

        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());
        BrowserUtils.wait(1);


        driver.quit();


    }
}
