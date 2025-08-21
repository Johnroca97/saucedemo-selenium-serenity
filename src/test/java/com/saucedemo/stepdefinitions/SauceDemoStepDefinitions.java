package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.*;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

public class SauceDemoStepDefinitions {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutInformationPage checkoutInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;

    @Given("I am on the SauceDemo login page")
    public void i_am_on_the_sauce_demo_login_page() {
        loginPage.openLoginPage();
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should see the products page")
    public void i_should_see_the_products_page() {
        assertTrue(productsPage.isProductsPageDisplayed(), "Products page should be displayed");
        assertEquals("Products", productsPage.getPageTitle(), "Page title should be 'Products'");
    }

    @When("I add {string} to the cart")
    public void i_add_product_to_the_cart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @When("I remove {string} from the cart")
    public void i_remove_product_from_the_cart(String productName) {
        productsPage.removeProductFromCart(productName);
    }

    @Then("I should see {int} items in the cart")
    public void i_should_see_items_in_the_cart(int expectedCount) {
        assertEquals(expectedCount, productsPage.getCartItemCount(),
                "Cart should contain " + expectedCount + " items");
    }

    @When("I go to the cart")
    public void i_go_to_the_cart() {
        productsPage.goToCart();
    }

    @Then("I should see {string} in the cart")
    public void i_should_see_product_in_the_cart(String productName) {
        assertTrue(cartPage.isProductInCart(productName),
                "Product '" + productName + "' should be in the cart");
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        cartPage.proceedToCheckout();
    }

    @When("I fill the checkout information with:")
    public void i_fill_the_checkout_information_with(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String postalCode = data.get("postalCode");

        assertTrue(checkoutInformationPage.isCheckoutInformationPageDisplayed(),
                "Checkout information page should be displayed");
        checkoutInformationPage.fillCheckoutInformation(firstName, lastName, postalCode);
    }

    @When("I continue to checkout overview")
    public void i_continue_to_checkout_overview() {
        checkoutInformationPage.clickContinue();
    }

    @Then("I should see the order summary")
    public void i_should_see_the_order_summary() {
        assertTrue(checkoutOverviewPage.isCheckoutOverviewPageDisplayed(),
                "Checkout overview page should be displayed");
        assertEquals("Checkout: Overview", checkoutOverviewPage.getPageTitle(),
                "Page title should be 'Checkout: Overview'");
    }

    @When("I finish the order")
    public void i_finish_the_order() {
        checkoutOverviewPage.finishOrder();
    }

    @Then("I should see the order confirmation")
    public void i_should_see_the_order_confirmation() {
        assertTrue(checkoutCompletePage.isCheckoutCompletePageDisplayed(),
                "Checkout complete page should be displayed");
        assertEquals("Checkout: Complete!", checkoutCompletePage.getPageTitle(),
                "Page title should be 'Checkout: Complete!'");
    }

    @Then("I should see {string} message")
    public void i_should_see_message(String expectedMessage) {
        String actualMessage = checkoutCompletePage.getConfirmationMessage();
        assertEquals(expectedMessage, actualMessage,
                "Confirmation message should match expected message");
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedError) {
        assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        assertEquals(expectedError, loginPage.getErrorMessage(),
                "Error message should match expected text");
    }
}