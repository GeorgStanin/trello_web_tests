package com.qa.trello.framework_OR_manager_OR_application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamBoardHelper extends HelperBase {
    public TeamBoardHelper(WebDriver wd) {
        super(wd);
    }
    public void initCreateTeamBoardFromLeftSideHomeNavigation() throws InterruptedException {
        Thread.sleep(1000);
        click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
        waitSec(20);
    }
    public void clickDeleteThisTeamButton() {
        click(By.cssSelector("[class='quiet-button']"));
    }
    public void openFirstTeamBoardFromLeftSideBarContainer() {
        click(By.xpath("//nav[@class='home-left-sidebar-container']//div[2]//li"));
        waitSec(10);
    }
    public int getTeamBoardsCountLeftSideHomeNavigation() {
        return wd.findElements(By.xpath("//nav[@class='home-left-sidebar-container']//div[2]//li")).size()-1;
    }
    public void createTeamBoard() throws InterruptedException {
        initCreateTeamBoardFromLeftSideHomeNavigation();
        fillBoardForm(ApplicationManager.NAME_TBOARD_1, "Common description");
        submitButton();
        laterButton();
        goToHomePage();
    }
    public void fillBoardForm(String boardName, String descritption) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), boardName);
        click(By.cssSelector("[data-test-id='header-create-team-type-input']"));
        click(By.cssSelector("[data-test-id='header-create-team-type-input-engineering-it']"));
        type(By.cssSelector("[placeholder='Our team organizes everything here.']"), descritption);
    }
    public void laterButton() {
        if (isElementPresent("[data-test-id='show-later-button']")) {
            click(By.cssSelector("[data-test-id='show-later-button']"));
            waitSec(20);
        }
    }
    public void openBoardsPage() {
        click(By.cssSelector("[href$=boards]"));
    }
}
