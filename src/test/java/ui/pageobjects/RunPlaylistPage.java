package ui.pageobjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RunPlaylistPage extends BasePage {

    public RunPlaylistPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='g9xHCCSXDR8S5NvTbfwL']/div/input")
    private WebElement search_box ;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[4]/div/div/div[2]/div[2]/div/main/section/div[2]/div[3]/div/div/div[1]/div/div[2]/div[1]/div/div[4]/button")
    private WebElement add_song;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[4]/div/header/div[2]/div/div/div/button")
    private WebElement play_song;

    public void enter_song_name(String song)
    {
        sendText(search_box,song);
    }

    public void add_song() throws InterruptedException {
        Thread.sleep(3000);
        clickElement(add_song);
    }
    public void play_song()
    {
        WebElement playButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[4]/div/header/div[2]/div/div/div/button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", playButton);

    }
}
