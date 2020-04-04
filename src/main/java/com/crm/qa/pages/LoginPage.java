package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //    PageFactory = OR
    @FindBy(name="email")
    WebElement email;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath = "//div[contains(@class,'ui fluid large blue submit')]")
    WebElement loginBtn;

//    initialize the page object
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

//    Actions
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public HomePage login(String mailid, String pwd){
        email.sendKeys(mailid);
        password.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();
    }







}
