package com.duckduckgo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    @FindBy(name = "q")
    private WebElement searchTxtbox;

    @FindBy(id = "search_button_homepage")
    private WebElement serachBtn;

    @FindBy(linkText = "Videos")
    private WebElement videoslink;

    @FindBy(className = "tile--vid")
    private List<WebElement> allvideos;

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        this.driver.get("https://duckduckgo.com/");
    }

    public void doSearch(String keyword){
        this.wait.until(ExpectedConditions.visibilityOf(this.searchTxtbox));
        this.searchTxtbox.sendKeys(keyword);
        this.serachBtn.click();

    }

    public void goToVideos(){
        this.wait.until(ExpectedConditions.visibilityOf(this.videoslink));
        this.videoslink.click();
    }

    public int getResult(){
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        return this.allvideos.size();
    }
}
