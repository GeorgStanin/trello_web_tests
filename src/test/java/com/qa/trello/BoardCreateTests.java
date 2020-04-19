package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreateTests extends TestBase {


    @Test //(enabled = false)
    public void creationFromHeader() throws InterruptedException {
        int before = getPersonalBoardsCount();
        createBoardFromHeader();
        boardNameSubmit(NAME_BOARD_1);
        goToHomePage();
        int after = getPersonalBoardsCount();
        System.out.println("was: " + before + "now: " + after);
        Assert.assertEquals(after, before + 1);
    }


}
