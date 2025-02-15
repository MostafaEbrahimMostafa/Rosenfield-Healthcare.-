package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationUtils {
    private final Properties properties , properties1;
    private static ConfigurationUtils configutils;
    String prop ;
    private ConfigurationUtils() {

        properties = PropertiesUtils.loadProperties("src/test/java/environment/Production.properties");
        properties1 = PropertiesUtils.loadProperties("src/test/java/environment/userData.properties");
    }

    public static ConfigurationUtils getInstance()
    {
        if(configutils == null)
        {
            configutils = new ConfigurationUtils();
        }
        return configutils;
    }

    public String getBaseUrl()
    {
        prop = properties.getProperty("baseUrl");
        if ((prop != null))
        {
            return prop;
        }
        throw new RuntimeException("base url is not found in property file");
    }

    public String get_DocumentTitle()
    {
        prop = properties.getProperty("DocumentTitle");
        return prop;
    }
    public String get_ReportName()
    {
        prop = properties.getProperty("ReportName");
        return prop;
    }
    public String get_ComputerName ()
    {
        prop = properties.getProperty("ComputerName");
        return prop;
    }
    public String get_Environment()
    {
        prop = properties.getProperty("Environment");
        return prop;
    }
    public String get_OS()
    {
        prop = properties.getProperty("OS");
        return prop;
    }
    public String get_Browser()
    {
        prop = properties.getProperty("Browser");
        return prop;
    }
    public String get_TesterName()
    {
        prop = properties.getProperty("TesterName");
        return prop;
    }
    public String get_ReviewName()
    {
        prop = properties.getProperty("ReviewName");
        return prop;
    }
    public String get_DeveloperName()
    {
        prop = properties.getProperty("DeveloperName");
        return prop;
    }

    public void set_email(String email)
    {
         properties1.setProperty("dynamicEmail", email);
    }
    public void set_password(String password)
    {
       properties1.setProperty("dynamicPassword", password);
    }

    public String get_email()
    {
        prop = properties1.getProperty("dynamicEmail");
        return prop;
    }
    public String get_password()
    {
        prop = properties1.getProperty("dynamicPassword");
        return prop;
    }

    public void store() throws IOException {
        FileOutputStream file = new FileOutputStream("src/test/java/environment/userData.properties");
        properties1.store(file, "Updated dynamic email and password");
    }












}
