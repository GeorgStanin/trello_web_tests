package com.qa.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public static final String NAME_BOARD_1 = "TestBoard1";
    public static final String NAME_BOARD_2 = "TestBoard2";
    public static final String NAME_BOARD_3 = "TestBoard3";
    public static final String NAME_TBOARD_1 = "TestTeamBoard1";
    public static final String NAME_TBOARD_2 = "TestTeamBoard2";
    public static final String NAME_TBOARD_3 = "TestTeamBoard3";
    WebDriver wd;
    WebDriverWait wait;

    protected void init() {
        wd = new ChromeDriver();
        // wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        //---------------------------------------------Please enter  login and password-----------------------------------
        loginAtlassian("ymfuks@gmail.com", "Parolotatlassian1");
    }

    public void stop() {
        wd.quit();
    }

    public void loginAtlassian(String login, String password) {
        initLogin();
        fillLoginFormAtlassian(login, password);
        confirmLoginAtlassian();
        waitSec(10);


    }

    private void confirmLoginAtlassian() {
        click(By.cssSelector("[type='submit']"));
    }

    private void fillLoginFormAtlassian(String login, String password) {
        type(By.cssSelector("[placeholder='Enter email']"), login);
        click(By.cssSelector("[value='Log in with Atlassian']"));
        waitSec(10);
        type(By.cssSelector("[placeholder='Enter password']"), password);
        waitSec(10);
    }

    private void initLogin() {
        click(By.cssSelector("[href='/login']"));
        waitSec(10);
    }

    public void type(By locator, String text) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void waitSec(int time) {
        wd.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void createBoardFromHeader() {
        headerCreateMenuButton();
        selectCreateBoard();
    }

    public void goToHomePage() throws InterruptedException {
        Thread.sleep(3000);
        click(By.cssSelector("[name='house']"));
        click(By.cssSelector("[name='house']"));
        waitSec(10);
    }

    public void boardNameSubmit(String boardName) throws InterruptedException {
        type(By.cssSelector("[placeholder='Add board title']"), boardName);
        waitSec(5);
        Thread.sleep(3000);
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        waitSec(10);
    }

    public void selectCreateBoard() {
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
        click(By.xpath("//div/button[2]/span[@name='down']"));
        click(By.xpath("//div[@class='atlaskit-portal-container']//li[1]"));

    }

    public void headerCreateMenuButton() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));


    }

    public void laterButton() {
        if (isElementPresent("[data-test-id='show-later-button']")) {
            click(By.cssSelector("[data-test-id='show-later-button']"));
            waitSec(20);

        }

    }

    public boolean isElementPresent(String locator) {
        return wd.findElements(By.cssSelector(locator)).size() > 0;
    }

    public void submitButton() {
        click(By.cssSelector("[type='submit']"));
        waitSec(20);
    }

    public void fillBoardForm(String boardName, String descritption) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), boardName);
        click(By.cssSelector("[data-test-id='header-create-team-type-input']"));
        click(By.cssSelector("[data-test-id='header-create-team-type-input-engineering-it']"));
        type(By.cssSelector("[placeholder='Our team organizes everything here.']"), descritption);

    }

    public void initCreateTeamBoardFromLeftSideHomeNavigation() throws InterruptedException {
        Thread.sleep(1000);
        click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
        waitSec(20);
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        submitButton();
    }

    public void initCloseBoardInMenuMore() {
        clickCloseBoardInMoreMenu();
        click(By.cssSelector("[value='Close']"));
    }

    public void clickCloseBoardInMoreMenu() {
        click(By.cssSelector(".js-close-board"));
        waitSec(10);
    }

    public void clickButtonMore() {
        click(By.cssSelector(".board-menu-navigation-item-link.js-open-more"));
        waitSec(10);
    }

    public void selectBoardByName(final String boardName) {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li[2]"));

    }

    public void clickDeleteThisTeamButton() {
        click(By.cssSelector("[class='quiet-button']"));
    }

    public void clickSettings() {
        click(By.cssSelector("[class='icon-gear icon-sm _2aV_KY1gTq1qWc']"));
    }

    public void openFirstTeamBoardFromLeftSideBarContainer() {
        click(By.xpath("//nav[@class='home-left-sidebar-container']//div[2]//li"));
        waitSec(10);

    }

    public int isSetToPublic() {
        return wd.findElements(By.xpath("//span[contains(text(),'This board is set to public. You can change its vi')]")).size();
    }

    public void changeTypeFromPrivateToPublic() {
        click(By.className("icon-private"));
        click(By.className("icon-public"));
        click(By.className("make-public-confirmation-button"));
    }

    public void selectSecondPersonalBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li[2]"));
        waitSec(10);
    }

    public int getPersonalBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

    public int getTeamBoardsCountLeftSideHomeNavigation() {
        return wd.findElements(By.xpath("//nav[@class='home-left-sidebar-container']//div[2]//li")).size()-1;
    }

    public boolean isOnBoardPage() {
        String url = wd.getCurrentUrl();
        return url.contains("boards");
    }

    public void createPersonalBoard() throws InterruptedException {
        createBoardFromHeader();
        boardNameSubmit(NAME_BOARD_1);
        goToHomePage();

    }

    public void createTeamBoard() throws InterruptedException {
        initCreateTeamBoardFromLeftSideHomeNavigation();
        fillBoardForm(NAME_TBOARD_1, "Common description");
        submitButton();
        laterButton();
        goToHomePage();

    }


    public void changeName() {
        click(By.cssSelector(".js-rename-board"));
        wd.findElement(By.cssSelector(".js-board-name-input")).sendKeys("nameChanged"+ Keys.ENTER);


    }

    public void backAboutThisBoard() {
        click(By.cssSelector(".js-pop-widget-view"));
    }
}
