package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubmittedOrderPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement returnToMainMenu;
    String url;

    WebElement submittedMessage;

    public SubmittedOrderPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getReturnToMainMenu() {
        return returnToMainMenu = driver.findElement(By.linkText("Return to Main Menu"));
    }

    public String getUrl() {
        return url = driver.getCurrentUrl();
    }

    public WebElement getSubmittedMessage() {
        return submittedMessage = driver.findElement(By.className("messages")).findElement(By.tagName("li"));
    }
}
