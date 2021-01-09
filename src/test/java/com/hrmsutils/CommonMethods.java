package com.hrmsutils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CommonMethods {
    public static WebDriver driver;
    /**
     * this method will open the browser, set up the configuration and navigate to the URL
     */
  //  @BeforeMethod(alwaysRun = true)
    public static void setUp(){
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigsReader.getPropertyValue("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                //System.setProperty("webdriver.chrome.driver", "C:\\Users\\rucha\\eclipse-workspace\\TestNG_Batch8\\drivers\\chromedriver.exe");
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.chromedriver().setup();
                //System.setProperty("webdriver.gecko.driver", "C:\\Users\\rucha\\eclipse-workspace\\Selenium\\drivers\\geckodriver.exe");
                driver=new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser");
        }
        driver.get(ConfigsReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }
//only and only my driver properly initilized call this method:
    /**
     * this method will close any open browser. won't be called if no browser is open
     */
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void test(){
        System.out.println(System.getProperty("os.name"));
    }

}
