package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class LoginPage extends TestBase {

    // PageFactory or Object Repository using @FindBy

    @FindBy(name = "email")
    WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[text()='Sign Up']")
    WebElement signUpBtn;

    // // Initialization the pageFactory or Page Objects:
    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);  // this means its pointing to current class object
    }

    // Actions:
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public HomePage login(String em, String pw) throws InterruptedException {  // this method is returning HomePage
        this.email.sendKeys(em);
        this.password.sendKeys(pw);
        loginBtn.click();
        return new HomePage();
    }


}
