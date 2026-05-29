package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    WebElement lnkLogout;

    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement msgHeading;

    @FindBy(xpath = "//a[text()='Order History']")
    WebElement orderhistory;

    @FindBy(xpath = "//a[text()='Site Map']")
    WebElement sitemap;

    public void clickLogout() {
        lnkLogout.click();
    }

    public boolean isMyAccountPageExists() {
        try {
            return msgHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOrderHistory() {
        orderhistory.click();
    }

    public void clickSiteMap() {
        sitemap.click();
    }
}
