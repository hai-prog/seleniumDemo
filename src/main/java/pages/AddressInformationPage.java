package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class AddressInformationPage {
    WebDriver driver;

             //** Locators **//
    By firstNameField = By.xpath("//input[@data-qa=\"first_name\"]");
    By lastNameField = By.xpath("//input[@data-qa=\"last_name\"]");
    By companyField = By .xpath("//input[@data-qa=\"company\"]");
    By address1Field = By.xpath("//input[@data-qa=\"address\"]");
    By address2Field = By.xpath("//input[@data-qa=\"address2\"]");
    By countryField = By.xpath("//select[@data-qa=\"country\"]");
    By stateField = By.xpath("//input[@data-qa=\"state\"]");
    By cityField = By.xpath("//input[@data-qa=\"city\"]");
    By zipCodeField = By.xpath("//input[@data-qa=\"zipcode\"]");
    By mobileNumField = By.xpath("//input[@data-qa=\"mobile_number\"]");
    By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");


    public AddressInformationPage(WebDriver driver) {
        this.driver = driver;
    }


            //** Actions **//

    public void enterAddressInfo(String firstName , String lastName ,String company , String address1 , String address2 , String country ,
                                 String state , String city , String zipCode ,String mobileNum){
        ElementActions.setText(driver,firstNameField,firstName, true);
        ElementActions.setText(driver,lastNameField,lastName, true);
        ElementActions.setText(driver,companyField,company, true);
        ElementActions.setText(driver,address1Field,address1, true);
        ElementActions.setText(driver,address2Field,address2, true);
        ElementActions.select(driver,countryField,country, ElementActions.SelectType.TEXT);
        ElementActions.setText(driver,stateField,state, true);
        ElementActions.setText(driver,cityField,city, true);
        ElementActions.setText(driver,zipCodeField,zipCode, true);
        ElementActions.setText(driver,mobileNumField,mobileNum, true);
        ElementActions.click(driver,createAccountButton);
    }
}
