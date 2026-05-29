package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmailAddress;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement msgHeading;

    // Forgot Password Elements
    @FindBy(xpath = "//a[text()='Forgotten Password']")
    WebElement fpwd;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement con_tinue;

    public void setEmail(String email) {
        txtEmailAddress.sendKeys(email);
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public boolean isMyAccountPageExists() {
        try {
            return msgHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Forgot Password Methods
    public void clickForgotPassword() {
        fpwd.click();
    }

    public void clickContinueReset() {
        con_tinue.click();
    }
}
