package ui.pageobjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddPlaylistPage extends BasePage {

    public AddPlaylistPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//*[@id=\"Desktop_LeftSidebar_Id\"]/nav/div/div[1]/div[2]/div[2]/div/section[1]/div[2]/button")
    private WebElement create_playlist;

    public WebElement getMy_playlist() {
        return my_playlist;
    }

    @FindBy(xpath = "//*[@id=\"Desktop_LeftSidebar_Id\"]/nav/div/div[1]/div[2]/div[2]/div/div[2]/ul/div/div[2]/li/div/div[1]")
    private WebElement my_playlist;

    @FindBy(xpath = "//*[@id=\"context-menu\"]/ul/li[2]/button")
    private WebElement edit_detail;

    @FindBy(xpath = "//input[@data-testid='playlist-edit-details-name-input']")
    private WebElement playlist_name;

    @FindBy(xpath = "//span[@class='ButtonInner-sc-14ud5tc-0 jGzjVo encore-inverted-light-set e-9541-button-primary--medium e-9541-button-primary__inner']")
    private WebElement save_btn;




    public void click_on_create_playlist() {

        clickElement(create_playlist);
    }

    public void rightClick_on_myPlaylist() throws InterruptedException {
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.contextClick(my_playlist).perform();
    }

    public void click_on_editDetail() throws InterruptedException {
        Thread.sleep(1000);
        clickElement(edit_detail);
    }

    public void enter_playlist_name(String name)
    {
        clearElement(playlist_name);
        sendText(playlist_name,name);
    }

    public void click_on_saveButton()
    {
        clickElement(save_btn);
    }

}
