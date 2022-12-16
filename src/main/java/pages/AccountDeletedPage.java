package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class AccountDeletedPage {

    WebDriver driver;

    //** Locators **//

    By deleteAccountMassage = By.xpath("//h2[@class=\"title text-center\"]/b");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");


    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
    }

    //** Actions **//
    public boolean isMassageVisible()
    {
        return driver.findElement(deleteAccountMassage).isDisplayed();
    }

    public void clickContinueButton()
    {
        ElementActions.click(driver,continueButton);
    }

}
