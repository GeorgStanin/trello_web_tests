package com.qa.trello.framework_OR_manager_OR_application;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    WebDriver wd;
    PersonalBoardHelper pBoard;
    TeamBoardHelper tBoard;
    SessionHelper session;

    public static final String NAME_BOARD_1 = "TestBoard1";
    public static final String NAME_BOARD_2 = "TestBoard2";
    public static final String NAME_BOARD_3 = "TestBoard3";
    public static final String NAME_TBOARD_1 = "TestTeamBoard1";
    public static final String NAME_TBOARD_2 = "TestTeamBoard2";
    public static final String NAME_TBOARD_3 = "TestTeamBoard3";

    public void init() {
        wd = new ChromeDriver();
        // wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        //---------------------------------------------Please enter  login and password-----------------------------------
        session = new SessionHelper(wd);
        session.loginAtlassian("ymfuks@gmail.com", "Parolotatlassian1");
        pBoard = new PersonalBoardHelper(wd);
        tBoard = new TeamBoardHelper(wd);

    }

    public void stop() {
        wd.quit();
    }

    public PersonalBoardHelper getPboard() {
        return pBoard;
    }

    public TeamBoardHelper getTboard() {
        return tBoard;
    }

    public SessionHelper getSession() {
        return session;
    }
}
