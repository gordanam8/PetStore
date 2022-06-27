package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewShippingAddressPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement newAdress2;

    WebElement confirmButton;

    public NewShippingAddressPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getNewAdress2() {
        return newAdress2 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[15]/td[2]"));
    }

    public WebElement getConfirmButton() {
        return confirmButton = driver.findElement(By.linkText("Confirm"));
    }

    ////////////////
    public void clickOnConfirmButton () {
        this.getConfirmButton().click();
    }
}
