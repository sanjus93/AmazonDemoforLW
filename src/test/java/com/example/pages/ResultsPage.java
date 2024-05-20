package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends BasePage {

    @FindBy(xpath= "//span[@class='a-size-medium a-color-base a-text-normal']")
    private List<WebElement> searchResults;

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public void selectFirstResult() {
        searchResults.get(0).click();
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println("Switched to second tab: " + driver.getCurrentUrl());
         
    }
    

    public void selectSecondResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
        searchResults.get(1).click();
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println("Switched to second tab: " + driver.getCurrentUrl());
    }
    
    
    public void firstResultfromSecondwindow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
        searchResults.get(1).click();
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        System.out.println("Switched to third tab: " + driver.getCurrentUrl());
    }
    public boolean isPageLoaded() {
        return  searchResults.get(0).isDisplayed();
    }
    
}