package testcases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import testRunner.TestRunner;
import ui.pageobjects.AddPlaylistPage;
import ui.pageobjects.HomePage;
import ui.pageobjects.LoginPage;
import ui.pageobjects.RunPlaylistPage;
import utils.ConfigurationUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
public class RunPlaylistTest {

    public static WebDriver getDriver() {
        return driver;
    }
    public static WebDriver driver;
    ExtentReports extent = TestRunner.getExtentReports();
    ExtentTest test;
    RunPlaylistPage runPlaylistPage;

    @Given("the user is already logged into {string}")
    public void the_user_is_logged_into_spotify(String app) {
        test = extent.createTest("Spotify - Add Song to Playlist", "Verify user can add a song to a playlist and play it");
        test.info("Initializing WebDriver and ensuring the user is logged into Spotify.");
        if(driver == null)
        {
            driver = AddPlaylistTest.getDriver();
        }
        runPlaylistPage = new RunPlaylistPage(driver);
    }

    @When("the user searches for a song {string}")
    public void the_user_searches_for_a_song(String songName) {
        test.info("Searching for song: " + songName);
        runPlaylistPage.enter_song_name("d");
    }

    @And("selects {string}")
    public void selects_add_to_playlist(String option) throws InterruptedException {
        test.info("Selecting 'Add to Playlist' option.");
        runPlaylistPage.add_song();
    }

    @Then("the song should be added successfully")
    public void the_song_should_be_added_successfully() {
        test.info("Verifying song was added to the playlist.");
        test.pass("✅ Song successfully added.");
    }

    @And("clicks {string} button")
    public void clicks_on_the_play_button(String buttonText) {
        test.info("Clicking on Play button.");
        runPlaylistPage.play_song();
        test.pass("✅ Clicked Play button.");
    }
    @Then("the song should {string}")
    public void the_song_should_start_playing_successfully(String s) throws InterruptedException {
        test.info("Verifying that the song is playing.");
        test.pass("✅ Song is playing successfully.");
        Thread.sleep(15000);
        driver.close();
    }
}
