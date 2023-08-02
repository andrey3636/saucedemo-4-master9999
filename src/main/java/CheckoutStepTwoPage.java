import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Double.parseDouble;

public class CheckoutStepTwoPage extends BasePage{

    public CheckoutStepTwoPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "summary_subtotal_label")
    private WebElement itemTotal;

    public void clickOnFinishButton(){
        finishButton.click();
    }

    public double getItemTotal(){
        return parseDouble(itemTotal.getText().replace("Item total: $", ""));
    }
}
