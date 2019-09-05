package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//div[@class='right menu']//span[text()='Rohit Mehta']")
    WebElement userNameLabel;

    @FindBy(xpath = "//span[text()='Contacts']")
    WebElement contactsLink;

    @FindBy(xpath = "//span[text()='Deals']")
    WebElement dealsLink;

    @FindBy(xpath = "//span[text()='Tasks']")
    WebElement tasksLink;

    // Initialization the Page Objects:
    public HomePage() {
        super();
        PageFactory.initElements(driver, this);  // this means its pointing to current class object
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }


    public Boolean verifyCorrectUserName() {
        return userNameLabel.isDisplayed();

    }

    public ContactsPage clickOnContactsLink() {
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink() {
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink() {
        tasksLink.click();
        return new TasksPage();
    }


}
