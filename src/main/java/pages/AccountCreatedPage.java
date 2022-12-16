package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class AccountCreatedPage {
    WebDriver driver;


    //** Locators **//
    By accountCreatedMassage = By.xpath("//h2[@data-qa=\"account-created\"]/b");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }


    //** Actions **//

    public boolean isMassageVisible()
    {
        return driver.findElement(accountCreatedMassage).isDisplayed();
    }

    public void clickContinueButton()
    {
        ElementActions.click(driver,continueButton);
    }
}
