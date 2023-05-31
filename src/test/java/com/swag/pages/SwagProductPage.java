package com.swag.pages;

import com.swag.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagProductPage {


    public SwagProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    public WebElement cartsymbol;

    @FindBy(xpath = "//div[@class='bm-burger-button']")
    public WebElement dropdown;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    public WebElement logout;

    @FindBy(xpath = "//a[@id='item_4_img_link']")
    public WebElement dogPix;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    public WebElement fleeceAdd;

    @FindBy(xpath = "//span[.='Products']")
    public WebElement productsTitle;


    public void logout() {
        dropdown.click();
        logout.click();

    }
}


