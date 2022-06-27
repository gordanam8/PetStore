package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement quantityAdultFemalePersian;
    WebElement quantityAdultMalePersian;

    WebElement removeAdultFemalePersian;
    WebElement removeAdultMalePersian;
    WebElement returnToMainPage;

    WebElement proceedToCheckout;

    WebElement updateCart;

    public ShoppingCartPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getRemoveAdultFemalePersian() {
        return removeAdultFemalePersian = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/form/table/tbody/tr[2]/td[8]/a"));
    }

    public WebElement getRemoveAdultMalePersian() {
        return removeAdultMalePersian = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/form/table/tbody/tr[3]/td[8]/a"));
    }

    public WebElement getQuantityAdultFemalePersian() {
        return quantityAdultFemalePersian = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/form/table/tbody/tr[2]/td[5]/input"));
    }

    public WebElement getQuantityAdultMalePersian() {
        return quantityAdultMalePersian = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/form/table/tbody/tr[3]/td[5]/input"));
    }

    public WebElement getUpdateCart() {
        return updateCart = driver.findElement(By.name("updateCartQuantities"));
    }

    public WebElement getProceedToCheckout() {
        return proceedToCheckout = driver.findElement(By.linkText("Proceed to Checkout"));
    }

    public WebElement getReturnToMainPage() {
        return returnToMainPage = driver.findElement(By.linkText("Return to Main Menu"));
    }
}
