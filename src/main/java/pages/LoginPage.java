package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class LoginPage {
    WebDriver driver;

                // Locators //

    By loginPageTitle = By.xpath("//div[@class=\"login-form\"]/h2");

    By emailAddressField = By.xpath("//input[@data-qa=\"login-email\"]");
    By passwordField = By.xpath("//input[@data-qa=\"login-password\"]");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");

    By errorMassage = By.xpath("//form[@action=\"/login\"]/p");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


               // Actions//

    public String getTitle()
    {
        return ElementActions.getText(driver,loginPageTitle);
    }

    public void login(String emailAddress , String password)
    {
        ElementActions.setText(driver,emailAddressField,emailAddress,true);
        ElementActions.setText(driver,passwordField,password,true);
        ElementActions.click(driver,loginButton);
    }

    public String getErrorMassage()
    {
        return ElementActions.getText(driver, errorMassage);
    }


}
