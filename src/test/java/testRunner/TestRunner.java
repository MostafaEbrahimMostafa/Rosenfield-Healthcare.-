package testRunner;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.ConfigurationUtils;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"Features/F1_SignUp.feature", "Features/F2_Login.feature",
        "Features/F3_PlaylistCreation.feature",
        "Features/F4_PlaylistRunning.feature"},// Path to feature files
        glue={"testcases","hooks"},
        plugin= {
                "pretty", "html:reports/TestReport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt",
        },
        monochrome = true,
        dryRun=false,    // checks mapping between scenario steps and step definition methods
        publish=true   // to publish report in cucumber server
        )
public class TestRunner {
        // Setup Extent Reports
        public static ExtentReports extent;


        @BeforeClass
        public static void setup() {
                ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");
                sparkReporter.config().setDocumentTitle(ConfigurationUtils.getInstance().get_DocumentTitle());
                sparkReporter.config().setReportName(ConfigurationUtils.getInstance().get_ReportName());
                sparkReporter.config().setTheme(Theme.DARK);

                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);
                extent.setSystemInfo("Computer Name", ConfigurationUtils.getInstance().get_ComputerName());
                extent.setSystemInfo("Environment" , ConfigurationUtils.getInstance().get_Environment());
                extent.setSystemInfo("OS",ConfigurationUtils.getInstance().get_OS());
                extent.setSystemInfo("Browser",ConfigurationUtils.getInstance().get_Browser());
                extent.setSystemInfo("Tester Name",ConfigurationUtils.getInstance().get_TesterName());
                extent.setSystemInfo("Review Name",ConfigurationUtils.getInstance().get_ReviewName());
                extent.setSystemInfo("Developer Name",ConfigurationUtils.getInstance().get_DeveloperName());
                extent.attachReporter(sparkReporter);
                System.out.println("Extent Report Initialized.");
        }

        @AfterClass
        public static void tearDown() {
                extent.flush();
                System.out.println("Extent Report Generated.");
        }

        public static ExtentReports getExtentReports() {
                return extent;
        }
}
