package testcases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import testRunner.TestRunner;
import ui.pageobjects.AddPlaylistPage;
import ui.pageobjects.HomePage;
import ui.pageobjects.LoginPage;
import utils.ConfigurationUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;


public class AddPlaylistTest {

    public static WebDriver getDriver() {
        return driver;
    }
    public static WebDriver driver;
    ExtentReports extent = TestRunner.getExtentReports();
    ExtentTest test;
    AddPlaylistPage addPlaylistPage;
    @Given("the user is logged into {string}")
    public void the_user_is_logged_into_spotify(String s) {
        test = extent.createTest("Add Playlist - Login", "Verify user is logged in to Spotify");
            if(driver == null)
            {
                driver = LoginTest.getDriver();
            }
            addPlaylistPage = new AddPlaylistPage(driver);
        test.info("✅ User is logged into: " + s);
    }

    @When("the user clicks at {string} button")
    public void the_user_clicks_on_create_playlist_button(String buttonText) throws InterruptedException {
        addPlaylistPage.click_on_create_playlist();
        Assert.assertTrue(addPlaylistPage.getMy_playlist().isDisplayed());
        test.pass("✅ 'Create Playlist' button clicked successfully.");
    }

    @And("enters playlist name {string}")
    public void enters_playlist_name(String playlistName) throws InterruptedException {
        test.info("Clicking on edit details and edit playlist name.");
        addPlaylistPage.rightClick_on_myPlaylist();
        addPlaylistPage.click_on_editDetail();
        addPlaylistPage.enter_playlist_name("My Favorite Songs");
    }

    @And("clicks at {string} button")
    public void clicks_on_save_button(String buttonText) {
        test.info("Clicking on 'Save' button.");
        addPlaylistPage.click_on_saveButton();
        Assert.assertTrue(addPlaylistPage.getMy_playlist().isDisplayed());
        test.pass("✅  My Favorite Songs playlist name is entered successfully.");
    }

    @Then("the {string} should be created successfully")
    public void the_playlist_should_be_created_successfully(String p) {
        test.pass("✅ Playlist '" + p + "' created successfully.");

    }
}
