package com.swag.stepDefinitions;

import com.swag.pages.SwagLoginPage;
import com.swag.pages.SwagProductPage;
import com.swag.pages.SwagProductPage;
import com.swag.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Swag_StepDefs {

    SwagLoginPage login=new SwagLoginPage();
    SwagProductPage product=new SwagProductPage();
    String actualTitle;

    //_____BEFORE EVERY SCENARIO
    @Given(":User is on the login login")
    public void user_is_on_the_login_login() {
        Driver.getDriver().get("https://www.saucedemo.com/");
    }

    //____________________VALID USER STEPS

    @When("User enters valid password and username {string} and clicks login")
    public void userEntersValidPasswordAndUsernameAndClicksLogin(String validuser) {
        login.userLogin(validuser);
    }

    //_____________________________PRODUCTS TITLE TRUE ON PRODUCT PAGE
    @Then("User should see {string} displayed on Products page")
    public void userShouldSeeDisplayedOnProductsPage(String products) {
        actualTitle=product.productsTitle.getText();
        Assert.assertEquals(products,actualTitle);
    }


    //_________________LOCKED OUT USER STEPS

    @Then("{string} should be displayed")
    public void should_be_displayed(String message) {
        login.errorMessage(message);
    }

    //____________________PROBLEM USER STEPS
    //verified with Title again

    //_______________________GLITCH USER STEPS

    @Then("User should wait for five seconds to launch to Product page")
    public void user_should_wait_for_five_seconds_to_launch_to_product_page() {
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(product.productsTitle));
        //Assert.assertEquals("Products",product.productsTitle.getText());
        Assert.assertTrue(product.productsTitle.isDisplayed());
    }

    //_________________________INVALID CREDENTIALS STEPS
    @When("User enters invalid password and username {string} and clicks login")
    public void userEntersInvalidPasswordAndUsernameAndClicksLogin(String invalid) {
        login.userLogin(invalid);
    }
    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(login.error.isDisplayed());
    }

    //____________________________EMPTY USER AND PASSWORD FIELDS STEPS
    @When("User enters a blank username")
    public void user_enters_a_blank_username() {
        login.username.sendKeys("");
    }
    @When("User enters a blank password")
    public void user_enters_a_blank_password() {
        login.password.sendKeys("");
    }
    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        login.loginButton.click();
    }
    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String message) {
        login.errorMessage(message);

    }

    //__________________________EMPTY USER FIELD STEPS
    @When("User enters valid password {string}")
    public void user_enters_valid_password(String password) {
        login.password.sendKeys(password);
    }

    //___________________________EMPTY PASSWORD FIELD STEPS
    @When("User enters non-blank valid username {string}")
    public void user_enters_non_blank_valid_username(String validUser) {
        login.username.sendKeys(validUser);

    }
    //______________________UPPERCASE LOGIN DDT

    @When("User enters valid username uppercase {string}")
    public void userEntersValidUsernameUppercase(String upper) {
        login.username.sendKeys(upper);
    }

    //_______________________DDT OUTLINE MULTIPLE LOGIN

    @When("User enters valid password and userName {string} and clicks login")
    public void userEntersValidPasswordAndUserNameAndClicksLogin(String valid) {
        login.userLogin(valid);
    }

    @Then("User logs out")
    public void userLogsOut() {
        product.logout();
    }


}
