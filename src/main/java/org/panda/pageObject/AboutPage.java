package org.panda.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {

    WebDriver webDriver;

    public AboutPage(WebDriver rDriver) {
        this.webDriver = rDriver;
        PageFactory.initElements(rDriver,this);
    }

    @FindBy(xpath ="//li[@id='menu-item-9']")
    WebElement AboutPageDl;

    public void navigateLink(){
        Actions action = new Actions(webDriver);
        action.moveToElement(AboutPageDl).click().perform();

    }

    public boolean isLocationDisplayed(){
        return AboutPageDl.isDisplayed();
    }

    public String getLocation(){
        return AboutPageDl.getText();
    }



}
