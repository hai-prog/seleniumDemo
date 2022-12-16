package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class CartPage {
    WebDriver driver ;

            //** Locators **//

    //** first product locators **//
    By firstProductName = By.xpath("(//td[@class=\"cart_description\"]/h4/a)[1]");
    By firstProductPrice = By.xpath("(//td[@class=\"cart_price\"])[1]");
    By firstProductQuantity = By.xpath("(//td[@class=\"cart_quantity\"])[1]");

    //** second product locators **//
    By secondProductName = By.xpath("(//td[@class=\"cart_description\"]/h4/a)[2]");
    By secondProductPrice = By.xpath("(//td[@class=\"cart_price\"])[2]");
    By secondProductQuantity = By.xpath("(//td[@class=\"cart_quantity\"])[2]");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


                           //** Actions **//

    public String getFirstProductName()
    {
        return   ElementActions.getText(driver,firstProductName);
    }

    public String getSecondProductName()
    {
        return   ElementActions.getText(driver,secondProductName);
    }

    public String getFirstProductPrice()
    {
        return   ElementActions.getText(driver,firstProductPrice);
    }

    public String getSecondProductPrice()
    {
        return   ElementActions.getText(driver,secondProductPrice);
    }

    public String getFirstProductQuantity()
    {
        return   ElementActions.getText(driver,firstProductQuantity);
    }

    public String getSecondProductQuantity()
    {
        return   ElementActions.getText(driver,secondProductQuantity);
    }

}
