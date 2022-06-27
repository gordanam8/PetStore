package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatsPage {
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement productIDManx;
    WebElement productIDPersian;

    public CatsPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getProductIDManx() {
        return productIDManx = driver.findElement(By.linkText("FL-DSH-01"));
    }

    public WebElement getProductIDPersian() {
        return productIDPersian = driver.findElement(By.linkText("FL-DLH-02"));
    }

}
