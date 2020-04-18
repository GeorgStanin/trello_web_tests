package com.qa.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static final String NAME_BOARD_1 = "TestBoard1";
    public static final String NAME_BOARD_2 = "TestBoard2";
    public static final String NAME_BOARD_3 = "TestBoard3";
    public static final String NAME_TBOARD_1 = "TestTBoard1";
    public static final String NAME_TBOARD_2 = "TestTBoard2";
    public static final String NAME_TBOARD_3 = "TestTBoard3";

    WebDriver wd;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        // wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        //---------------------------------------------Please enter  login and password-----------------------------------
        loginAtlassian("ymfuks@gmail.com", "Parolotatlassian1");
    }

    @AfterMethod
    public void tearDown() {


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
    }

    public void headerCreateMenuButton() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));


    }

    public void laterButton() {
        click(By.cssSelector("[data-test-id='show-later-button']"));
        waitSec(20);
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

    public void initCreateTeamBoard() {
        click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
        waitSec(20);
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        submitButton();
    }

    public void initCloseBoardInMenuMore() {
        clickCloseBoardInMoreMenu();
        submitButton();
    }

    public void clickCloseBoardInMoreMenu() {
        click(By.cssSelector(".js-close-board"));
    }

    public void clickButtonMore() {
        click(By.cssSelector(".board-menu-navigation-item-link.js-open-more"));
    }

    public void selectBoardByName(final String boardName) {
        click(By.xpath("//span[contains(text(),'" + boardName + "')]"));

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
}