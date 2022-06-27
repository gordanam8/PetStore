package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmInformationPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement confirmButton;

    String url;

    WebElement returnToMainPage;

    public ConfirmInformationPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getConfirmButton() {
        return confirmButton = driver.findElement(By.linkText("Confirm"));
    }

    public String getUrl() {
        return url = driver.getCurrentUrl();
    }

    public WebElement getReturnToMainPage() {
        return returnToMainPage = driver.findElement(By.linkText("Return to Main Menu"));
    }
}
