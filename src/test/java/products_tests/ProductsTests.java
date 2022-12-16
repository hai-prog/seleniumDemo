package products_tests;
/*
 Testcases related to the products:

 Test Case 9: Search Product
 Test Case 12: Add Products in Cart

 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class ProductsTests {
    WebDriver driver;
    SoftAssert softAssert;
    HomePage homePage;
    ProductsPage productsPage ;
    CartPage cartPage ;



    @Test(testName = "Test Case 9: Search Product" , description = " when i enter product name in search input and click search button , i should get PRODUCTS related to my search")
    public void testSearchProduct()
    {
        String searchedProduct = "shirt";

        // Verify that home page is visible successfully
        softAssert.assertTrue(homePage.isPageTitleVisible());

        // click on products
        homePage.clickOnProducts();

        // Verify user is navigated to ALL PRODUCTS page successfully
        softAssert.assertTrue(productsPage.isProductsPageTitleVisible());

        // Enter product name in search input and click search button
        productsPage.searchProduct(searchedProduct);


        // Verify 'SEARCHED PRODUCTS' is visible
        softAssert.assertTrue(productsPage.isSearchedProductsAreVisible());

        //  Verify all the products related to search are visible
        softAssert.assertTrue(productsPage.isSearchedProductsRelatedToSearch(searchedProduct));


        softAssert.assertAll();

    }

    @Test(testName = "Test Case 12: Add Products in Cart", description = "verify that the products are added to the cart successfully")

    public void testAddToCart() {
        // Verify that home page is visible successfully
        softAssert.assertTrue(homePage.isPageTitleVisible());

        // click on products
        homePage.clickOnProducts();


        // get products data to verify it
        String firstProductName = productsPage.getFirstProductName();
        String secondProductName = productsPage.getSecondProductName();

        String firstProductPrice = productsPage.getFirstProductPrice();
        String secondProductPrice = productsPage.getSecondProductPrice();

        // Hover over first product and click 'Add to cart'
        productsPage.addFirstProductToCart();

        // Click 'Continue Shopping' button
        productsPage.clickContinueShopping();

        // Hover over second product and click 'Add to cart'
        productsPage.addSecondProductToCart();

        // Click 'View Cart' button
        productsPage.clickViewCart();

        // Verify both products are added to Cart
        softAssert.assertEquals(firstProductName, cartPage.getFirstProductName());
        softAssert.assertEquals(secondProductName, cartPage.getSecondProductName());

        // Verify their prices, quantity
        softAssert.assertEquals(firstProductPrice, cartPage.getFirstProductPrice());
        softAssert.assertEquals(secondProductPrice, cartPage.getSecondProductPrice());

        softAssert.assertEquals(cartPage.getFirstProductQuantity(), "1");
        softAssert.assertEquals(cartPage.getSecondProductQuantity(), "1");

        softAssert.assertAll();

    }

    @BeforeMethod
    public void methodSetUp()
    {
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        softAssert = new SoftAssert();
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }


    @AfterMethod
    public void methodTearDown()
    {
        driver.quit();
    }


    }

