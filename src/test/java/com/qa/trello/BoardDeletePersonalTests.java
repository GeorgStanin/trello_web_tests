package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletePersonalTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        app.waitSec(10);
        if (!app.isOnBoardPage()) {
            app.waitSec(10);
            app.click(By.cssSelector("[href$=boards]"));
        }
        if(app.getPersonalBoardsCount()==0){
            app.createPersonalBoard();
        }
    }

    @Test // (enabled = false)
    public void deleteBoardFromHomePageByName() throws InterruptedException {
        app.selectSecondPersonalBoard();
        app.backAboutThisBoard();
        app.clickButtonMore();
        app.initCloseBoardInMenuMore();
        app.permanentlyDeleteBoard();
        app.goToHomePage();
    }


}
