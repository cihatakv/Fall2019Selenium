package com.automation.tests.day9practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {

    private WebDriver driver;
    private String URL = "http://practice.cybertekschool.com/registration_form";
    private By firstnameBy = By.name("firstname");
    private By lastnameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    //Gender
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");

    private By dateOfBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By job_titleBy = By.name("job_title");

    private By cPlusPlusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javaScriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");

    private By signUpBy = By.id("wooden_spoon");

    @Test
    public void signUpTest() {
        driver.findElement(firstnameBy).sendKeys("Patrick");
        driver.findElement(lastnameBy).sendKeys("White");
        driver.findElement(usernameBy).sendKeys("testuser");
        driver.findElement(emailBy).sendKeys("test@email.com");
        driver.findElement(passwordBy).sendKeys("SecretPassword");
        driver.findElement(phoneBy).sendKeys("713-713-7137");

        driver.findElement(maleBy).click();

        driver.findElement(dateOfBirthBy).sendKeys("01/01/1985");

        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByValue("DA"); // departmentSelect.deselectByVisibleText("Department of Agriculture");

        Select jobTitleSelect = new Select(driver.findElement(job_titleBy));
        jobTitleSelect.selectByVisibleText("SDET");

        driver.findElement(javaBy);
        driver.findElement(signUpBy).click();
        BrowserUtils.wait(3);

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void verifyFirstNameLengthTest() {
        driver.findElement(firstnameBy).sendKeys("a");
        BrowserUtils.wait(2);

        Assert.assertTrue(driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']")).isDisplayed());
    }

    @Test
    public void verifyAlphabeticLettersOnlyTest() {
        driver.findElement(firstnameBy).sendKeys("123");
        BrowserUtils.wait(3);

        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
