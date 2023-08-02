import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepOnePage extends BasePage{
    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement zipCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public void enterValueToFirstName(String firstNameValue){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(firstNameValue);
    }

    public void enterValueToLastName(String lastNameValue){
        lastName.sendKeys(lastNameValue);
    }

    public void enterValueToZip(String zipValue){
        zipCode.sendKeys(zipValue);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

}
