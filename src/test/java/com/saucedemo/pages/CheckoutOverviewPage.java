package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class CheckoutOverviewPage extends PageObject {

    private final By pageTitle;
    private final By finishButton;
    private final By cancelButton;
    private final By totalLabel;

    public CheckoutOverviewPage() {
        this.pageTitle = By.cssSelector(".title");
        this.finishButton = By.id("finish");
        this.cancelButton = By.id("cancel");
        this.totalLabel = By.cssSelector(".summary_total_label");
    }

    public boolean isCheckoutOverviewPageDisplayed() {
        return find(pageTitle).getText().equals("Checkout: Overview");
    }

    public String getPageTitle() {
        return find(pageTitle).getText();
    }

    public String getTotalAmount() {
        return find(totalLabel).getText();
    }

    public void finishOrder() {
        find(finishButton).click();
    }

    public void cancelOrder() {
        find(cancelButton).click();
    }
}
