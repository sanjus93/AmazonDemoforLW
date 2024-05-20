// src/main/java/com/example/pages/CartPage.java
package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	@FindBy(css = "span.a-size-medium.a-color-base.sc-price.sc-white-space-nowrap")
    private WebElement cartPrice;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
    private WebElement cartSubtotal;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartPrice() throws InterruptedException {
    	Thread.sleep(4000);
    	
        return cartPrice.getText();
    }

    public String getCartSubtotal() {
        return cartSubtotal.getText();
    }
}
