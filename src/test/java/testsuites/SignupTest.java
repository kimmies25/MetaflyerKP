package testsuites;

import common.BaseTest;
import common.WebUI;
import constants.ConfigData;
import helper.Util;
import locators.SignupLocator;
import pages.SignupPage;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {
    SignupPage signupPage;
    Util util = new Util();
    String idFollowedUserName = util.generateUsername();
    String password = "meta001!";
    String emailSuffix = "@gmail.com";
    String generatePhoneNumber = util.generatePhoneNumber();

    @Test
    public void testLoginSuccessWithAllCheckboxes() {
        SignupPage signupPage = new SignupPage(driver);
        driver.get(ConfigData.SIGNUP_URL);
        signupPage.clickIndividualMemberButton();
        signupPage.verifyRegisterPageTitle();

        signupPage.setName(idFollowedUserName);
        signupPage.setId(idFollowedUserName);
        signupPage.clickDoubleCheckButton();
        signupPage.verifyDoubleCheckMessage();

        WebUI.scrollToElement(SignupLocator.passwordLabel);
        signupPage.setPassword(password);
        signupPage.setPasswordVerify(password);
        signupPage.setEmail(idFollowedUserName + emailSuffix);
        signupPage.setPhone(generatePhoneNumber);

        signupPage.setCheckbox14YersOld();
        signupPage.setCheckboxTOU();
        signupPage.setCheckboxPIC();
        signupPage.setCheckboxReceiveEvent();

        signupPage.clickRegisterCompleteButton();
        signupPage.verifyMembershipCompleted();
    }

    @Test
    public void testLoginSuccessWithOnlyRequiredCheckboxes() {
        SignupPage signupPage = new SignupPage(driver);
        driver.get(ConfigData.SIGNUP_URL);
        signupPage.clickIndividualMemberButton();
        signupPage.verifyRegisterPageTitle();

        signupPage.setName(idFollowedUserName);
        signupPage.setId(idFollowedUserName);
        signupPage.clickDoubleCheckButton();
        signupPage.verifyDoubleCheckMessage();

        WebUI.scrollToElement(SignupLocator.passwordLabel);
        signupPage.setPassword(password);
        signupPage.setPasswordVerify(password);
        signupPage.setEmail(idFollowedUserName + emailSuffix);
        signupPage.setPhone(generatePhoneNumber);

        signupPage.setCheckbox14YersOld();
        signupPage.setCheckboxTOU();
        signupPage.setCheckboxPIC();

        signupPage.clickRegisterCompleteButton();
        signupPage.verifyMembershipCompleted();
    }
}
