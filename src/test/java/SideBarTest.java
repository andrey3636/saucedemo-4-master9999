
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class SideBarTest extends BaseTest{
    @Test
    public void CheckAllLinksAreDisplayedTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickOnBurgerMenuBtn();
        SideBar sideBar = new SideBar(driver);
        //check All items, About, Logout,Reset App State - are enabled
        assertTrue(sideBar.allItemsIsEnabled());
        assertTrue(sideBar.aboutIsEnabled());
        assertTrue(sideBar.logoutIsEnabled());
        assertTrue(sideBar.resetAppStateIsEnabled());
        assertTrue(sideBar.allItemsIsDisplayed());
    }


}
