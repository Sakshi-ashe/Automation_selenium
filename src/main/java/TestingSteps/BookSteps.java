package TestingSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import automation.pageObjectModel.BookPage;
import automation.pageObjectModel.Login;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookSteps {
	
	WebDriver driver;
	public BookPage bp ;
	String url="http://localhost:4200/register";


	@Before
	public void configuration() {
	
		

		 System.setProperty("webdriver.chrome.driver", "/home/purvi.gupta/Downloads/chromedriver_linux64/chromedriver");		
	      
		 ChromeOptions options=new ChromeOptions();
		 
		 options.addArguments("start-maximized");
		 
		 driver= new ChromeDriver(options);
		
		 
		// WebDriverWait wait=new WebDriverWait(driver,10);
		 
	
}
	
	@Given("open login in the chrome browser")
	public void open_the_login_in_the_chrome_browser() {
	    // Write code here that turns the phrase above into concrete actions
	   driver.get(url);
	   bp=PageFactory.initElements(driver,BookPage.class);
	   bp.clickSignInButton();
	}

	@When("enter the login details {string},{string}")
	public void enter_login_details(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	  bp.enterUserName(string);
	  bp.enterPassword(string2);
	}

	@When("i click Login button")
	public void i_click_the_login_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    bp.clickLoginButon();
		Thread.sleep(3000);
	}

	@Then("verify PopUp Message.")
	public void verify_the_pop_up_message() {
	    // Write code here that turns the phrase above into concrete actions
		Alert alert = driver.switchTo().alert(); // switch to alert
	    alert.accept();

	}

	@Then("click on Book button in header")
	public void click_on_Book_button_in_header() {
		bp.clickBook();
	}

	@Then("page Url should be {string}")
	public void page_url_should_be(String arg1) throws InterruptedException {
	    System.out.println("#####"+driver.getCurrentUrl());
	    Thread.sleep(2000);

		
		if(driver.getCurrentUrl().contains(arg1))
		{	assertTrue(true);

		}
		else
		{	driver.close();
			assertTrue(false);
		}
		Thread.sleep(3000);
	}

	
	@Then("add book to favorite with title {string}")
	public void remove_book_from_favorite_with_title(String string) throws InterruptedException {
			Thread.sleep(2000);
			System.out.println(bp.isAddRocksBookPresent(string));
			assertTrue(bp.isAddRocksBookPresent(string));	
			}
	
	
	@Then("verify book with title {string} already present")
	public void verify_book_with_title_already_present(String string) throws InterruptedException {
		Thread.sleep(2000);
		assertTrue(bp.isAddRocksBookPresent(string));
		
	}


	@Then("verify book added successfully")
	public void verify_book_added_successfully() throws InterruptedException {
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert(); // switch to alert
	    alert.accept();

	}
	



	@Then("Click on the logout")
	public void click_on_logout() throws InterruptedException {
		Thread.sleep(3000);

		bp.clickLogout();
		
		Alert alert = driver.switchTo().alert(); // switch to alert
		String alertMessage= driver.switchTo().alert().getText(); // capture alert message
	    assertEquals("Logged out",alertMessage);
	    // click on OK to accept with accept()
	    alert.accept();
	    System.out.println("Loggin Accepted");

	}

	@Then("close the browser")
	public void close_browser() {
		System.out.println("********* Closing browser **************");
		driver.quit();
	}

}
