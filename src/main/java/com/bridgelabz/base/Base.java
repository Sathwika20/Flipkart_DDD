package com.bridgelabz.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class Base {
    public static WebDriver driver;
    //Before execution
    @Parameters({"url"})
    @BeforeTest
    public void setUp(String url) {
        //launches the chromedriver using WebDriver interface
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Used to maximise the window
        driver.manage().window().maximize();
        //Enter the URL of Application
        driver.get("https://www.flipkart.com/");
    }
    //After execution
    @AfterTest
    public void tearDown() {
        //used to close the current window
        driver.close();
    }

}
