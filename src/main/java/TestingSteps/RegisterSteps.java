package TestingSteps;

import static org.junit.Assert.assertEquals;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import automation.pageObjectModel.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {
	
	
	WebDriver driver;
	RegisterPage rp=new RegisterPage();	
	  String url="http://localhost:4200/register";
	@Before
	public void configuration() {
	
		

		 System.setProperty("webdriver.chrome.driver","/home/akshath.agarwal/Downloads/Spring tool suite 4/chromedriver");		
	      
		 ChromeOptions options=new ChromeOptions();
		 
		 options.addArguments("start-maximized");
		 
		 driver= new ChromeDriver(options);
		
		
		 
		// WebDriverWait wait=new WebDriverWait(driver,10);
		 
	
}
	
	
	@Given("Open the web page in the chrome browser")
	public void open_the_web_page_in_the_chrome_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(url);
		rp=PageFactory.initElements(driver,RegisterPage.class);
	 
	}

	@When("Enter details {string},{string},{string},{string}")
	public void enter_details(String string, String string2, String string3, String string4) {
	    // Write code here that turns the phrase above into concrete actions
  rp.enterUserName(string);
  rp.enterEmail(string2);
  rp.enterPassword(string3);
  rp.enterName(string4);
  
	}

	@When("I click the Register button")
	public void i_click_the_register_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		rp.clickRegister();
		Thread.sleep(3000);
	
	}

	@Then("Verify the PopUp.")
	public void verify_the_pop_up() {
	    // Write code here that turns the phrase above into concrete actions
		Alert alert = driver.switchTo().alert(); // switch to alert
		String alertMessage= driver.switchTo().alert().getText(); // capture alert message
        assertEquals("Username already exists!",alertMessage);
	 
	}
	@After
	public void endphase() {
	    driver.close();
//		driver.quit();
	}
}
