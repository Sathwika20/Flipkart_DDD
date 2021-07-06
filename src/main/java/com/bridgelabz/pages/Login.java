package com.bridgelabz.pages;

import com.bridgelabz.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Base {
    @FindBy(xpath = "//input[@class = '_2IX_2- VJZDxU']" )
    public static WebElement mobileNumber;

    @FindBy(xpath = "//input[@class = '_2IX_2- _3mctLh VJZDxU']")
    public static WebElement password;

    @FindBy(xpath = "//button[@class = '_2KpZ6l _2HKlqd _3AWRsL']")
    public static WebElement loginButton;

    //    Generate a Constructor,
    public Login() {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver,this);
    }

    public static void getUserName(String userName, String passWord) throws InterruptedException {
        mobileNumber.sendKeys(userName);
        password.sendKeys(passWord);
        //click() method is used to click the particular element
        loginButton.click();
        Thread.sleep(2000);
    }

}
