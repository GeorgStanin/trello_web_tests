package com.qa.trello.tests;


import com.qa.trello.framework_OR_manager_OR_application.ApplicationManager;
import org.testng.annotations.Test;

public class BoardTeamCreateTests extends TestBase {
    @Test //(enabled = false)
    public void creationFromHomeNavigation() throws InterruptedException {
        app.getTboard().initCreateTeamBoardFromLeftSideHomeNavigation();
        app.getTboard().fillBoardForm(ApplicationManager.NAME_TBOARD_1, "Common description");
        app.getTboard().submitButton();
        app.getTboard().laterButton();
        app.getPboard().goToHomePage();
    }




}
