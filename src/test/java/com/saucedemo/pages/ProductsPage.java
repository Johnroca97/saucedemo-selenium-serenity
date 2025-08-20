package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductsPage extends PageObject {

    private final By pageTitle;
    private final By cartBadge;
    private final By cartIcon;
    private final By inventoryItems;

    public ProductsPage() {
        this.pageTitle = By.cssSelector(".title");
        this.cartBadge = By.cssSelector(".shopping_cart_badge");
        this.cartIcon = By.cssSelector(".shopping_cart_link");
        this.inventoryItems = By.cssSelector(".inventory_item");
    }

    public boolean isProductsPageDisplayed() {
        return find(pageTitle).getText().equals("Products");
    }

    public String getPageTitle() {
        return find(pageTitle).getText();
    }

    public void addProductToCart(String productName) {
        WebElement product = findProductByName(productName);
        WebElement addButton = product.findElement(By.cssSelector("button[id*='add-to-cart']"));
        addButton.click();

        element(cartBadge).waitUntilVisible();
    }

    public void removeProductFromCart(String productName) {
        WebElement product = findProductByName(productName);
        WebElement removeButton = product.findElement(By.cssSelector("button[id*='remove']"));
        removeButton.click();

        waitABit(500);
    }

    public void goToCart() {
        find(cartIcon).click();
    }

    public int getCartItemCount() {
        try {
            element(cartBadge).waitUntilPresent();
            return Integer.parseInt(find(cartBadge).getText());
        } catch (Exception e) {
            return 0;
        }
    }

    private WebElement findProductByName(String productName) {
        return findAll(inventoryItems).stream()
                .filter(item -> item.findElement(By.cssSelector(".inventory_item_name")).getText().equals(productName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found: " + productName));
    }
}
