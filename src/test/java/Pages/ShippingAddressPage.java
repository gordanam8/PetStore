package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingAddressPage {
    WebDriver driver;
    WebDriverWait wdwait;

    String url;
    WebElement adress2;

    WebElement continueButton;


    public ShippingAddressPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public String getUrl() {
        return url = driver.getCurrentUrl();
    }

    public WebElement getAdress2() {
        return adress2 = driver.findElement(By.name("order.shipAddress2"));
    }


    public WebElement getContinueButton() {
        return continueButton = driver.findElement(By.name("newOrder"));
    }

    ////////////////////////////////////////////////////////
    public void insertAddress2(String adress2) {
        this.getAdress2().clear();
        this.getAdress2().sendKeys(adress2);
    }

    public void clickOnContinueButton() {
        this.getContinueButton().click();
    }


}
