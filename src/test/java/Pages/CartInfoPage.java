package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class CartInfoPage {
    WebDriver driver;
    WebDriverWait wdwait;
    String url;

    WebElement cardType;

    WebElement cardNumber;

    WebElement expiryDate;

    WebElement firstName;

    WebElement shipToDiffAddress;

    public CartInfoPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    WebElement continueButton;

    public WebElement getContinueButton() {
        return continueButton = driver.findElement(By.name("newOrder"));
    }

    public String getUrl() {
        return url = driver.getCurrentUrl();
    }

    public WebElement getCardType() {
        return cardType = driver.findElement(By.name("order.cardType"));
    }

    public WebElement getCardNumber() {
        return cardNumber = driver.findElement(By.name("order.creditCard"));
    }

    public WebElement getExpiryDate() {
        return expiryDate = driver.findElement(By.name("order.expiryDate"));
    }

    public WebElement getFirstName() {
        return firstName = driver.findElement(By.name("order.billToFirstName"));
    }

    public WebElement getShipToDiffAddress() {
        return shipToDiffAddress = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[14]/td/input"));
    }

    /////////
    public void selectShipToDiffAddress() {
        this.getShipToDiffAddress().click();
    }
}
