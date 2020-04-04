package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends TestBase {

//    There are some cases where we dont use @FindBy for WebElement
//    If there is a customize xpath which contains the some value in it, and if there are many other values then we have to create many @FindBy
//    Thus to avoid this, we pass value as para in method for that value and create 1 generic xpath

    @FindBy(xpath = "//div[@class='ui header item mb5 light-black']")  //xpath was tricky
    WebElement contactLabel;

    @FindBy(name = "first_name")
    WebElement firstName;

    @FindBy(name="last_name")
    WebElement lastName;

    @FindBy(name="company")
    WebElement company;

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    WebElement saveButton;



    public ContactPage(){
        PageFactory.initElements(driver,this);
    }


    public String verifyContactLabel(){
        return contactLabel.getText();
    }

    public void createNewContact(String fname, String lname){
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        saveButton.click();

    }

}
