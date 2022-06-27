package Test;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TestPetShope extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        //driver.navigate().to("https://petstore.octoperf.com/actions/Catalog.action");
        driver.get(mainPageURL);
    }

    /*@AfterMethod
    public void removeCookies () {
        driver.manage().deleteAllCookies();
    }*/

    @Test(priority = 10)
    public void successfulLogin() throws InterruptedException {
        ///////////////////////////////////////
        // Sign in
        /////////////////////////////////////
        mainPage.getSignInButton().click();
        String validUsername = String.valueOf(excelReader.getIntegerData("Login", 1, 0));
        String validPassword = excelReader.getStringData("Login", 1, 2);
        signInPage.insertUsername(validUsername);
        signInPage.insertPassword(validPassword);
        signInPage.clickOnLoginButton();

        // Check if user is signed in
        Assert.assertTrue(profilePage.getSignOutButton().isDisplayed());
        Assert.assertTrue(profilePage.getMyAccountButton().isDisplayed());
        Assert.assertTrue(profilePage.getWelcomeMessage().isDisplayed());

        ///////////////////////
        // Sign out
        //////////////////////
        profilePage.getSignOutButton().click();

        //confirm that Sign In Button exists
        Assert.assertTrue(elementVisibility(mainPage.getSignInButton()));

        //confirm that Sign Out button doesn't exist
        boolean check = true;
        try {
            check = profilePage.getSignOutButton().isDisplayed();
        } catch (Exception e) {
            check = false;
        }
        Assert.assertFalse(check);

        //confirm that My Account button doesn't exist
        check = true;
        try {
            check = profilePage.getMyAccountButton().isDisplayed();
        } catch (Exception e) {
            check = false;
        }
        Assert.assertFalse(check);

    }

    @Test(priority = 20)
    public void unsuccessfulLoginWithInvalidUsernameAndValidPassword() {
        mainPage.getSignInButton().click();
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 3);
            signInPage.insertUsername(invalidUsername);
            String validPassword = excelReader.getStringData("Login", 1, 2);
            signInPage.insertPassword(validPassword);
            signInPage.clickOnLoginButton();
        }
        Assert.assertTrue(signInPage.getLoginButton().isDisplayed());
        Assert.assertTrue(signInPage.getMessageSignonFailed().isDisplayed());
        Assert.assertTrue(mainPage.getSignInButton().isDisplayed());


    }

    @Test(priority = 30)
    public void unsuccessfulLoginWithValidUsernameAndInvalidPassword() {
        mainPage.getSignInButton().click();
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String validUsername = String.valueOf(excelReader.getIntegerData("Login", 1, 0));
            signInPage.insertUsername(validUsername);
            String invalidPassword = excelReader.getStringData("Login", i, 4);
            signInPage.insertPassword(invalidPassword);
            signInPage.clickOnLoginButton();
        }
        Assert.assertTrue(mainPage.getSignInButton().isDisplayed());
        Assert.assertTrue(signInPage.getLoginButton().isDisplayed());
        Assert.assertTrue(signInPage.getMessageSignonFailed().isDisplayed());


    }

    @Test(priority = 40)
    public void unsuccessfulLoginWithInvalidUsernameAndInvalidPassword() {
        mainPage.getSignInButton().click();
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 3);
            signInPage.insertUsername(invalidUsername);
            String invalidPassword = excelReader.getStringData("Login", i, 4);
            signInPage.insertPassword(invalidPassword);
            signInPage.clickOnLoginButton();
        }
        Assert.assertTrue(mainPage.getSignInButton().isDisplayed());
        Assert.assertTrue(signInPage.getLoginButton().isDisplayed());
        Assert.assertTrue(signInPage.getMessageSignonFailed().isDisplayed());


    }

    @Test(priority = 50)
    public void addProduct() {
        mainPage.getSignInButton().click();

        //read credentials from excel
        String validUsername = String.valueOf(excelReader.getIntegerData("Login", 1, 0));
        String validPassword = excelReader.getStringData("Login", 1, 2);

        //Log in
        signInPage.insertUsername(validUsername);
        signInPage.insertPassword(validPassword);
        signInPage.clickOnLoginButton();

        //go to Cats page
        profilePage.getCats().click();

        //add AdultFemalePersian to cart
        catsPage.getProductIDPersian().click();
        persianPage.getAdultFemalePersianAddToCart().click();

        //return to Main page
        shoppingCartPage.getReturnToMainPage();

        //go to Cats page
        profilePage.getCats().click();

        //add AdultMalePersian to cart
        catsPage.getProductIDPersian().click();
        persianPage.getAdultMalePersianAddToCart().click();

        //Assert that value of quantity for both Male and Female Persian cats is 1
        String expValue = "1";
        Assert.assertTrue(expValue.equals(shoppingCartPage.getQuantityAdultFemalePersian().getAttribute("value")));
        Assert.assertTrue(expValue.equals(shoppingCartPage.getQuantityAdultMalePersian().getAttribute("value")));

        //change quantity for both fields
        shoppingCartPage.getQuantityAdultFemalePersian().clear();
        shoppingCartPage.getQuantityAdultFemalePersian().sendKeys("2");
        shoppingCartPage.getQuantityAdultMalePersian().clear();
        shoppingCartPage.getQuantityAdultMalePersian().sendKeys("3");

        //update cart
        shoppingCartPage.getUpdateCart().click();

        //Assert that quantity is changed for bopth fields
        expValue = "2";
        Assert.assertTrue(expValue.equals(shoppingCartPage.getQuantityAdultFemalePersian().getAttribute("value")));
        expValue = "3";
        Assert.assertTrue(expValue.equals(shoppingCartPage.getQuantityAdultMalePersian().getAttribute("value")));

        //remove Male Persian cat from cart
        shoppingCartPage.getRemoveAdultMalePersian().click();

        //check that AdultMalePersian doesn't exist
        boolean check = true;
        try {
            check = shoppingCartPage.getQuantityAdultMalePersian().isDisplayed();
        } catch (Exception e) {
            check = false;
        }
        Assert.assertFalse(check);

        //click proceed to checkout
        shoppingCartPage.getProceedToCheckout().click();


        //check if we are on expected page
        String expUrl = "https://petstore.octoperf.com/actions/Order.action?newOrderForm=";
        Assert.assertTrue(expUrl.equals(cartInfoPage.getUrl()));

        // Check payment details
        String cardNumber = excelReader.getStringData("Payment Details", 1, 1);
        System.out.println("111111 " + cardNumber);
        System.out.println("22222 " + cartInfoPage.getCardNumber().getAttribute("value"));
        Assert.assertTrue(cardNumber.equals(cartInfoPage.getCardNumber().getAttribute("value")));
        System.out.println();

        //Check Billing Address
        String firstName = excelReader.getStringData("Login", 1, 5);
        Assert.assertTrue(firstName.equals(cartInfoPage.getFirstName().getAttribute("value")));

        //click Continue button
        cartInfoPage.getContinueButton().click();

        //chek if we are on expected page for confirm information
        expUrl = "https://petstore.octoperf.com/actions/Order.action";
        Assert.assertTrue(expUrl.equals(confirmInformationPage.getUrl()));

        //click Confirm button
        confirmInformationPage.getConfirmButton().click();

        //chek if we are on expected page for confirm information
        expUrl = "https://petstore.octoperf.com/actions/Order.action?newOrder=&confirmed=true";
        Assert.assertTrue(expUrl.equals(submittedOrderPage.getUrl()));

        //check if submitted message is present
        String expMessage = "Thank you, your order has been submitted.";
        Assert.assertTrue(expMessage.equals(submittedOrderPage.getSubmittedMessage().getText()));

        //return to Main Menu
        submittedOrderPage.getReturnToMainMenu().click();

        //check if we are on expected page
        expUrl = "https://petstore.octoperf.com/actions/Catalog.action";
        Assert.assertTrue(expUrl.equals(mainPageURL));

    }

    @Test(priority = 60)
    public void addProductAndOtherShippingAddress() throws InterruptedException {


        mainPage.getSignInButton().click();

        //read credentials from excel
        String validUsername = String.valueOf(excelReader.getIntegerData("Login", 1, 0));
        String validPassword = excelReader.getStringData("Login", 1, 2);

        //Log in
        signInPage.insertUsername(validUsername);
        signInPage.insertPassword(validPassword);
        signInPage.clickOnLoginButton();

        //go to Cats page
        profilePage.getCats().click();

        //add AdultFemalePersian to cart
        catsPage.getProductIDPersian().click();
        persianPage.getAdultFemalePersianAddToCart().click();

        //return to Main page
        shoppingCartPage.getReturnToMainPage();

        //go to Cats page
        profilePage.getCats().click();

        //add AdultMalePersian to cart
        catsPage.getProductIDPersian().click();
        persianPage.getAdultMalePersianAddToCart().click();

        //Assert that value of quantity for both Male and Female Persian cats is 1
        String expValue = "1";
        Assert.assertTrue(expValue.equals(shoppingCartPage.getQuantityAdultFemalePersian().getAttribute("value")));
        Assert.assertTrue(expValue.equals(shoppingCartPage.getQuantityAdultMalePersian().getAttribute("value")));

        //change quantity for both fields
        shoppingCartPage.getQuantityAdultFemalePersian().clear();
        shoppingCartPage.getQuantityAdultFemalePersian().sendKeys("2");
        shoppingCartPage.getQuantityAdultMalePersian().clear();
        shoppingCartPage.getQuantityAdultMalePersian().sendKeys("3");

        //update cart
        shoppingCartPage.getUpdateCart().click();

        //Assert that quantity is changed for both fields
        expValue = "2";
        Assert.assertTrue(expValue.equals(shoppingCartPage.getQuantityAdultFemalePersian().getAttribute("value")));
        expValue = "3";
        Assert.assertTrue(expValue.equals(shoppingCartPage.getQuantityAdultMalePersian().getAttribute("value")));

        //remove Male Persian cat from cart
        shoppingCartPage.getRemoveAdultMalePersian().click();

        //check that AdultMalePersian doesn't exist
        boolean check = true;
        try {
            check = shoppingCartPage.getQuantityAdultMalePersian().isDisplayed();
        } catch (Exception e) {
            check = false;
        }
        Assert.assertFalse(check);

        //click proceed to checkout
        shoppingCartPage.getProceedToCheckout().click();


        //check if we are on expected page
        String expUrl = "https://petstore.octoperf.com/actions/Order.action?newOrderForm=";
        Assert.assertTrue(expUrl.equals(cartInfoPage.getUrl()));

        // Check payment details
        String cardNumber = excelReader.getStringData("Payment Details", 1, 1);
        System.out.println("111111 " + cardNumber);
        System.out.println("22222 " + cartInfoPage.getCardNumber().getAttribute("value"));
        Assert.assertTrue(cardNumber.equals(cartInfoPage.getCardNumber().getAttribute("value")));
        System.out.println();

        //Check Billing Address
        String firstName = excelReader.getStringData("Login", 1, 5);
        Assert.assertTrue(firstName.equals(cartInfoPage.getFirstName().getAttribute("value")));

        //select ship to different address
        cartInfoPage.selectShipToDiffAddress();

        Assert.assertTrue(cartInfoPage.getShipToDiffAddress().isSelected());

        /*WebElement someElement = driver.findElement();
        Actions actions = new Actions (driver);
        actions.moveToElement(someElement);
        actions.perform();*/

        //click Continue button
        cartInfoPage.getContinueButton().click();

        //chek if url is as expected
        expUrl = "https://petstore.octoperf.com/actions/Order.action";
        Assert.assertTrue(expUrl.equals(shippingAddressPage.getUrl()));

        //read address2 from excel
        String address2 = excelReader.getStringData("Login", 1, 15);
        shippingAddressPage.insertAddress2(address2);

        //assert that address2 is changed
        address2 = "Papafave 5";
        System.out.println("11111111111111111 " + shippingAddressPage.getAdress2().getAttribute("value"));
        Assert.assertTrue(address2.equals(shippingAddressPage.getAdress2().getAttribute("value")));

        shippingAddressPage.clickOnContinueButton();

        String newAddress2 = "Papafave 5";
        Assert.assertTrue(newAddress2.equals(newShippingAddressPage.getNewAdress2().getText()));

        newShippingAddressPage.clickOnConfirmButton();

        //chek if we are on expected page for confirm information
        expUrl = "https://petstore.octoperf.com/actions/Order.action?newOrder=&confirmed=true";
        Assert.assertTrue(expUrl.equals(submittedOrderPage.getUrl()));

        //check if submitted message is present
        String expMessage = "Thank you, your order has been submitted.";
        Assert.assertTrue(expMessage.equals(submittedOrderPage.getSubmittedMessage().getText()));

        //return to Main Menu
        submittedOrderPage.getReturnToMainMenu().click();

        //check if we are on expected page
        expUrl = "https://petstore.octoperf.com/actions/Catalog.action";
        Assert.assertTrue(expUrl.equals(mainPageURL));



    }


}
