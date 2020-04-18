package com.qa.trello;
import org.testng.annotations.Test;

public class BoardCreatTests extends TestBase{



    @Test (enabled = false)
    public void creationFromHeader() throws InterruptedException{
        createBoardFromHeader();
        boardNameSubmit(NAME_BOARD_1);
        goToHomePage();
    }
    public void creationFromHomePage (){
        initBoardCreation();


    }

    public void initBoardCreation() {

    }


}
