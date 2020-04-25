package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModifyPersonalTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if (!app.getPboard().isOnBoardPage()) {
            app.getPboard().openBoardsPage();
        }
        if(app.getPboard().getPersonalBoardsCount()==0){
            app.getPboard().createPersonalBoard();
        }
    }
    @Test
    public void changePersonalBoardType() throws InterruptedException {
        int before = app.getPboard().isSetToPublic();
        app.getPboard().selectSecondPersonalBoard();
        app.getPboard().changeTypeFromPrivateToPublic();
        int after = app.getPboard().isSetToPublic();
        Assert.assertEquals(after,before+1);
        app.getPboard().goToHomePage();
    }
    @Test
    public void  changePersonalBoardName() throws InterruptedException {
        app.getPboard().selectSecondPersonalBoard();
        app.getPboard().changeName();
        app.getPboard().goToHomePage();



    }


}
