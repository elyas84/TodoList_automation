package com.youtube.tests;

import com.youtube.utils.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase {


    protected   AppiumDriver driver;
    @BeforeMethod
    public void settingUp(){
        System.out.println("INFO: App is launching....");
        DesiredCapabilities ds = new DesiredCapabilities();
        ds.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.get("automationName"));
        ds.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.get("deviceName"));;
        ds.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        ds.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.get("platformVersion"));
        ds.setCapability("appPackage", ConfigReader.get("appPackage"));
        ds.setCapability("appActivity", ConfigReader.get("appActivity"));

        try {
            driver = new AppiumDriver(new URL(ConfigReader.get("url")), ds);

            driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }




    @AfterMethod
    public void tearingDown() throws InterruptedException {
        System.out.println("INFO: App is closing....");
        Thread.sleep(3000);
        driver.quit();
    }
}
