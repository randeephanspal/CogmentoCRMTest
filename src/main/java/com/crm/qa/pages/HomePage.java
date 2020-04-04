package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    //    PageFactory = OR
    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    @CacheLookup
    WebElement contactLink;

    @FindBy(xpath="//span[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy()
    WebElement taskLink;


    public HomePage(){
        PageFactory.initElements(driver, this);
    }

//    Actions/Methods

    public String validateHomePageText(){
        return driver.getTitle();
    }

    public ContactPage clickOnContactsLink(){
        contactLink.click();
        return new ContactPage();
    }




}
