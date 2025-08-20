package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class CheckoutCompletePage extends PageObject {

    private final By pageTitle;
    private final By confirmationHeader;
    private final By confirmationText;
    private final By backToProductsButton;

    public CheckoutCompletePage() {
        this.pageTitle = By.cssSelector(".title");
        this.confirmationHeader = By.cssSelector(".complete-header");
        this.confirmationText = By.cssSelector(".complete-text");
        this.backToProductsButton = By.id("back-to-products");
    }

    public boolean isCheckoutCompletePageDisplayed() {
        return find(pageTitle).getText().equals("Checkout: Complete!");
    }

    public String getPageTitle() {
        return find(pageTitle).getText();
    }

    public String getConfirmationMessage() {
        return find(confirmationHeader).getText();
    }

    public String getConfirmationText() {
        return find(confirmationText).getText();
    }

    public void backToProducts() {
        find(backToProductsButton).click();
    }
}
