package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//div[text()='Contacts']")
    WebElement contactsLabel;

    @FindBy(xpath = "//button[contains(text(),'New')]")
    WebElement newContactLink;


    // First Name
    @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastName;

    @FindBy(xpath = "//div[@name='company']//input[@class='search']")
    WebElement company;

    @FindBy(xpath = "//div[@class='ui right corner labeled input']//input[@name='value'] ")
    WebElement email;

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    WebElement saveBtn;


    // Initialization the Page Objects:
    public ContactsPage() {
        super();
        PageFactory.initElements(driver, this);  // this means its pointing to current class object
    }

    public void clickOnNewContactLink() {
        newContactLink.click();
    }

    public void createNewContact(String firstName, String lastName, String company, String email) throws InterruptedException {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.company.sendKeys(company);
        this.email.sendKeys(email);
        this.saveBtn.click();
        Thread.sleep(4000);
    }


    public boolean verifyContactsLabel() {
        return contactsLabel.isDisplayed();
    }

    public void selectContacts(String name) {
        // Need to change the Xpath for the below check box, after going through the naveen video
        // Video "How to become Genius in Xpath
        driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr/td[1]/div/label ")).click();
    }


}
