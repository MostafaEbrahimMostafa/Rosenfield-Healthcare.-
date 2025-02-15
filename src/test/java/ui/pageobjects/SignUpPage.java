package ui.pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.github.javafaker.Faker;
import utils.ConfigurationUtils;
import java.io.IOException;


public class SignUpPage extends BasePage {


    Faker faker = new Faker();
    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#username")
    private WebElement emailAddress;

    @FindBy(css = "button[data-testid=\"submit\"]")
    private WebElement next_btn;

    @FindBy(xpath = "//*[@id=\"__next\"]/main/main/section/div/form/div[2]/button/span[1]")
    private WebElement next_btn1;


    @FindBy(css = "#new-password")
    private WebElement password;

    @FindBy(xpath = "//input[@id='displayName']")
    private WebElement name;

    @FindBy(css = "#day")
    private WebElement day;

    @FindBy(css = "#month")
    private WebElement select_month;

    @FindBy(css = "#year")
    private WebElement year;

    @FindBy(css = "label[for='gender_option_male'] span[class='Indicator-sc-hjfusp-0 jRuGOG']")
    private WebElement gender;

    @FindBy(xpath = "//label[@for='checkbox-marketing']//span[@class='Indicator-sc-1airx73-0 lhZnAn']")
    private WebElement checkBox1;

    @FindBy(xpath = "//label[@for='checkbox-privacy']//span[@class='Indicator-sc-1airx73-0 lhZnAn']")
    private WebElement checkBox2;

    @FindBy(css = "span[class='ButtonInner-sc-14ud5tc-0 hvvTXU encore-bright-accent-set']")
    private WebElement sign_up_btn;

    @FindBy(css = "button[aria-label='Mostafa']")
    private WebElement my_account;

    @FindBy(xpath = "//span[normalize-space()='Log out']")
    private WebElement logout;


    public WebElement getMy_account() {
        return my_account;
    }

    public String enterEmailAddress() {
        clearElement(emailAddress);
        String em = faker.internet().emailAddress();
        sendText(emailAddress, em);
        return  em ;
    }

    public String enterPassword() {
        String p = "Kady###78957895";
        clearElement(password);
        sendText(password, p);
        return  p;
    }

    public void enterName() {
        clearElement(name);
        sendText(name, "Mostafa");
    }

    public void enterDateOfBirth() {
        clearElement(day);
        clearElement(year);
        sendText(day, "05");
        selectOption(select_month,"January");
        sendText(year, "2000");
    }

    public void click_on_nextButton() throws InterruptedException {
        Thread.sleep(1000);
        clickElement(next_btn);
    }

    public void click_on_nextButton1() throws InterruptedException {
        Thread.sleep(1000);
        clickElement(next_btn1);
    }

    public void click_on_account() throws InterruptedException {
        Thread.sleep(1000);
        clickElement(my_account);
    }

    public void click_on_logout()
    {
        clickElement(logout);
    }

    public void select_gender()
    {
        clickElement(gender);
    }

    public void approve_TermsAndConditions()
    {
        clickElement(checkBox1);
        clickElement(checkBox2);
    }

    public void click_on_signUp_button() throws InterruptedException {
        clickElement(sign_up_btn);
        Thread.sleep(20000);
    }

    public void sendEmailAndPasswordData(String Email,String Password) throws IOException {
            ConfigurationUtils.getInstance().set_email(Email);
            ConfigurationUtils.getInstance().set_password(Password);
            ConfigurationUtils.getInstance().store();
    }
}