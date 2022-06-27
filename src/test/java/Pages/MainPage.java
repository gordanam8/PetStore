package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement fish;
    WebElement dog;
    WebElement cats;
    WebElement reptiles;
    WebElement birds;

    WebElement signInButton;

    String url;

    public MainPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getFish() {

        return fish = driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[1]/img"));
    }

    public WebElement getDog() {

        return dog = driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[2]/img"));
    }

    public WebElement getCats() {

        return cats = driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[3]/img"));
    }

    public WebElement getReptiles() {
        return reptiles = driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[4]/img"));
    }

    public WebElement getBirds() {
        return birds = driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[5]/img"));
    }

    public WebElement getSignInButton() {
        return signInButton = driver.findElement(By.linkText("Sign In"));
    }

    public void clickOnSignInButton() {
        this.getSignInButton().click();
    }

    public String getUrl() {
        return url = driver.getCurrentUrl();
    }
}
