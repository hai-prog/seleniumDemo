package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class ElementActions {
   WebDriver driver;
   static WebDriverWait wait;


    public ElementActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }


  // to choose select from dropDown based on text or value
    public enum SelectType {
        TEXT, VALUE;
    }


    public static void click(WebDriver driver, By elementLocator) {

        locateTheElement(driver, elementLocator);

        try {
            // wait for the element to be clickable
           wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        } catch (TimeoutException toe) {
           toe.printStackTrace();

        } catch (Exception e) {
           e.printStackTrace();

        }

        /*
        Mouse hover on the element before clicking to enable styling and handle some
        element clicking issues that happens without hovering
         */
        new Actions(driver).moveToElement(driver.findElement(elementLocator)).perform();

        // Now we click on the element! :
        driver.findElement(elementLocator).click();
    }

    public static void setText(WebDriver driver, By elementLocator, String text, boolean clearBeforeTyping) {

        locateTheElement(driver, elementLocator);

        try {
            // Clear before typing condition
            if (!driver.findElement(elementLocator).getAttribute("value").isBlank() && clearBeforeTyping) {
                driver.findElement(elementLocator).clear();
                // We type here! :D
                driver.findElement(elementLocator).sendKeys(text);

            }else {
                driver.findElement(elementLocator).sendKeys(text);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }}

    public static void select(WebDriver driver, By elementLocator,String option, SelectType selectType) {
        locateTheElement(driver, elementLocator);

        try {

            Select select = new Select(driver.findElement(elementLocator));

            //select.selectByVisibleText(option);
            switch (selectType) {
                case TEXT -> select.selectByVisibleText(option);
                case VALUE -> select.selectByValue(option);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }}

    public static void mouseHover(WebDriver driver, By elementLocator) {

        locateTheElement(driver, elementLocator);
        try {
            new Actions(driver).moveToElement(driver.findElement(elementLocator)).perform();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static String getText(WebDriver driver, By elementLocator) {
        locateTheElement(driver, elementLocator);
        try {
            return driver.findElement(elementLocator).getText();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static void locateTheElement(WebDriver driver, By elementLocator)
    {
        try {
            // Wait for the element to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

            driver.findElement(elementLocator);

        } catch (TimeoutException toe) {
            toe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
