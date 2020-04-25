package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeleteTeamTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if (!app.isOnBoardPage()) {
            app.click(By.cssSelector("[href$=boards]"));
        }
        if(app.getTeamBoardsCountLeftSideHomeNavigation()==0){
            app.createTeamBoard();

        }
    }

    @Test
    public void deleteTeamBoards() throws InterruptedException {
        int before = app.getTeamBoardsCountLeftSideHomeNavigation();
        app.waitSec(10);
        Thread.sleep(3000);
        app.openFirstTeamBoardFromLeftSideBarContainer();
        app.clickSettings();
        app.clickDeleteThisTeamButton();
        app.submitButton();
        int after = app.getTeamBoardsCountLeftSideHomeNavigation();
        System.out.println("was: " + before + "now: " + after);
        Assert.assertEquals(after,before-1);
    }

}
