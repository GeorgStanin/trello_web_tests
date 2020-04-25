package com.qa.trello.framework_OR_manager_OR_application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper  extends HelperBase{
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void loginAtlassian(String login, String password) {
        initLogin();
        fillLoginFormAtlassian(login, password);
        confirmLoginAtlassian();
        waitSec(10);
    }
    public void confirmLoginAtlassian() {
        click(By.cssSelector("[type='submit']"));
    }
    public void fillLoginFormAtlassian(String login, String password) {
        type(By.cssSelector("[placeholder='Enter email']"), login);
        click(By.cssSelector("[value='Log in with Atlassian']"));
        waitSec(10);
        type(By.cssSelector("[placeholder='Enter password']"), password);
        waitSec(10);
    }
    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
        waitSec(10);
    }
}
