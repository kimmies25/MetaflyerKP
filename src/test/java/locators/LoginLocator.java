package locators;

import org.openqa.selenium.By;

public class LoginLocator {
    public static By loginInputId = By.xpath("//input[@name='id']");
    public static By loginInputPassword = By.xpath("//input[@name='password']");
    public static By loginLoginButton = By.xpath("//button[@type='submit']");
    public static By loginFailedModal = By.xpath("//div[@class='modal_body']");
    public static By loginFailedMessage = By.xpath("//div[@class='modal_body']/p");
    public static By homepageLoginId = By.xpath("//div[@id ='BO-BackOfficeManagerAccount']/div/span");

}
