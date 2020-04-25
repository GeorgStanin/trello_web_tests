package com.qa.trello.framework_OR_manager_OR_application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HelperBase {

    WebDriver wd;
    WebDriverWait wait;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
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

    public void goToHomePage() throws InterruptedException {
        Thread.sleep(3000);
        click(By.cssSelector("[name='house']"));
        click(By.cssSelector("[name='house']"));
        waitSec(10);
    }
    public void headerCreateMenuButton() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));

    }
    public boolean isElementPresent(String locator) {
        return wd.findElements(By.cssSelector(locator)).size() > 0;
    }
    public void submitButton() {
        click(By.cssSelector("[type='submit']"));
        waitSec(20);
    }
    public boolean isOnBoardPage() {
        String url = wd.getCurrentUrl();
        return url.contains("boards");
    }
    public void clickSettings() {
        click(By.cssSelector("[class='icon-gear icon-sm _2aV_KY1gTq1qWc']"));
    }
    public void openBoardsPage() {
        click(By.cssSelector("[href$=boards]"));
    }

}
