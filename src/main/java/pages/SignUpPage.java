package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class SignUpPage {

    WebDriver driver;

               // Locators//

    By singUpTitle = By.xpath("//div[@class=\"signup-form\"]/h2");
    By nameField = By.xpath("//input[@data-qa=\"signup-name\"]");
    By emailField = By.xpath("//input[@data-qa=\"signup-email\"]");
    By singUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");

    By errorMassageOfExitingAccount = By.xpath("//form[@action=\"/signup\"]/p");



    public SignUpPage(WebDriver driver) {
        this.driver= driver;
    }

                                // Actions//

    public boolean isSingUpTitleVisible()
    {
      return driver.findElement(singUpTitle).isDisplayed();
    }

    public void singUp(String name , String email){
        ElementActions.setText(driver,nameField,name,true);
        ElementActions.setText(driver, emailField,email,true);
        ElementActions.click(driver,singUpButton);

    }

    public String getErrorMassage()
    {
        return ElementActions.getText(driver,errorMassageOfExitingAccount);
    }
}
