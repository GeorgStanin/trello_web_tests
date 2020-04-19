package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeleteTestsByCount extends TestBase{
    @Test
    public void deleteTeamBoards() {
        int before = getBoardsCountLeftSideHomeNavigation();
        openFirstTeamBoardFromLeftSideBarContainer();
        clickSettings();
        clickDeleteThisTeamButton();
        submitButton();
        int after = getBoardsCountLeftSideHomeNavigation();
        System.out.println("was: " + before + "now: " + after);
        Assert.assertEquals(after,before-1);
    }

}
