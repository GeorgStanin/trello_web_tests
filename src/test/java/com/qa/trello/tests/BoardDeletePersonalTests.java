package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletePersonalTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        app.getPboard().waitSec(10);
        if (!app.getPboard().isOnBoardPage()) {
            app.getPboard().waitSec(10);
            app.getPboard().click(By.cssSelector("[href$=boards]"));
        }
        if(app.getPboard().getPersonalBoardsCount()==0){
            app.getPboard().createPersonalBoard();
        }
    }

    @Test // (enabled = false)
    public void deleteBoardFromHomePageByName() throws InterruptedException {
        app.getPboard().selectSecondPersonalBoard();
        app.getPboard().backAboutThisBoard();
        app.getPboard().clickButtonMore();
        app.getPboard().initCloseBoardInMenuMore();
        app.getPboard().permanentlyDeleteBoard();
        app.getPboard().goToHomePage();
    }


}
