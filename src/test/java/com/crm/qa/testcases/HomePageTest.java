package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    //TestUtil testUtil;


    public HomePageTest() {
        super();
    }

    // Test cases should be separated -- independent with each other
    // Before each test cases -- launch the browser and login
    // @Test  -- execute test case
    // After each test case -- close the browser

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();   // super class constructor would be called
        // testUtil=new TestUtil();
        loginPage = new LoginPage();  // super class + login class constructor would be called
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }


    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "CRM", "Home Page title is not matched");
    }

    @Test(priority = 2)
    public void verifyUserNameTest() {
        Boolean b = homePage.verifyCorrectUserName();
        Assert.assertTrue(b);

    }

    @Test(priority = 3)
    public void verifyContactsLinkTest() {
        contactsPage = homePage.clickOnContactsLink();
    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}
