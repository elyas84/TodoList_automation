package com.youtube.tests;

import com.youtube.pages.welcomPage.WelcomePage;
import org.testng.annotations.Test;

public class StartTest extends TestBase {

    WelcomePage welcomePage;

    @Test
    public void start() {

        welcomePage = new WelcomePage(driver);
        welcomePage.validationOfVisibilityOfAddFirstTaskButtonInWelcomePage();
        welcomePage.clickOn(welcomePage.addTaskButton);
    }

}
