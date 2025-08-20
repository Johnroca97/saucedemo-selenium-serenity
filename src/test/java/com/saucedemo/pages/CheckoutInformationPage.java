package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class CheckoutInformationPage extends PageObject {

    private final By pageTitle;
    private final By firstNameField;
    private final By lastNameField;
    private final By postalCodeField;
    private final By continueButton;
    private final By cancelButton;

    public CheckoutInformationPage() {
        this.pageTitle = By.cssSelector(".title");
        this.firstNameField = By.id("first-name");
        this.lastNameField = By.id("last-name");
        this.postalCodeField = By.id("postal-code");
        this.continueButton = By.id("continue");
        this.cancelButton = By.id("cancel");
    }

    public boolean isCheckoutInformationPageDisplayed() {
        return find(pageTitle).getText().equals("Checkout: Your Information");
    }

    public void enterFirstName(String firstName) {
        find(firstNameField).clear();
        find(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        find(lastNameField).clear();
        find(lastNameField).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        find(postalCodeField).clear();
        find(postalCodeField).sendKeys(postalCode);
    }

    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }

    public void clickContinue() {
        find(continueButton).click();
    }

    public void clickCancel() {
        find(cancelButton).click();
    }
}
