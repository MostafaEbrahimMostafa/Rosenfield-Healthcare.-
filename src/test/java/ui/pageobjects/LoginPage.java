package ui.pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigurationUtils;



public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#login-username")
    private WebElement email;

    @FindBy(css = "#login-password")
    private WebElement password;

    @FindBy(css = "#login-button")
    private WebElement login_btn;

    @FindBy(xpath = "//*[@id=\"global-nav-bar\"]/div[3]/button")
    private WebElement my_account;

    public void enterLoginData()
    {
       String em = ConfigurationUtils.getInstance().get_email();
       String pass = ConfigurationUtils.getInstance().get_password();
        sendText(email,em);
        sendText(password,pass);
    }
    public void click_on_login()
    {
        clickElement(login_btn);
    }

    public WebElement getMy_account() {
        return my_account;
    }



}
