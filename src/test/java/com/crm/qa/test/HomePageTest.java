package com.crm.qa.test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    public static LoginPage loginPage;
    public static HomePage homePage;
    ContactPage contactPage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        contactPage = new ContactPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void HomePageTitleTest(){
        String text = homePage.validateHomePageText();
        Assert.assertEquals(text,"Cogmento CRM");
    }

    @Test
    public void verifyContactsLinkTest(){
        contactPage = homePage.clickOnContactsLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
