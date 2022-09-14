package com.youtube.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected AppiumDriver driver;
    WebDriverWait wait;

    public BasePage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    /**
     * useful methods
     */
    public void waitToBeVisible(By elementToWait){
        System.out.println("INFO: wait to be visible==> "+driver.findElement(elementToWait));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementToWait)));
    }
    public void clickOn(By elementToClick){

        waitToBeVisible(elementToClick);
        System.out.println("INFO: click on an element==> "+driver.findElement(elementToClick));
        driver.findElement(elementToClick).click();
    }
}
