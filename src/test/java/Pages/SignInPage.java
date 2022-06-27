package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;

public class SignInPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement userName;

    WebElement password;

    WebElement loginButton;

    WebElement messageSignonFailed;
    public SignInPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getUserName() {
        //return userName = driver.findElement(By.xpath("/html/body/div[2]/div/form/p[2]/input[1]"));
        //return userName = driver.findElement(By.id("Catalog")).findElement(By.id("stripes-319727726"));
        return userName = driver.findElement(By.name("username"));
    }

    public WebElement getPassword() {
        //return password = driver.findElement(By.xpath("/html/body/div[2]/div/form/p[2]/input[2]"));
        return userName = driver.findElement(By.name("password"));
    }

    public WebElement getLoginButton() {
        return loginButton = driver.findElement(By.name("signon"));

    }

    public WebElement getMessageSignonFailed() {
        return messageSignonFailed = driver.findElement(By.xpath("/html/body/div[2]/ul/li"));
    }

    public void insertUsername(String username) {
        this.getUserName().clear();
        this.getUserName().sendKeys(username);
    }

    public void insertPassword(String password) {
        this.getPassword().clear();
        this.getPassword().sendKeys(password);
    }

    public void clickOnLoginButton() {
        this.getLoginButton().click();
    }

}
