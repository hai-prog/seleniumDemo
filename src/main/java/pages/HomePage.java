package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class HomePage {
    WebDriver driver;

            //** Locators **//

    By pageTitle = By.xpath("(//div[@class=\"col-sm-6\"]/h1/span)[1]");
    By singUpAndLoginLink = By.xpath("(//ul[@class=\"nav navbar-nav\"]/li/a)[4]");

    By productsLink = By.xpath("(//ul[@class=\"nav navbar-nav\"]/li/a)[2]");

    By loggedInAS = By.xpath("(//ul[@class=\"nav navbar-nav\"]/li/a)[10]");
    By deleteAccount = By.xpath("(//ul[@class=\"nav navbar-nav\"]/li/a)[5]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


           //** Actions **//


    // navigate to singup/login page
    public void clickOnSingUpAndLogin()
    {
        ElementActions.click(driver, singUpAndLoginLink);

    }



    // navigate to products page
    public void clickOnProducts()
    {
        ElementActions.click(driver, productsLink);

    }

    public boolean isPageTitleVisible()
    {
        return driver.findElement(pageTitle).isDisplayed();
    }


    public boolean isLoggedAsUserNameVisible()
    {
        return driver.findElement(loggedInAS).isDisplayed();
    }

    public void clickDeleteAccount()
    {
        ElementActions.click(driver,deleteAccount);
    }

    public void clickOnLogOut()
    {
        ElementActions.click(driver, singUpAndLoginLink);

    }
}
