package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigurationUtils;

import java.util.Arrays;

public class DriverFactory {
    public static WebDriver driver;

    public static WebDriver initializeDriver()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-save-password");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
        driver.get(ConfigurationUtils.getInstance().getBaseUrl());
        driver.manage().window().maximize();
        return  driver;
    }
}
