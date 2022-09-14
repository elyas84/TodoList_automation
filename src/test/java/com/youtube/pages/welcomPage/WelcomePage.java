package com.youtube.pages.welcomPage;

import com.youtube.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class WelcomePage extends BasePage {
    public WelcomePage(AppiumDriver driver) {
        super(driver);
    }

    //locators

    public final By addFirstTaskInWelcomePage = By.xpath("//android.widget.TextView[@text='Add First Task']");
    public final By addTaskButton = By.id("com.splendapps.splendo:id/fabAddTask");


    /**
     * own method for WelcomePage
     */

    public void validationOfVisibilityOfAddFirstTaskButtonInWelcomePage(){
        System.out.println("INFO: "+driver.findElement(addFirstTaskInWelcomePage)+" is displayed");
        waitToBeVisible(addFirstTaskInWelcomePage);
        Assert.assertTrue(driver.findElement(addFirstTaskInWelcomePage).isDisplayed(), "Add task is displayed");
    }



}
