package com.bridgelabz.test;

import com.bridgelabz.utils.ReadExcelFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class ReadExcelFileTest {
    WebDriver driver;
    @Test(dataProvider = "data-provider", dataProviderClass = ReadExcelFile.class)
    public void getLoginIntoFlipkart(String userName, String password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //Launches the chrome
         driver = new ChromeDriver();
        //Maximize the Window of the chrome
         driver.manage().window().maximize();
        //Launches the Application
         driver.get("https://www.flipkart.com/");
         driver.findElement(By.xpath("//input[@class = '_2IX_2- VJZDxU']")).sendKeys(userName);
         driver.findElement(By.xpath("//input[@class = '_2IX_2- _3mctLh VJZDxU']")).sendKeys(password);
         driver.findElement(By.xpath("//button[@class = '_2KpZ6l _2HKlqd _3AWRsL']")).click();
        Thread.sleep(2000);
        //finding out the value inside the expected element
        WebElement webElement = driver.findElement(By.xpath("//div[@class ='exehdJ']"));
        String elementValue = webElement.getText();
        System.out.println(elementValue);
        Assert.assertEquals(elementValue,"Sathwika");

     }
     @AfterTest
    public void tearDown(){
        driver.close();
     }
}
