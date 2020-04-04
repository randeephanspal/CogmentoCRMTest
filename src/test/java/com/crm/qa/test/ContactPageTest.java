package com.crm.qa.test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactPageTest extends TestBase {

    String sheetName="contacts";

    public static ContactPage contactPage;
    public static HomePage homePage;
    public static LoginPage loginPage;


    public ContactPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        contactPage = new ContactPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        contactPage = homePage.clickOnContactsLink();
    }

    @Test
    public void ContactTableNameTest(){
        String label = contactPage.verifyContactLabel();
        Assert.assertEquals(label, "Contacts");
    }

    @DataProvider
    public Object[][] getCRMTestData() throws InvalidFormatException {
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }


    @Test(dataProvider = "getCRMTestData")
    public void validateCreateNewContact(String firstname, String lastname) {
        //Not necessary to create Page factory for all locators
        //This below webelement is not reusable for other test hence not created PageFactory
        WebElement newButton  = driver.findElement(By.xpath("//button[contains(text(),'New')]"));
        newButton.click();
        driver.navigate().refresh();
        contactPage.createNewContact(firstname, lastname);
    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
