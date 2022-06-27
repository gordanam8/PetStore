package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public MainPage mainPage;

    public SignInPage signInPage;
    public ExcelReader excelReader;
    public String mainPageURL;
    public ProfilePage profilePage;

    public FishPage fishPage;

    public CatsPage catsPage;

    public ManxPage manxPage;

    public PersianPage persianPage;

    public ShoppingCartPage shoppingCartPage;

    public CartInfoPage cartInfoPage;

    public ConfirmInformationPage confirmInformationPage;

    public SubmittedOrderPage submittedOrderPage;

    public ShippingAddressPage shippingAddressPage;

    public NewShippingAddressPage newShippingAddressPage;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        mainPage = new MainPage(driver, wdwait);
        signInPage = new SignInPage(driver, wdwait);
        profilePage = new ProfilePage(driver, wdwait);
        fishPage = new FishPage(driver, wdwait);
        catsPage = new CatsPage(driver, wdwait);
        manxPage = new ManxPage(driver, wdwait);
        persianPage = new PersianPage(driver, wdwait);
        shoppingCartPage = new ShoppingCartPage(driver, wdwait);
        cartInfoPage = new CartInfoPage(driver, wdwait);
        confirmInformationPage = new ConfirmInformationPage(driver, wdwait);
        submittedOrderPage = new SubmittedOrderPage(driver, wdwait);
        shippingAddressPage = new ShippingAddressPage(driver, wdwait);
        newShippingAddressPage = new NewShippingAddressPage(driver, wdwait);

        excelReader = new ExcelReader("TestData.xlsx"); // TODO put valid file path

        mainPageURL = excelReader.getStringData("URLs", 1, 0);

    }
    public void visibilityWait(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickabilityWait(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean elementVisibility(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void elementPresent(WebElement element) {
        boolean check = false;
        try {
            check = element.isDisplayed();
        } catch (Exception e){
            check = false;
        }
        Assert.assertTrue(check);
    }

    public void elementNotPresent(WebElement element) {
        boolean check = true;
        try {
            check = element.isDisplayed();
        } catch (Exception e) {
            check = false;
        }
        Assert.assertFalse(check);
    }

    @AfterMethod
    public void removeCookies () {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
        //driver.close();
        //driver.quit();

    }

}
