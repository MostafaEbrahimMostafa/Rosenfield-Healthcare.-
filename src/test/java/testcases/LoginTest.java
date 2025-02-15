package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import testRunner.TestRunner;
import ui.pageobjects.HomePage;
import ui.pageobjects.LoginPage;

import java.time.Duration;


public class LoginTest {

    public static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }
    HomePage homePage;
    LoginPage loginPage;
    ExtentReports extent = TestRunner.getExtentReports();
    ExtentTest test;
    String  actual ;

    @Given("the user navigate Spotify {string} page")
    public void the_user_is_on_the_spotify_login_page(String l) {
        test = extent.createTest("Spotify Login - Navigate to URL", "Verify user can access the login page");
        test.info("Initializing WebDriver and opening URL: " + l);
        if (driver == null)
        {
            driver = SignUpTest.getDriver();
        }
        homePage = new HomePage(driver);
        homePage.click_on_login_link();
        loginPage = new LoginPage(driver);

        actual = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/h1")).getText();
        Assert.assertEquals(actual,"Log in to Spotify");
        test.pass("✅ Successfully navigated to Spotify login page.");
    }

    @When("the user enters valid {string} and {string}")
    public void the_user_enters_valid_email_and_password(String em , String pass) {
        test.info("Entering login credentials.");
        loginPage.enterLoginData();
    }

    @And("clicks on the {string} button")
    public void clicks_on_the_login_button(String log) {
        test.info("Clicking on Login button.");
        loginPage.click_on_login();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element = driver.findElement(By.cssSelector("input[type='search']"));
        element.sendKeys("d");
        try {
            // Wait for elements to load
            Thread.sleep(2000); // Replace with WebDriverWait for better handling

            // Locate the "Your Library" expand/collapse button by its aria-label
            WebElement libraryButton = driver.findElement(By.xpath("//button[contains(@aria-label, 'Your Library')]"));

            // Get the aria-label text
            String ariaLabel = libraryButton.getAttribute("aria-label");

            // Check if the library is collapsed and needs to be expanded
            if (ariaLabel.contains("Collapse Your Library")) {
                System.out.println("Library is already expanded.");
            } else {
                libraryButton.click();
                System.out.println("Library expanded.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("the user should be redirected to the Spotify {string}")
    public void the_user_should_be_redirected_to_the_spotify_homepage(String h) {
        test.info("Verifying redirection to: " + h);
        Assert.assertTrue(loginPage.getMy_account().isDisplayed());
        test.pass("✅ User is logged successfully.");
    }

}
