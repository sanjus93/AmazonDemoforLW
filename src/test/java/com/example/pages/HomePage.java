package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;

public class HomePage extends BasePage {
	
	ConfigFileReader configFileReader = new ConfigFileReader();

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
    	//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		
		//driver=new ChromeDriver(options);
		//driver.manage().window().maximize();
        driver.get(configFileReader.getApplicationUrl());
    }

    public void searchFor(String searchTerm) {
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
    }
}