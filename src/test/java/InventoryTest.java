import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BaseTest{

    @Test
    public void itemElementsTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        // assert item quantity equals 6
        assertEquals(6, inventoryPage.getItemsQuantity());
        assertTrue(inventoryPage.allItemsAreDisplayed());
        assertTrue(inventoryPage.allItemNamesAreDisplayed());
        assertTrue(inventoryPage.allNamesAreNotEmpty());
        //all item names contains with "Sauce Labs"
        assertTrue("Not all names starts with Sauce Labs",inventoryPage.allNamesStartWithSauceLabs());
    }

    @Test
    public void sortPriceLowToHigh(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.choosePriceLowToHighSortOption();
        //check correct sort by "Price Low to High"
        assertTrue(inventoryPage.checkSortFromLowToHigh());
    }
    @Test
    public void sortPriceHighToLow(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.choosePriceHighToLowSortOption();
        assertTrue(inventoryPage.checkPriceSortFromHighToLow());
    }
    @Test
    public void sortNameAtoZ(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.checkNameSortFromAToZ();
        assertTrue(inventoryPage.checkNameSortFromAToZ());
    }

    @Test
    public void sortNameZtoA(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.chooseNameZtoASortOption();
        assertTrue(inventoryPage.checkNameSortFromZToA());
    }





}
