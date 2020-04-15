package com.qa.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreationTests {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        waitSec(15);
        // wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        waitSec(5);

    }
    @Test
    public void testBoardCreation(){
        login();
        createBoard();
        closeBoard();
        goToHomeScreen();
        createTeamBoard();

    }

    private void createTeamBoard() {
        click(By.cssSelector("[class='icon-add icon-sm _2aV_KY1gTq1qWc']"));
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"),"Test Team Board");
        click(By.cssSelector("[class='css-1wy0on6']"));


    }

    private void goToHomeScreen() {
        click(By.cssSelector("[class='js-confirm full negate']"));
        waitSec(5);
        click(By.cssSelector("[name='house']"));
        waitSec(5);
    }

    private void closeBoard() {
        click(By.cssSelector("[class='board-menu-navigation-item-link js-open-more']"));
        waitSec(5);
        click(By.cssSelector("[class='board-menu-navigation-item-link js-close-board']"));
        waitSec(5);
    }

    private void createBoard() {
        click(By.cssSelector("[name='add']"));
        click(By.cssSelector("[class='_2DBw9GxD3tha0R']"));
        type(By.cssSelector("[data-test-id='create-board-title-input']"), "TestBoard");
        waitSec(5);
        click(By.cssSelector("[class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"));
        waitSec(5);
    }

    private void login() {
        click(By.cssSelector("[href='/login']"));
        waitSec(10);
        clearForm(By.cssSelector("[inputmode='email']"));
        type(By.cssSelector("[inputmode='email']"), "ymfuks@gmail.com");
        waitSec(5);
        click(By.cssSelector("[value='Log in with Atlassian']"));
        waitSec(10);
        clearForm(By.cssSelector("[type='password']"));
        type(By.cssSelector("[type='password']"), "Parolotatlassian1");
        click(By.cssSelector("[type='submit']"));
        waitSec(10);
    }

    private void type(By locator, String letters) {
        wd.findElement(locator).sendKeys(letters);
    }

    private void clearForm(By locator) {
        wd.findElement(locator).clear();
    }
    private void waitSec(int time) {
        wd.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    private void click(By locator) {
        wd.findElement(locator).click();
    }

    @AfterMethod
    public void tearDown(){
        click(By.cssSelector("[class='_24AWINHReYjNBf']"));
        waitSec(5);
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
       // wd.quit();

    }
}
