package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage extends PageObject {

    private final By pageTitle;
    private final By cartItems;
    private final By checkoutButton;
    private final By continueShoppingButton;
    private final By itemName;

    public CartPage() {
        this.pageTitle = By.cssSelector(".title");
        this.cartItems = By.cssSelector(".cart_item");
        this.checkoutButton = By.id("checkout");
        this.continueShoppingButton = By.id("continue-shopping");
        this.itemName = By.cssSelector(".inventory_item_name");
    }

    public boolean isCartPageDisplayed() {
        return find(pageTitle).getText().equals("Your Cart");
    }

    public String getPageTitle() {
        return find(pageTitle).getText();
    }

    public boolean isProductInCart(String productName) {
        return findAll(cartItems).stream()
                .anyMatch(item -> item.findElement(itemName).getText().equals(productName));
    }

    public List<String> getCartItemNames() {
        return findAll(cartItems).texts();
    }

    public int getCartItemsCount() {
        return findAll(cartItems).size();
    }

    public void proceedToCheckout() {
        find(checkoutButton).click();
    }

    public void continueShopping() {
        find(continueShoppingButton).click();
    }
}
