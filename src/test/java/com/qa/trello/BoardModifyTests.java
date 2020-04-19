package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardModifyTests extends TestBase{
    @Test
    public void ChangePersonalBoardName() throws InterruptedException {
        int before = isSetToPublic();
        selectSecondPersonalBoard();
        changeTypeFromPrivateToPublic();
        int after = isSetToPublic();
        Assert.assertEquals(after,before+1);
        goToHomePage();
    }


}
