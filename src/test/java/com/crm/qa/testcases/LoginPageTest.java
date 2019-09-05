package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        initialization();   // super class constructor would be called
        loginPage = new LoginPage();  // super class + login class constructor would be called
    }

    @Test(priority = 2)
    public void loginPageTitleTest() {
        String actualTitle = loginPage.validateLoginPageTitle();
        String expectedTitle = "CRM";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(7000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
