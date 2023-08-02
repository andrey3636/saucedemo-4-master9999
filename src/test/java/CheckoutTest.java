import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutTest extends BaseTest{

    @Test
    public void testSuccessCheckout(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnBikeLightAddToCart();
        inventoryPage.clickOnTshirtAddToCart();
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterValueToFirstName("John");
        checkoutStepOnePage.enterValueToLastName("Black");
        checkoutStepOnePage.enterValueToZip("12345");
        checkoutStepOnePage.clickOnContinueButton();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutStepTwoPage.clickOnFinishButton();
        // assert text "Thank you for your order!" is displayed
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        System.out.println("Text from complete page: " + checkoutCompletePage.getSuccessMessageText());
        assertEquals("Thank you for your order!",
                checkoutCompletePage.getSuccessMessageText());
    }

    @Test
    public void checkFinalCoast(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnBikeLightAddToCart();
        inventoryPage.clickOnTshirtAddToCart();
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        double totalFromCart = cartPage.getTotalPriceOFItems();
        cartPage.clickOnCheckoutButton();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterValueToFirstName("John");
        checkoutStepOnePage.enterValueToLastName("Black");
        checkoutStepOnePage.enterValueToZip("12345");
        checkoutStepOnePage.clickOnContinueButton();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        assertEquals(totalFromCart,checkoutStepTwoPage.getItemTotal(),0);


    }
}
