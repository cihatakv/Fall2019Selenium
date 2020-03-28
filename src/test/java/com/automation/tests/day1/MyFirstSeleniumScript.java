package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {

    public static void main(String[] args) throws InterruptedException {
        //setup chromedriver
        WebDriverManager.chromedriver().setup();
        //create chromedriver object
        ChromeDriver driver = new ChromeDriver();
        //open some website
        driver.get("http://google.com");
        Thread.sleep(3000);
        System.out.println();
    }
}
