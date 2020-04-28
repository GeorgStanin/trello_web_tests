package com.qa.trello.framework_OR_manager_OR_application;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class ApplicationManager {
    WebDriver wd;
    PersonalBoardHelper pBoard;
    TeamBoardHelper tBoard;
    SessionHelper session;
    String browser;

    public static final String NAME_BOARD_1 = "TestBoard1";
    public static final String NAME_BOARD_2 = "TestBoard2";
    public static final String NAME_BOARD_3 = "TestBoard3";
    public static final String NAME_TBOARD_1 = "TestTeamBoard1";
    public static final String NAME_TBOARD_2 = "TestTeamBoard2";
    public static final String NAME_TBOARD_3 = "TestTeamBoard3";

    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    public void init() {
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        }
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }
        // wd.manage().window().maximize();
        wd.navigate().to("http://trello.com/");
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
