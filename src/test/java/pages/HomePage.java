package pages;

import common.BaseTest;
import common.WebUI;
import locators.HomepageLocator;
import locators.LoginLocator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends WebUI {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyLoginSuccess(String expectedAccountId){
        String actualAccountId = getElementText(HomepageLocator.homepageLoginId);
        assertEquals(actualAccountId, expectedAccountId);}

}
