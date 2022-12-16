package login_tests;
/*
  The Login testcases
   Test Case 2: Login User with correct email and password
   Test Case 3: Login User with incorrect email and password
   Test Case 4: Logout User
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountDeletedPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests {
    WebDriver driver;
    SoftAssert softAssert;
    HomePage homePage;
    LoginPage loginPage;
    AccountDeletedPage accountDeletedPage;



    @Test( testName = "Test Case 2: Login User with correct email and password"
            , description = "login with an already register user, I should Sign in successfully" )

    public void testSuccessfulLogin()
    {
        // Verify that home page is visible successfully
        softAssert.assertTrue(homePage.isPageTitleVisible());

        // Click on 'Signup / Login' button
        homePage.clickOnSingUpAndLogin();

        // Enter correct email address and password
        loginPage.login("h0@gmail.com","01233");

        //  Verify that 'Logged in as username' is visible in homePage
        softAssert.assertTrue(homePage.isLoggedAsUserNameVisible());

        softAssert.assertAll();

    }

    @Test(    testName = "Test Case 3: Login User with incorrect email and password"
            , description = "When I enter incorrect email or password, Then I should get an error message")

    public void testLoginWithInvalidData()
    {
        // Verify that home page is visible successfully
        softAssert.assertTrue(homePage.isPageTitleVisible());

        // Click on 'Signup / Login' button
        homePage.clickOnSingUpAndLogin();

        // Enter incorrect email address or password
        loginPage.login("h9@gmail.com","0123");

        // Verify error 'Your email or password is incorrect!' is visible
        softAssert.assertEquals(loginPage.getErrorMassage() , "Your email or password is incorrect!");

        softAssert.assertAll();

    }

    @Test(    testName = "Test Case 4: Logout User"
            , description = "when i log out , i should be navigated to login page")

    public void testLogOutFunctionality()
    {
        // Verify that home page is visible successfully
        softAssert.assertTrue(homePage.isPageTitleVisible());

        // Click on 'Signup / Login' button
        homePage.clickOnSingUpAndLogin();

        // Enter correct email address and password
        loginPage.login("h0@gmail.com","01233");

        //  Verify that 'Logged in as username' is visible in homePage
        softAssert.assertTrue(homePage.isLoggedAsUserNameVisible());

        // Click 'Logout' button
        homePage.clickOnLogOut();

        // Verify that user is navigated to login page
        softAssert.assertEquals(loginPage.getTitle(),"Login to your account");

    }

    @BeforeMethod
    public void methodSetUp()
    {
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        softAssert = new SoftAssert();
        accountDeletedPage = new AccountDeletedPage(driver);
    }

      @AfterMethod
      public void methodTearDown()
      {
          driver.quit();
      }


}
