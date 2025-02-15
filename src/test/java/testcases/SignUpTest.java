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
import ui.pageobjects.SignUpPage;
import java.io.IOException;


public class SignUpTest {

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver driver;
    HomePage homePage ;
    SignUpPage signUpPage;
    private final ExtentReports extent = TestRunner.getExtentReports();
    private ExtentTest test;
    String email , password , actual;
    @Given("the user navigate url {string}")
    public void the_user_navigate_url(String url) {
        test = extent.createTest("Spotify Signup - Navigate to URL", "Verify user can access the signup page");
        test.info("Initializing WebDriver and opening URL: " + url);

        if (driver == null) {
            driver = DriverFactory.initializeDriver();
        }
        homePage = new HomePage(driver);
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(),"https://open.spotify.com/");
        test.pass("✅ Successfully navigated to Spotify");
    }

    @When("the user clicks on the {string} link")
    public void the_user_clicks_on_the_link(String linkText) {
        test.info("Clicking on Sign Up link.");
        homePage.click_on_signUp_link();
        signUpPage = new SignUpPage(driver);
        actual = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/main/section/div/header/h1")).getText();
        Assert.assertEquals(actual,"Sign up to start listening");
        test.pass("✅ Navigated to Sign Up page.");
    }

    @And("the user enters {string}")
    public void the_user_enters_a_valid_email_address(String ema) {
        test.info("Entering Email Address.");
        email =  signUpPage.enterEmailAddress();
    }

    @And("the user clicks {string} button")
    public void the_user_clicks_next_button(String bx) throws InterruptedException {test.info("Clicking on Next button.");
       signUpPage.click_on_nextButton();
    }

    @And("the user creates {string}")
    public void the_user_creates_a_strong_password(String pass){
        test.info("Entering Password.");
        password = signUpPage.enterPassword();

    }

    @And("the user clicks on {string} button")
    public void the_user_clicks_on_next_button(String buttonText) throws InterruptedException, IOException {
        signUpPage.sendEmailAndPasswordData(email,password);
        test.info("Clicking on Next button.");
        signUpPage.click_on_nextButton1();
    }

    @Then("the user should be redirected to the {string}")
    public void the_user_should_be_redirected_to_the_tell_about_yourself_page(String page) {
        test.info("Verifying redirection to: " + page);
        actual = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/main/section/div/form/div[1]/div[1]/header/div[2]/div/span[2]")).getText();
        Assert.assertEquals(actual,"Tell us about yourself");
        test.pass("✅ User redirected successfully.");
    }

    @When("the user enter {string}")
    public void the_user_enter_name(String name) {
        test.info("Entering Name.");
        signUpPage.enterName();
    }

    @And("the user selects {string}")
    public void the_user_select_date_of_birth(String dob) {
        test.info("Selecting Date of Birth.");
        signUpPage.enterDateOfBirth();
    }

    @And("the user select {string}")
    public void the_user_select_gender(String gender) {
        test.info("Selecting Gender.");
        signUpPage.select_gender();

    }

    @And("the user click on {string} button")
    public void the_user_click_on_next_button(String button) throws InterruptedException {
        test.info("Clicking on Next button.");
        signUpPage.click_on_nextButton1();
    }

    @Then("the user should be redirected to {string}")
    public void the_user_should_be_redirected_to_the_terms_conditions_page(String page) {
        test.info("Verifying redirection to: " + page);
        actual = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/main/section/div/form/div[1]/div[1]/header/div[2]/div/span[2]")).getText();
        Assert.assertEquals(actual,"Terms & Conditions");
        test.pass("✅ User redirected successfully.");
    }

    @When("the user approve {string} by clicking on {string}")
    public void the_user_approve_terms_conditions_by_clicking_on_checkboxes(String checkbox1, String checkbox2) {
        test.info("Approving Terms and Conditions.");
        signUpPage.approve_TermsAndConditions();
    }

    @And("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String button) throws InterruptedException {
        test.info("Clicking on Sign Up button.");
        signUpPage.click_on_signUp_button();
    }

    @Then("the user should be {string} and redirected to {string}")
    public void the_user_should_be_registered_successfully_and_redirected_to_home_page(String status, String page) throws InterruptedException {
        test.info("Verifying registration and redirection to: " + page);
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='What do you want to play?']"));
        element.sendKeys("d");
        try {
            // Wait for elements to load
            Thread.sleep(5000); // Replace with WebDriverWait for better handling

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
        Assert.assertTrue(signUpPage.getMy_account().isDisplayed());
        signUpPage.click_on_account();
        signUpPage.click_on_logout();
        test.pass("✅ User registered successfully and redirected.");
    }

}
