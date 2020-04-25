package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModifyTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if (!app.isOnBoardPage()) {
            app.click(By.cssSelector("[href$=boards]"));
        }
        if(app.getPersonalBoardsCount()==0){
            app.createPersonalBoard();
        }
    }
    @Test
    public void changePersonalBoardType() throws InterruptedException {
        int before = app.isSetToPublic();
        app.selectSecondPersonalBoard();
        app.changeTypeFromPrivateToPublic();
        int after = app.isSetToPublic();
        Assert.assertEquals(after,before+1);
        app.goToHomePage();
    }
    @Test
    public void  changePersonalBoardName() throws InterruptedException {
        app.selectSecondPersonalBoard();
        app.changeName();
        app.goToHomePage();



    }


}
