package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeleteTeamTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if (!app.getPboard().isOnBoardPage()) {
            app.getPboard().openBoardsPage();
        }
        if(app.getTboard().getTeamBoardsCountLeftSideHomeNavigation()==0){
            app.getTboard().createTeamBoard();

        }
    }

    @Test
    public void deleteTeamBoards() throws InterruptedException {
        int before = app.getTboard().getTeamBoardsCountLeftSideHomeNavigation();
        app.getPboard().waitSec(10);
        Thread.sleep(3000);
        app.getTboard().openFirstTeamBoardFromLeftSideBarContainer();
        app.getTboard().clickSettings();
        app.getTboard().clickDeleteThisTeamButton();
        app.getPboard().submitButton();
        int after = app.getTboard().getTeamBoardsCountLeftSideHomeNavigation();
        System.out.println("was: " + before + "now: " + after);
        Assert.assertEquals(after,before-1);
    }

}
