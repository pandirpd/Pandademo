package org.panda.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver webDriver;

    public HomePage(WebDriver rDriver) {
        this.webDriver = rDriver;
        PageFactory.initElements(rDriver,this);
    }

    @FindBy(xpath ="//li[@id='menu-item-8']")
    WebElement HomePageDl;



    public void navigateLink(){
        Actions action = new Actions(webDriver);
        action.moveToElement(HomePageDl).click().perform();

    }

    public String getLocation(){
        return HomePageDl.getText();
    }


}
