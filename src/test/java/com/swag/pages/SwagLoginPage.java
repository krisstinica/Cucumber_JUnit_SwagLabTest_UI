package com.swag.pages;

import com.swag.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLoginPage {
    public SwagLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;
    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement error;

    //LOGIN METHOD
    public void login(String user, String pass) {
        this.username.sendKeys(user);
        this.password.sendKeys(pass);
        this.loginButton.click();


    }
    //VERIFY THE MESSAGE METHOD
    public void errorMessage(String message) {
        String expected = message;
        String actual = error.getText();

        Assert.assertEquals(expected, actual);
    }

    //SWITCH USER CUSTOM METHOD
    public void userLogin(String username) {
        String usertype = username;
        String password = "secret_sauce";

        switch (usertype) {
            case "standard_user":
                this.username.sendKeys(username);
                this.password.sendKeys(password);
                this.loginButton.click();
                break;
            case "locked_out_user":
                this.username.sendKeys(username);
                this.password.sendKeys(password);
                this.loginButton.click();
                break;
            case "problem_user":
                this.username.sendKeys(username);
                this.password.sendKeys(password);
                this.loginButton.click();
                break;
            case "performance_glitch_user":
                this.username.sendKeys(username);
                this.password.sendKeys(password);
                this.loginButton.click();
                break;
            case "incorrectUsername":
                this.username.sendKeys(username);
                this.password.sendKeys("incorrectUsername");
                this.loginButton.click();
                break;



        }

    }

}
