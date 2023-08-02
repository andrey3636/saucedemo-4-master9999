import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Double.parseDouble;

public class InventoryPage extends BasePage{
    public InventoryPage(WebDriver driver) {
       super(driver);
    }

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;
    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> inventoryNames;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> inventoryPrices;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuBtn;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCart;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLightAddToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement tShortAddToCart;
    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropDown;


    @FindBy(css = "[value='lohi']")
    private WebElement lowToHigh;


    @FindBy(css = "[value='hilo']")
    private WebElement highToLow;

    @FindBy(css = "[value=\"az\"]")
    private WebElement aToZ;

    @FindBy(css = "[value=\"za\"]")
    private WebElement zToA;






@Step("Inventory page is open")
    public boolean inventoryListIsDisplayed(){
        return inventoryList.isDisplayed();
    }
    public int getItemsQuantity(){
        return inventoryItems.size();
    }

    public boolean allItemsAreDisplayed(){
        boolean displayed = true;
        for (WebElement item:inventoryItems) {
            if(!item.isDisplayed()){
                displayed = false;
            }
        }
        return displayed;
    }


    public boolean allItemNamesAreDisplayed(){
        boolean displayed = true;
        for (WebElement name:inventoryNames) {
            if(!name.isDisplayed()){
                displayed = false;
            }
        }
        return displayed;
        // 1. is displayed == true (for all items)
        // 2. not empty (for all items)
    }

    public boolean allNamesAreNotEmpty(){
        boolean notEmpty = true;
        for (WebElement name:inventoryNames) {
            if(name.getText().isEmpty()){
                notEmpty = false;
            }
        }
        return notEmpty;
    }

    public boolean allNamesStartWithSauceLabs(){
        boolean allContains = true;
       // int index = 1;
        for (WebElement name:inventoryNames) {
            if (!name.getText().startsWith("Sauce Labs")){
                allContains=false;
                System.out.println("Item with product number "+ (inventoryNames.indexOf(name)+1) +" does not start with Sauce Labs" );
            }
           // index++;
        }
        return allContains;
    }

    public void clickOnBurgerMenuBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenuBtn));
        burgerMenuBtn.click();
    }

    public void clickOnBackpackAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(backpackAddToCart));
        backpackAddToCart.click();
    }
    public void clickOnBikeLightAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(bikeLightAddToCart));
        bikeLightAddToCart.click();
    }

    public void clickOnTshirtAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(tShortAddToCart));
        tShortAddToCart.click();
    }

    public void clickOnCartItem(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartIcon.click();
    }

    public String getPriceOfFirstItem(){
        return inventoryPrices.get(0).getText();
    }
    public void choosePriceLowToHighSortOption(){
    clickOnTheElement(sortDropDown);
    clickOnTheElement(lowToHigh);
    }

    public void chooseNameAtoZSortOption(){
        clickOnTheElement(sortDropDown);
        clickOnTheElement(aToZ);
    }

    public void chooseNameZtoASortOption(){
        clickOnTheElement(sortDropDown);
        clickOnTheElement(zToA);
    }

    public void choosePriceHighToLowSortOption(){
        clickOnTheElement(sortDropDown);
        clickOnTheElement(highToLow);
    }

    public boolean checkSortFromLowToHigh(){
    List<Double> actualPrice = new ArrayList<>();
    for (WebElement price:inventoryPrices) {
        actualPrice.add(parseDouble(price.getText().replaceAll("[^0-9.]","")));
    }

    List<Double> expectedPrices = new ArrayList<>(actualPrice);
        Collections.sort(expectedPrices);

        return actualPrice.equals(expectedPrices);

    }
    public boolean checkPriceSortFromHighToLow() {
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price : inventoryPrices) {
            actualPrices.add(parseDouble(price.getText().replaceAll("[^0-9.]", "")));
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices, Collections.reverseOrder());

        return actualPrices.equals(expectedPrices);
    }

    public boolean checkNameSortFromAToZ() {
        List<String> actualNames = new ArrayList<>();
        for (WebElement name : inventoryNames) {
            actualNames.add(name.getText());
        }
        List<String> expectedNames = new ArrayList<>(actualNames);
        Collections.sort(expectedNames);

        return actualNames.equals(expectedNames);
    }
    public boolean checkNameSortFromZToA() {
        List<String> actualNames = new ArrayList<>();
        for (WebElement name : inventoryNames) {
            actualNames.add(name.getText());
        }
        List<String> expectedNames = new ArrayList<>(actualNames);
        Collections.sort(expectedNames, Collections.reverseOrder());

        return actualNames.equals(expectedNames);
    }

}
