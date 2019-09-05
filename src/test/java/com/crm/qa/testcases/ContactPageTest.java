package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    // All Test classes are independent to each other

    public ContactPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();   // super class constructor would be called
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();  // super class + login class constructor would be called
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        contactsPage = homePage.clickOnContactsLink();
        Thread.sleep(4000);
    }

    @Test(priority = 1)
    public void verifyContactsPageLabel() {
        boolean b = contactsPage.verifyContactsLabel();
        Assert.assertTrue(b, "Contacts label is missing on the Page");
    }




    @Test(priority = 2)
    public void validateCreateNewContact() throws InterruptedException {
        contactsPage.clickOnNewContactLink();
        contactsPage.createNewContact("Rohit", "Mehta", "Google", "test@gmail.com");

    }


    /*
    // Need to work on this test case again
    @Test(priority = 2)
    public void selectSingleContactsTest(){
        contactsPage.selectContacts("ram kumar");
    }
     */

    /*
    @Test
    public void SelectMultipleContactsTest() {
        contactsPage.selectContacts("ram kumar");
        contactsPage.selectContacts("Akshay Mittal");
    }

     */

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
