package com.qa.trello;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardTeamCreatTests extends TestBase {
    @Test (enabled = false)
    public void creationFromHomeNavigation() throws InterruptedException{
        initCreateTeamBoard();
        fillBoardForm(NAME_TBOARD_1, "Common description");
        submitButton();
        laterButton();
        goToHomePage();
    }


}
