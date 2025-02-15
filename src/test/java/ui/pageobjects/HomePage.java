package ui.pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[normalize-space()='Sign up']")
    private WebElement sign_up_link;

    @FindBy(xpath = "//button[@data-testid='login-button']")
    private  WebElement login_link;

    public void click_on_signUp_link()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        clickElement(sign_up_link);
    }

    public void click_on_login_link()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        clickElement(login_link);
    }

}
