package pages;

import locators.LoginLocator;
import org.openqa.selenium.WebDriver;

import common.WebUI;


public class LoginPage extends WebUI {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setLoginId(String loginId) {
        setText(LoginLocator.loginInputId, loginId);
    }

    public void setLoginPassword(String loginPassword) {
        setText(LoginLocator.loginInputPassword, loginPassword);
    }

    private void clickLoginButton() {
        clickElement(LoginLocator.loginLoginButton);
    }

    public void loginMetaflyer(String loginId, String loginPassword) {
        setLoginId(loginId);
        setLoginPassword(loginPassword);
        clickLoginButton();
    }

    public void verifyLoginFail(String expectedMessage) {
        String actualMessage = getElementText(LoginLocator.loginFailedMessage);
        assertEquals(actualMessage, expectedMessage);
    }

}
