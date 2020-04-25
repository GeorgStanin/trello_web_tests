package com.qa.trello.framework_OR_manager_OR_application;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PersonalBoardHelper extends HelperBase {

    public PersonalBoardHelper(WebDriver wd) {
        super(wd);
    }

    public void createBoardFromHeader() {
        headerCreateMenuButton();
        selectCreateBoard();
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

    public void createPersonalBoard() throws InterruptedException {
        createBoardFromHeader();
        boardNameSubmit(ApplicationManager.NAME_BOARD_1);
        goToHomePage();
    }

    public void changeName() {
        click(By.cssSelector(".js-rename-board"));
        wd.findElement(By.cssSelector(".js-board-name-input")).sendKeys("nameChanged" + Keys.ENTER);

    }

    public void backAboutThisBoard() {
        click(By.cssSelector(".js-pop-widget-view"));
    }

}
