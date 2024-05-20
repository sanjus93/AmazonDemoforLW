package com.example.pages;

import java.text.NumberFormat;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[@class='a-price-whole']")
    private WebElement price;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;
    
    @FindBy(id = "nav-cart-count")
    private WebElement cartscreen;
    
    @FindBy(id = "attach-view-cart-button-form")
    private WebElement cartscreenwithoutskip;
    

    @FindBy(xpath = "//input[@aria-labelledby='attachSiNoCoverage-announce']")
    private WebElement skipbutton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public int getProductPrice() throws InterruptedException {
    	Thread.sleep(3000);
    	System.out.println("Price of the product is" + price.getText());
    	String pricevalue=price.getText();
    
        return Integer.parseInt(pricevalue.replaceAll(",", ""));
        
    }

    public void addToCart() {
        addToCartButton.click();
    }
    
    public void clickskip() {
    	
    	if(skipbutton.isDisplayed()) {
    	skipbutton.click();
    	}
    }
    
    public void clickCart() throws InterruptedException {
    	if(cartscreen.isDisplayed()) {
    	cartscreen.click();
    	Thread.sleep(4000);
    	}
    	
    }
    
    public void clickcartwithoutskip() {
    	if(cartscreenwithoutskip.isDisplayed()) {
    		cartscreenwithoutskip.click();
    }
}}