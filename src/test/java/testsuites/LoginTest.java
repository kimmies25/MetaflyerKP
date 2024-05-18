package testsuites;

import constants.ConfigData;
import pages.HomePage;
import pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    private String loginId = "anle001";
    private String loginPassword = "anle001!";
    private String invalidLoginId = "anle";
    private String loginFailedMessage = "사용자 정보를 찾을 수 없습니다.";

    @Test
    public void testLoginSuccess() {
        driver.get(ConfigData.LOGIN_URL);
        loginPage = new LoginPage(driver);
        loginPage.loginMetaflyer(loginId, loginPassword);
        homePage = new HomePage(driver);
        homePage.verifyLoginSuccess(loginId);
    }

    @Test
    public void testLoginFailedWithInvalidId() {
        driver.get(ConfigData.LOGIN_URL);
        loginPage = new LoginPage(driver);
        loginPage.loginMetaflyer(invalidLoginId, loginPassword);
        loginPage.verifyLoginFail(loginFailedMessage);
    }
}
