package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "search")
    WebElement searchtxt;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement searchbutton;

    @FindBy(xpath = "//span[normalize-space()='Add to Cart']")
    WebElement addcart;

    @FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    WebElement viewcart;

    @FindBy(xpath = "//strong[normalize-space()='View Cart']")
    WebElement view;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement msgconfm;

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    WebElement shopingcart;

    @FindBy(xpath = "//a[normalize-space()='Continue Shopping']")
    WebElement con_button;

    public void search_txt(String text) {
        searchtxt.sendKeys(text);
    }

    public void search_button() {
        searchbutton.click();
    }

    public void addcart() {
        addcart.click();
    }

    public void viewcart() {
        viewcart.click();
    }

    public void view() {
        view.click();
    }

    public void shop_cart() {
        shopingcart.click();
    }

    public void click_continue() {
        con_button.click();
    }

    public String getConfirmationMsg() {
        try {
            return msgconfm.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
