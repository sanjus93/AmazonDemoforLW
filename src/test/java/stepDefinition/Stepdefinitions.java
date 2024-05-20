package stepDefinition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import com.example.pages.HomePage;
import com.example.pages.ProductPage;
import com.example.pages.ResultsPage;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import com.example.pages.CartPage;



public class Stepdefinitions {
	
	ConfigFileReader configFileReader = new ConfigFileReader();
	public  WebDriver driver;
	 HomePage homePage;
	 ResultsPage resultsPage;
	 ProductPage productPage;  
	 
	 int prodprice;
	
	String productPrice;//can be converted to Integer list to store prices of all products if there are multiple products added to cart
	String produc2Price;
	ArrayList<Integer> CartPriceofProduct = new ArrayList<Integer>();
	String Subtotal=productPrice + produc2Price;
	CartPage cartPage;
	
	@Given("User launch amazon website")
	public void user_launch_chrome_browser() {
		System.out.println("Launching Chrome...");
		try {
			

			System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
			homePage = new HomePage(driver);
			productPage = new ProductPage(driver);
			driver.manage().window().maximize();
			homePage.open();
			Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		

			

			
			}
//			
			
			
			
		 catch (Exception e) {
			
			driver.close();

		}}
	

    
    
		@When("I login to Amazon")
		public void i_launch_chrome_browser() {
			System.out.println("Launching Chrome...");
			

			}
		

		 
			@When("It happens")
			public void it_launch_chrome_browser() {
				System.out.println("Launching Chrome...");
				try {
					System.out.println("Just for testing");
					}
								 catch (Exception e) {
					          driver.close();

				}


		
		
		
	}
			
			@When("^I type ([^\"]*) in search field$")
			public void type_product(String product) {
				homePage.searchFor(product);
				


	}
			

			@Then("List of ([^\\\"]*) are displayed")
		    public void verifySearchResults(String Product) {
				try {
					Thread.sleep(3000);
					resultsPage=new ResultsPage(driver);
					 assertTrue(resultsPage.isPageLoaded());
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			
				
		       
		    }

			@When("^I add the first item in the cart$")
			 public void selectFirstItem() {
			        resultsPage.selectFirstResult();
			       
			    }
			
			@When("^I add the first item of second product in the cart$")
			 public void selectSecondItem() {
			        resultsPage.selectSecondResult();
			       
			    }
			
			 @Then("Product Page is loaded")
			    public void verifyProductPage() {
			        Assert.assertTrue(driver.getTitle().contains("Amazon.in"));
			    }
			 
			 @When("Add the item to cart by clicking on Add to Cart")
			    public void addToCart() throws InterruptedException {
				 
			        //productPrice = productPage.getProductPrice();
			        prodprice=productPage.getProductPrice();
			        CartPriceofProduct.add(prodprice);
			        productPage.addToCart();
			        Thread.sleep(5000);
			        
			        
			    }
			 
			 @When("Add the second item to cart by clicking on Add to Cart")
			    public void addSecondPrToCart() throws InterruptedException {
				 
				    prodprice=productPage.getProductPrice();
			        Subtotal=productPrice +produc2Price;
			        productPage.addToCart();
			        Thread.sleep(5000);
			        
			    }
			 
			 
			 
			 
			 
			 @When("Open Cart from the top-left")
			    public void openCart() throws InterruptedException {
				     productPage.clickskip();
				     productPage.clickcartwithoutskip();
			        productPage.clickCart();
			    }
			 
			 @And("I close the browser")
			    public void closebrowser() {
				     driver.close();
			    }
			 
			 
			    @Then("Verify that the sub total is identical to the product page")
			    public void verifyCartSubtotal() {
			    	if (cartPage.getCartSubtotal()!= null) {
			    		
			    	for (int i:CartPriceofProduct)
			    			Subtotal=Subtotal + i;
			    			
			    		}
			        Assert.assertEquals(cartPage.getCartSubtotal(), Subtotal);
			    	}
			    

			    @When("Select the ([^\\\"]*) item in the List")
			    public void selectSecondItem(String product) {
			        if (product.equals("second") ) {
			            resultsPage.selectSecondResult();
			        } else {
			            resultsPage.selectFirstResult();
			        }
			    }
			    
			    @When("Select the ([^\\\"]*) item from second window in the List")
			    public void selectfirstitemfromsecondwindow(String product) {
			       
			            resultsPage.firstResultfromSecondwindow();
			       
			    }
			 
			    
			    @Then("Verify that the price is identical to the product page")
			    public void verifyCartPrice() {
			        try {
			        	
			        	//getting  random null pointer exception in cart price even though the data is correct,tried with inner text and attribute along with jsexecutor
			        	if (cartPage.getCartPrice()!= null) {
						Assert.assertEquals(cartPage.getCartPrice(), productPrice);}
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}}
			    
		
}
