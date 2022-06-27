package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersianPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement adultFemalePersian;
    WebElement adultMalePersian;

    WebElement adultFemalePersianAddToCart;
    WebElement adultMalePersianAddToCart;

    WebElement returnToCats;
    public PersianPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getAdultFemalePersian() {
        return adultFemalePersian = driver.findElement(By.linkText("EST-16"));
    }

    public WebElement getAdultMalePersian() {
        return adultMalePersian = driver.findElement(By.linkText("EST-17"));
    }

    public WebElement getAdultFemalePersianAddToCart() {
        return adultFemalePersianAddToCart = driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td[5]/a"));
    }

    public WebElement getAdultMalePersianAddToCart() {
        return adultMalePersianAddToCart = driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[3]/td[5]/a"));
    }

    public WebElement getReturnToCats() {
        return returnToCats = driver.findElement(By.linkText("Return to CATS"));
    }
}
