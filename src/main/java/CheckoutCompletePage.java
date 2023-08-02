import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage{

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "complete-header")
    private WebElement successMessage;

    public String getSuccessMessageText(){
        return successMessage.getText();
    }
}
