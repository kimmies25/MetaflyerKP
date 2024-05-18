package locators;

import org.openqa.selenium.By;

public class SignupLocator {
    public static By individualMemberButton = By.xpath("//div[@class='metaflyer_select_individual_company_box']");
    public static By inputName = By.xpath("//input[@id='name']");
    public static By inputId = By.xpath("//input[@id='id']");
    public static By doubleCheckButton = By.xpath("//button[@class='button button-check-email']");
    public static By doubleCheckMessage = By.xpath("//div[@class='metaflyer_register_form_field_msg metaflyer_register_form_field_msg_success']");
    public static By inputPassword = By.xpath("//input[@id='password']");
    public static By inputPasswordVerify = By.xpath("//input[@id='password-verify']");
    public static By inputEmail = By.xpath("//input[@id='email']");
    public static By inputPhone = By.xpath("//input[@id='phone']");
    public static By checkbox14YersOld = By.xpath("//label[@for='term4']");
    public static By checkboxTOU = By.xpath("//label[@for='term1']");
    public static By checkboxPIC = By.xpath("//label[@for='term2']");
    public static By checkboxReceiveEvent = By.xpath("//label[@for='term3']");
    public static By registerPageTitle = By.xpath("//div[@class='metaflyer_register_title']");
    public static By registerCompleteButton = By.xpath("//button[contains(text(),'가입완료')]");
    public static By membershipCompleted = By.xpath("//h1[@class='metaflyer_register_completed_title']");
    public static By completedPageloginButton = By.xpath("//button[contains(text(),'로그인')]");


}
