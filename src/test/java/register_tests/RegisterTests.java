package register_tests;
/*
Testcases related to register users

  Test Case 1: Register User
  Test Case 5: Register User with existing email
  Test Case  : Delete functionality
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.*;

public class RegisterTests {
    WebDriver driver;
    HomePage homePage ;
    SoftAssert softAssert;
    SignUpPage signUpPage;
    AccountInformationPage accountInformationPage;
    AddressInformationPage addressInformationPage;
    AccountCreatedPage accountCreatedPage;
    AccountDeletedPage accountDeletedPage;


    @Test (  testName ="Test Case 1: Register User"
            ,description = "Validate registerNewUser functionality with valid data and make sure the account is created successfully")
    public void testRegisterUserSuccessfully()
    {
        // Verify that home page is visible successfully
        softAssert.assertTrue(homePage.isPageTitleVisible());

        // Click on 'Signup / Login' button
        homePage.clickOnSingUpAndLogin();

        // Verify 'New User Signup!' is visible
        softAssert.assertTrue(signUpPage.isSingUpTitleVisible());

        // Enter name and email address
        signUpPage.singUp("Haidy","hh0@gmail.com");

        // Verify navigating to accountInfoPage and 'ENTER ACCOUNT INFORMATION' is visible
        softAssert.assertTrue(accountInformationPage.isAccountInfoTitleVisible());

        // Fill Info details: Title, Name, Email, Password, Date of birth in accountInformationPage
        accountInformationPage.enterAccountInfo("Mrs","Haidy", "hh0@gmail.com","01233","10","May","1990","Sign up for our newsletter!");

        // Fill address details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number in addressInformationPage.
        addressInformationPage.enterAddressInfo("Haidy","osama","Vois","Giza","Giza","India","Mompay","Mompay","02","0102043");

        // Verify that 'ACCOUNT CREATED!' is visible
        softAssert.assertTrue(accountCreatedPage.isMassageVisible());

        // Click 'Continue' button
        accountCreatedPage.clickContinueButton();

        //  Verify that 'Logged in as username' is visible in homePage
        softAssert.assertTrue(homePage.isLoggedAsUserNameVisible());


        softAssert.assertAll();

    }


    @Test (   testName = "Test Case 5: Register User with existing email"
            , description = "Verify that error 'Email Address already exist!' is visible when you singUp with existing email"
            , dependsOnMethods = "testRegisterUserSuccessfully")
    public void testRegisterUserWithExistingEmail()
    {
        // Verify that home page is visible successfully
        softAssert.assertTrue(homePage.isPageTitleVisible());

        // Click on 'Signup / Login' button
        homePage.clickOnSingUpAndLogin();

        // Verify 'New User Signup!' is visible
        softAssert.assertTrue(signUpPage.isSingUpTitleVisible());

        // Enter name and email address
        signUpPage.singUp("Haidy","hh0@gmail.com");

        //  Verify error 'Email Address already exist!' is visible
        softAssert.assertEquals(signUpPage.getErrorMassage(),"Email Address already exist!");

        softAssert.assertAll();
    }

    @Test(testName = "Test Case  : Delete functionality"
            , description = "verify that i can delete my account successfully and get this massage 'ACCOUNT DELETED!' ")
    public void testDeleteFunctionality()
    {
        // Verify that home page is visible successfully
        softAssert.assertTrue(homePage.isPageTitleVisible());

        // Click on 'Signup / Login' button
        homePage.clickOnSingUpAndLogin();

        // Verify 'New User Signup!' is visible
        softAssert.assertTrue(signUpPage.isSingUpTitleVisible());

        // Enter name and email address
        signUpPage.singUp("Haid","l@gmail.com");

        // Verify navigating to accountInfoPage and 'ENTER ACCOUNT INFORMATION' is visible
        softAssert.assertTrue(accountInformationPage.isAccountInfoTitleVisible());

        // Fill Info details: Title, Name, Email, Password, Date of birth in accountInformationPage
        accountInformationPage.enterAccountInfo("Mrs","Haid", "l@gmail.com","02334","10","May","1990","Sign up for our newsletter!");

        // Fill address details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number in addressInformationPage.
        addressInformationPage.enterAddressInfo("Haidy","osama","Vois","Giza","Giza","India","Mompay","Mompay","02","0102043");

        // Verify that 'ACCOUNT CREATED!' is visible
        softAssert.assertTrue(accountCreatedPage.isMassageVisible());

        // Click 'Continue' button
        accountCreatedPage.clickContinueButton();

        //  Verify that 'Logged in as username' is visible in homePage
        softAssert.assertTrue(homePage.isLoggedAsUserNameVisible());

        // Click 'Delete Account' button
        homePage.clickDeleteAccount();

        // Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        softAssert.assertTrue(accountDeletedPage.isMassageVisible());
        accountDeletedPage.clickContinueButton();

        softAssert.assertAll();

    }

    @BeforeMethod
    public void methodSetUp()
    {
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
        signUpPage = new SignUpPage(driver);
        accountInformationPage = new AccountInformationPage(driver);
        addressInformationPage = new AddressInformationPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        accountDeletedPage = new AccountDeletedPage(driver);
    }


    @AfterMethod
    public void methodTearDown()
    {
        driver.quit();
    }
}
