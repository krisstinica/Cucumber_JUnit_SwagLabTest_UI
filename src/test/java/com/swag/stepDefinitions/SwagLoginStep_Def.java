package com.swag.stepDefinitions;

import com.swag.pages.SwagLoginlogin;
import com.swag.pages.SwagProductlogin;
import com.swag.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwagLoginStep_Def {
    SwagLoginlogin login=new SwagLoginlogin();
    SwagProductlogin product=new SwagProductlogin();
    String actualTitle;
    @Given(":User is on the login login")
    public void user_is_on_the_login_login() {
        Driver.getDriver().get("https://www.saucedemo.com/");
    }

    //____________________VALID USER STEPS

    @When("User enters valid password and username {string}")
    public void userEntersValidPasswordAndUsername(String username) {
        login.userLogin(username);
    }

    //_____________________________PRODUCTS TITLE TRUE ON PRODUCT login
    @Then("User should see {string} displayed on Products login")
    public void user_should_see_displayed_on_products_login(String products) {
        actualTitle=product.productsTitle.getText();
        Assert.assertEquals(products,actualTitle);
    }

    //_________________LOCKED OUT USER STEPS

    @Then("{string} should be displayed")
    public void should_be_displayed(String message) {
        login.errorMessage(message);
    }

    //____________________PROBLEM USER STEPS

    @Then("User should not be able to add Sauce Labs Fleece Jacket")
    public void user_should_not_be_able_to_add_sauce_labs_fleece_jacket() {
        boolean isDisabled=!product.fleeceAdd.isEnabled();
        Assert.assertEquals(false,isDisabled);
    }
    //_______________________GLITCH USER STEPS

    @Then("User should wait for five seconds to launch to Product login")
    public void user_should_wait_for_five_seconds_to_launch_to_product_login() {
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(product.productsTitle));
        Assert.assertEquals("Products",product.productsTitle.getText());
    }

//_________________________INVALID CREDENTIALS STEPS
@When("User enters invalid password and username {string}")
public void userEntersInvalidPasswordAndUsername(String invalid) {
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
    public void user_enters_valid_password(String passwaord) {
        login.password.sendKeys(passwaord);
    }

    //___________________________EMPTY PASSWORD FIELD STEPS
    @When("User enters non-blank valid username {string}")
    public void user_enters_non_blank_valid_username(String validUser) {
        login.username.sendKeys(validUser);

    }

    //_______________________DDT OUTLINE MULTIPLE LOGIN

    @When("User enters valid userName {string}")
    public void user_enters_valid_user_name(String validUSer) {
        login.userLogin(validUSer);
    }


    @Then("User logs out")
    public void userLogsOut() {
        product.logout();
    }



}
