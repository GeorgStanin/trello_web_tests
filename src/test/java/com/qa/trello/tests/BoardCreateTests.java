package com.qa.trello.tests;

import com.qa.trello.framework_OR_manager_OR_application.ApplicationManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreateTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        app.getPboard().waitSec(10);
        if (!app.getPboard().isOnBoardPage()) {
            app.getPboard().waitSec(10);
            app.getPboard().click(By.cssSelector("[href$=boards]"));
        }
        if (app.getPboard().getPersonalBoardsCount() == 0) {
            app.getPboard().createPersonalBoard();
        }
    }

    @Test //(enabled = false)
    public void creationFromHeader() throws InterruptedException {
        Thread.sleep(2000);
        int before = app.getPboard().getPersonalBoardsCount();
        app.getPboard().createBoardFromHeader();
        app.getPboard().boardNameSubmit(ApplicationManager.NAME_BOARD_1);
        app.getPboard().goToHomePage();
        int after = app.getPboard().getPersonalBoardsCount();
        System.out.println("was: " + before + "now: " + after);
        Assert.assertEquals(after, before + 1);
    }


}
