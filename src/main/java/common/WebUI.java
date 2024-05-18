package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class WebUI {

    private static int TIMEOUT = 30;

    private static int PAGE_LOAD_TIMEOUT = 40;

    private static WebDriver driver;

    public WebUI(WebDriver driver) {
        this.driver = driver;
    }

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logConsole(Object message) {
        System.out.println(message);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebElement getWebElement(By by) {
        return getDriver().findElement(by);
    }

    public static List<WebElement> getWebElements(By by) {
        return getDriver().findElements(by);
    }

    public static boolean checkElementExist(By by) {
        List<WebElement> listElement = getWebElements(by);

        if (listElement.size() > 0) {
            System.out.println("Element " + by + " existing.");
            return true;
        } else {
            System.out.println("Element " + by + " NOT exist.");
            return false;
        }
    }

    public static void clickElement(By by) {
        waitForElementClickable(by);
        getWebElement(by).click();
        logConsole("Click on element " + by);
    }

    public static void setText(By by, String text) {
        waitForElementVisible(by);
        getWebElement(by).sendKeys(text);
        logConsole("Set text " + text + " on input " + by);
    }

    public static String getElementText(By by) {
        waitForElementVisible(by);
        String text = driver.findElement(by).getText();
        logConsole("Get text of element " + by + " is: " + text);
        return text;
    }

    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }

    //Wait for Element

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
            logConsole("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public static void waitForElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
            logConsole("Timeout waiting for the element ready to click. " + by.toString());
        }
    }

    public static void assertEquals(Object actual, Object expected) {
        waitForPageLoaded();
        System.out.println("Assert equals: " + actual + " and " + expected);
        Assert.assertEquals(actual, expected, "Actual value: " + actual + "does not equal expected value: " + expected);
    }

    public static void scrollToElement(By element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(element));
    }

    public static boolean checkElementDisplayed(By by) {
        waitForElementVisible(by);
        boolean check = getWebElement(by).isDisplayed();
        return check;
    }

}
