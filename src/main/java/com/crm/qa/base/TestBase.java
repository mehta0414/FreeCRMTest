package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\rohit.mehta\\IdeaProjects\\FreeCRMTest\\" +
                    "src\\main\\java\\com\\crm\\qa\\Config\\config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.24.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer_x64_2.39.0\\IEdriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WEIGHT, TimeUnit.SECONDS);
        driver.get("https://ui.cogmento.com/");

    }
}
