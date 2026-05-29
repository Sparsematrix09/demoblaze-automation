package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "search")
    WebElement searchtxt;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement searchbutton;

    @FindBy(xpath = "//img[@title='iMac']")
    WebElement img;

    @FindBy(xpath = "//a[contains(normalize-space(),'iMac')]")
    WebElement product;

    @FindBy(xpath = "//a[normalize-space()='Write a review']")
    WebElement review;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement conti;

    // Wishlist Elements merged here
    @FindBy(xpath = "//button[@type='button']//i[@class='fa fa-heart']")
    WebElement wlistButton;

    @FindBy(xpath = "//span[normalize-space()='Wish List (1)']")
    WebElement wlistIcon;

    @FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
    WebElement notFoundMsg;

    public void search_txt(String text) {
        searchtxt.sendKeys(text);
    }

    public void search_button() {
        searchbutton.click();
    }

    public void pro_img() {
        img.click();
    }

    public void pro_duct() {
        product.click();
    }

    public void produreview() {
        review.click();
    }

    public boolean isPageExists() {
        try {
            return conti.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Wishlist Methods
    public void clickAddToWishlist() {
        wlistButton.click();
    }

    public void clickWishlistHeaderLink() {
        wlistIcon.click();
    }

    public boolean isNotFoundMsgDisplayed() {
        try {
            return notFoundMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
