package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManxPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement taillessManx;
    WebElement 	withTailManx;

    WebElement taillessManxAddToCart;
    WebElement 	withTailManxAddToCart;

    WebElement returnToCats;

    public ManxPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getTaillessManx() {
        return taillessManx = driver.findElement(By.linkText("EST-14"));
    }

    public WebElement getWithTailManx() {
        return withTailManx = driver.findElement(By.linkText("EST-15"));
    }

    public WebElement getTaillessManxAddToCart() {
        return taillessManxAddToCart = driver.findElement(By.cssSelector("a[href*='EST-14']"));
    }

    public WebElement getWithTailManxAddToCart() {
        return withTailManxAddToCart = driver.findElement(By.cssSelector("a[href*='EST-15']"));
    }

    public WebElement getReturnToCats() {
        return returnToCats = driver.findElement(By.linkText("Return to CATS"));
    }
}
