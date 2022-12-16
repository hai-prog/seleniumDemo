package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

import static org.testng.AssertJUnit.fail;

public class AccountInformationPage {
    WebDriver driver;


            //** Locators **//

    By accountInfoTitle = By.xpath("(//h2[@class=\"title text-center\"]/b)[1]");
    By titleRadio1 = By.xpath("(//div[@data-qa=\"title\"])[1]");
    By titleRadio2 = By.xpath("(//div[@data-qa=\"title\"])[2]");
    By nameField = By.xpath("//input[@data-qa=\"name\"]");
    By emailField = By.xpath("//input[@data-qa=\"email\"]");
    By passwordField = By.xpath("//input[@data-qa=\"password\"]");
    By daysDropdownList = By.xpath("//select[@data-qa=\"days\"]");
    By monthsDropdownList = By.xpath("//select[@data-qa=\"months\"]");
    By yearsDropdownList = By.xpath("//select[@data-qa=\"years\"]");
    By checkBox1 = By.xpath("//input[@id=\"newsletter\"]");
    By checkBox2 =By.xpath("//input[@id=\"optin\"]");


    public AccountInformationPage(WebDriver driver) {
        this.driver = driver;
    }


                     //** Actions **//
    public boolean isAccountInfoTitleVisible()
    {
        return driver.findElement(accountInfoTitle).isDisplayed();
    }
    public void enterAccountInfo(String titleOption , String name, String email , String password , String dayOption , String monthOption , String yearOption , String checkBoxOption ) {

        if (titleOption == "Mr") {
            ElementActions.click(driver, titleRadio1);
        } else if (titleOption == "Mrs") {
            ElementActions.click(driver, titleRadio2);
        } else {
            fail("Unexpected value");
        }

        ElementActions.setText(driver, nameField, name, true);
        ElementActions.setText(driver, emailField, email, true);
        ElementActions.setText(driver, passwordField, password, true);
        ElementActions.select(driver, daysDropdownList, dayOption, ElementActions.SelectType.VALUE);
        ElementActions.select(driver, monthsDropdownList, monthOption, ElementActions.SelectType.TEXT);
        ElementActions.select(driver, yearsDropdownList, yearOption, ElementActions.SelectType.VALUE);

        if (checkBoxOption == "Sign up for our newsletter!") {
            ElementActions.click(driver, checkBox1);
        } else if (checkBoxOption == "Receive special offers from our partners!") {
            ElementActions.click(driver, checkBox2);
        } else {
            fail("Unexpected value");
        }

    }}
