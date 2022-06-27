package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AngelFishPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement largeAngelFish;
    WebElement smallAngelFish;

    WebElement largeAngelFishAddToCart;
    WebElement smallAngelFishAddToCart;

    WebElement returnToFishButton;

    public AngelFishPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getLargeAngelFish() {
        return largeAngelFish = driver.findElement(By.linkText("EST-1"));
    }

    public WebElement getSmallAngelFish() {
        return smallAngelFish = driver.findElement(By.linkText("EST-2"));
    }

    public WebElement getLargeAngelFishAddToCart() {
        return largeAngelFishAddToCart = driver.findElement(By.cssSelector("a[href*='EST-1']"));
    }

    public WebElement getSmallAngelFishAddToCart() {
        return smallAngelFishAddToCart = driver.findElement(By.cssSelector("a[href*='EST-2']"));
    }

    public WebElement getReturnToFishButton() {
        return returnToFishButton = driver.findElement(By.linkText("Return to FISH"));
    }
}
