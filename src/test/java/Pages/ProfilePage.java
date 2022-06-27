package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement signOutButton;

    WebElement myAccountButton;

    WebElement welcomeMessage;

    WebElement fish;
    WebElement dog;
    WebElement cats;
    WebElement reptiles;
    WebElement birds;

    public ProfilePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getSignOutButton() {
        return signOutButton = driver.findElement(By.linkText("Sign Out"));
    }

    public WebElement getMyAccountButton() {
        return myAccountButton = driver.findElement(By.linkText("My Account"));

    }

    public WebElement getWelcomeMessage() {
        return welcomeMessage = driver.findElement(By.id("WelcomeContent"));
    }

    public void clickOnSignOutButton() {
        this.getSignOutButton().click();
    }
    public void clickOnMyAccountButton() {
        this.getMyAccountButton().click();
    }

    public WebElement getFish() {
        //return fish = driver.findElement(By.partialLinkText("FISH"));
        return fish = driver.findElement(By.cssSelector("a[href*='FISH']"));

    }

    public WebElement getDog() {
        return dog = driver.findElement(By.cssSelector("a[href*='DOGS']"));
    }

    public WebElement getCats() {
        return cats = driver.findElement(By.cssSelector("a[href*='CATS']"));
    }

    public WebElement getReptiles() {
        return reptiles = driver.findElement(By.cssSelector("a[href*='REPTILES']"));
    }

    public WebElement getBirds() {
        return birds = driver.findElement(By.cssSelector("a[href*='BIRDS']"));
    }
}
