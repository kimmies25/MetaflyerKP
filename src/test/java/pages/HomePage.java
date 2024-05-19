package pages;

import common.WebUI;
import locators.HomepageLocator;
import org.openqa.selenium.WebDriver;


public class HomePage extends WebUI {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyLoginSuccess(String expectedAccountId){
        String actualAccountId = getElementText(HomepageLocator.homepageLoginId);
        assertEquals(actualAccountId, expectedAccountId);}

}
