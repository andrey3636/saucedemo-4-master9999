import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    ChromeDriver driver;
    String BASE_URL = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MR Popovics\\OneDrive\\Рабочий стол\\Drive\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(BASE_URL);
    }

//    @After
    public void tearDown(){
        driver.quit();
    }

    @Rule
    public TestWatcher screenShotFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            //make screenshot
            makeScreenshotOnFailure();
            driver.close();
            driver.quit();
        }

        @Override
        protected void succeeded(Description description) {
            driver.close();
            driver.quit();
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            makeScreenshotOnFailure();
            driver.close();
            driver.quit();
        }

        @Attachment
        public byte[] makeScreenshotOnFailure(){
            return  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        }
    };

    String validUserNameValue = "standard_user";
    String validUSerPasswordValue = "secret_sauce";
    User validUser = new User(validUserNameValue,validUSerPasswordValue);
    User lockedOutUser = new User("locked_out_user","secret_sauce");
    User invalidUser = new User("jgsacgjfkcdsgfc", "secret_sauce");
}
