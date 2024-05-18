package testsuites;
import common.BaseTest;
import constants.ConfigData;
import helper.Util;
import pages.SignupPage;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {
    SignupPage signupPage;
    Util util = new Util();

    String idFollowedUserName = util.generateUsername();
    @Test
    public void testLoginSuccessWithAllFields() {

        SignupPage signupPage = new SignupPage(driver);
        driver.get(ConfigData.SIGNUP_URL);

        signupPage.clickIndividualMemberButton();

        signupPage.verifyRegisterPageTitle();
        signupPage.setName(idFollowedUserName);
        signupPage.setId(idFollowedUserName);
        signupPage.clickDoubleCheckButton();
        signupPage.verifyDoubleCheckMessage();
        signupPage.setPassword("meta001!");
        signupPage.setPasswordVerify("meta001!");
        signupPage.setEmail(idFollowedUserName + "@gmail.com");
//        signupPage.setPhone(generatePhoneNumber);

        signupPage.setCheckbox14YersOld();
        signupPage.setCheckboxTOU();
        signupPage.setCheckboxPIC();
        signupPage.setCheckboxReceiveEvent();
        signupPage.clickRegisterCompleteButton();
        signupPage.verifyMembershipCompleted();
    }
}
