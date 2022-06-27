package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FishPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement productIDANgelfish;
    WebElement productIdTigerShark;
    WebElement productIDKoi;
    WebElement productIDGoldfish;

    WebElement returnToMainMenu;


    public FishPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getProductIDANgelfish() {
        return productIDANgelfish = driver.findElement(By.linkText("FI-SW-01"));
    }

    public WebElement getProductIdTigerShark() {
        return productIdTigerShark = driver.findElement(By.linkText("FI-SW-02"));
    }

    public WebElement getProductIDKoi() {
        return productIDKoi = driver.findElement(By.linkText("FI-FW-01"));
    }

    public WebElement getProductIDGoldfish() {
        return productIDGoldfish = driver.findElement(By.linkText("FI-FW-02"));
    }

    public WebElement getReturnToMainMenu() {
        return returnToMainMenu = driver.findElement(By.linkText("Return to Main Menu"));
    }


}
