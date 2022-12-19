package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementActions;

import java.time.Duration;
import java.util.List;

public class ProductsPage {
    WebDriver driver;

                 //** Locators **//

    By allProductsTitle = By.xpath("//h2[@class=\"title text-center\"]");

    By searchBar = By.xpath("//input[@id=\"search_product\"]");
    By searchButton = By.xpath("//button[@id=\"submit_search\"]");
    By searchResultProducts = By.xpath("//div[@class=\"features_items\"]");
    By searchResultProductsNames = By.xpath("//div[@class=\"productinfo text-center\"]/p");


             //** first product locators **//
    By firstProduct = By.xpath("(//div[@class=\"product-image-wrapper\"])[1]");
    By firstProductName = By.xpath("(//div[@class=\"productinfo text-center\"])[1]/p");
    By firstProductPrice = By.xpath("(//div[@class=\"productinfo text-center\"]/h2)[1]");
    By addToCartButton1 = By.xpath("(//a[@data-product-id=\"1\"])[2]");


            //** first product locators **//
    By secondProductName = By.xpath("(//div[@class=\"productinfo text-center\"])[2]/p");
    By secondProduct = By.xpath("(//div[@class=\"product-image-wrapper\"])[2]");
    By secondProductPrice = By.xpath("(//div[@class=\"productinfo text-center\"]/h2)[2]");
    By addToCartButton2 = By.xpath("(//a[@data-product-id=\"2\"])[2]");

    
        //** locators related to the model dialog **//
    By modelContainer = By.className("modal-content");
    By continueShoppingButton = By.xpath("//button[@data-dismiss=\"modal\"]");
    By viewCartButton = By.xpath("//p[@class=\"text-center\"]/a");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }


              //** Actions **//

    public boolean isProductsPageTitleVisible()
    {
        return driver.findElement(allProductsTitle).isDisplayed();
    }

    public void searchProduct(String ProductName)
    {
        ElementActions.setText(driver,searchBar, ProductName,true);
        ElementActions.click(driver,searchButton);
    }

    public boolean isSearchedProductsAreVisible(){
        return driver.findElement(searchResultProducts).isDisplayed();
    }


    /*
   * Get list of all products names to check if result related to the search by checking if their description
    contain the product name.
   * if one product description dont contain the product name the method will send false.
     */
    public boolean isSearchedProductsRelatedToSearch(String SearchedProductName)
    {   boolean isMatched = true;
        List<WebElement> resultProducts = driver.findElements(searchResultProductsNames);
        for (WebElement product: resultProducts
             ) {
            if( !(product.getText().contains(SearchedProductName)))
                isMatched = false;
                break;
        }
        return isMatched;
    }


    public void addFirstProductToCart()
    {
        // first hover over the product

        ElementActions.mouseHover(driver,firstProduct);

        // click add to cart

        ElementActions.click(driver, addToCartButton1);
    }


        //** first product actions **//

    public String getFirstProductName()
    {
        return   ElementActions.getText(driver,firstProductName);
    }

    public String getFirstProductPrice()
    {
        return   ElementActions.getText(driver,firstProductPrice);
    }

    public void addSecondProductToCart()
    {
        // second hover over the product

        ElementActions.mouseHover(driver,secondProduct);

        // click add to cart

        ElementActions.click(driver, addToCartButton2);

    }

              //** second product actions **//

    public String getSecondProductName()
    {
        return   ElementActions.getText(driver,secondProductName);
    }

    public String getSecondProductPrice()
    {
        return   ElementActions.getText(driver,secondProductPrice);
    }

        //** Model dialog actions **//

    // Continue button locate in model dialog
    public void clickContinueShopping()
    {
        locateModelDialog().findElement(continueShoppingButton).click();
    }

    // View button locate in model dialog
    public void clickViewCart()
    {
        locateModelDialog().findElement(viewCartButton).click();
    }

    private WebElement locateModelDialog()
    {
        // wait to let the modal box be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modelContainer));

        // to fetch the web element of the modal container
        return driver.findElement(modelContainer);

    }





}
