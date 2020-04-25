package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreateTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        app.waitSec(10);
        if (!app.isOnBoardPage()) {
            app.waitSec(10);
            app.click(By.cssSelector("[href$=boards]"));
        }
        if (app.getPersonalBoardsCount() == 0) {
            app.createPersonalBoard();
        }
    }

    @Test //(enabled = false)
    public void creationFromHeader() throws InterruptedException {
        Thread.sleep(2000);
        int before = app.getPersonalBoardsCount();
        app.createBoardFromHeader();
        app.boardNameSubmit(ApplicationManager.NAME_BOARD_1);
        app.goToHomePage();
        int after = app.getPersonalBoardsCount();
        System.out.println("was: " + before + "now: " + after);
        Assert.assertEquals(after, before + 1);
    }


}
