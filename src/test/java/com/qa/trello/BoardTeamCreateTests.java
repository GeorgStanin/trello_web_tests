package com.qa.trello;


import org.testng.annotations.Test;

public class BoardTeamCreateTests extends TestBase {
    @Test //(enabled = false)
    public void creationFromHomeNavigation() throws InterruptedException {
        app.initCreateTeamBoardFromLeftSideHomeNavigation();
        app.fillBoardForm(ApplicationManager.NAME_TBOARD_1, "Common description");
        app.submitButton();
        app.laterButton();
        app.goToHomePage();
    }




}
