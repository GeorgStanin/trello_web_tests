package com.qa.trello;


import org.testng.annotations.Test;

public class BoardTeamCreateTests extends TestBase {
    @Test //(enabled = false)
    public void creationFromHomeNavigation() throws InterruptedException {
        initCreateTeamBoardFromLeftSideHomeNavigation();
        fillBoardForm(NAME_TBOARD_1, "Common description");
        submitButton();
        laterButton();
        goToHomePage();
    }




}
