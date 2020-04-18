package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardDeleteTestsByCount extends TestBase{
    @Test
    public void deleteTeamBoards() {
        openFirstTeamBoardFromLeftSideBarContainer();
        clickSettings();
        clickDeleteThisTeamButton();
        submitButton();


    }

}
