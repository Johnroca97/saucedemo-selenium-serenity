package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageObject {

    private final By usernameField;
    private final By passwordField;
    private final By loginButton;
    private final By errorMessage;

    public LoginPage() {
        this.usernameField = By.id("user-name");
        this.passwordField = By.id("password");
        this.loginButton = By.id("login-button");
        this.errorMessage = By.cssSelector("[data-test='error']");
    }

    public void openLoginPage() {
        openUrl("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        find(usernameField).clear();
        find(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        find(passwordField).clear();
        find(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        find(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage() {
        return find(errorMessage).getText();
    }

    public boolean isErrorMessageDisplayed() {
        return find(errorMessage).isDisplayed();
    }
}
