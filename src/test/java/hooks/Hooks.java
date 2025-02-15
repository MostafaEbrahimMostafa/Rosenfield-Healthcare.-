package hooks;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import testRunner.TestRunner;

public class Hooks {
    public static WebDriver driver;
    private ExtentTest test; // Declare a test instance for Extent Reports


    @Before
    public void setup(Scenario scenario) {
        // Create a single test instance for the scenario
        test = TestRunner.extent.createTest(scenario.getName());
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            test.fail("❌ Scenario failed: " + scenario.getName());
        } else {
            test.pass("✅ Scenario passed: " + scenario.getName());
        }
        if (driver != null) {
            driver.quit(); // Ensure only one WebDriver instance is closed
        }
    }
}
