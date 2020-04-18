package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardDeleteTestsByName extends TestBase {
    @Test (enabled = false)
    public void deleteBoardFromHomePageByName() throws InterruptedException {
        selectBoardByName(NAME_BOARD_1);
        clickButtonMore();
        initCloseBoardInMenuMore();
        permanentlyDeleteBoard();
        goToHomePage();
    }


}
