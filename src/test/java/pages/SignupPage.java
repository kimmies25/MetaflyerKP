package pages;

import common.WebUI;
import locators.SignupLocator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupPage extends WebUI {
    WebDriver driver;

    public SignupPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickIndividualMemberButton() {
        clickElement(SignupLocator.individualMemberButton);
    }

    public void setName(String name) {
           setText(SignupLocator.inputName, name);
    }

    public void setId(String id) {
       setText(SignupLocator.inputId, id);
    }

    public void clickDoubleCheckButton() {
        clickElement(SignupLocator.doubleCheckButton);
    }

    public void setPassword(String password) {
        setText(SignupLocator.inputPassword, password);
    }

    public void setPasswordVerify(String password) {
        setText(SignupLocator.inputPasswordVerify, password);
    }

    public void setPhone(String phone) {
        setText(SignupLocator.inputPhone, phone);
    }

    public void setEmail(String email) {
        setText(SignupLocator.inputEmail, email);
    }

    public void setCheckbox14YersOld() {
        clickElement(SignupLocator.checkbox14YersOld);
    }

    public void setCheckboxTOU() {

        clickElement(SignupLocator.checkboxTOU);
    }

    public void setCheckboxPIC() {

        clickElement(SignupLocator.checkboxPIC);
    }

    public void setCheckboxReceiveEvent() {

        clickElement(SignupLocator.checkboxReceiveEvent);
    }

    public void clickRegisterCompleteButton() {

        clickElement(SignupLocator.registerCompleteButton);
    }

    public void verifyDoubleCheckMessage() {
        Assert.assertTrue(getElementText(SignupLocator.doubleCheckMessage).equals("이 아이디를 사용할 수 있습니다."), "Double check message is not correct");
    }

    public void verifyRegisterPageTitle() {
        Assert.assertTrue(getElementText(SignupLocator.registerPageTitle).equals("개인 회원 가입"), "Page title is not correct");
    }

    public void verifyMembershipCompleted() {

        Assert.assertTrue(getElementText(SignupLocator.membershipCompleted).equals("회원가입 완료"), "FAIL. Still at signup page");
    }

}
