package TestingSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.pageObjectModel.FavoritePage;
import automation.pageObjectModel.Login;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FavoriteSteps {
	
	WebDriver driver;
	public FavoritePage fp ;
	String url="http://localhost:4200/register";


	@Before
	public void configuration() {
	
		

		System.setProperty("webdriver.chrome.driver","/home/sakshi.gupta3/Downloads/chromedriver_linux64/chromedriver");
	      
		 ChromeOptions options=new ChromeOptions();
		 
		 options.addArguments("start-maximized");
		 
		 driver= new ChromeDriver(options);
		
		 
		// WebDriverWait wait=new WebDriverWait(driver,10);
		 
	
}
	
	@Given("open the login in the chrome browser")
	public void open_the_login_in_the_chrome_browser() {
	    // Write code here that turns the phrase above into concrete actions
	   driver.get(url);
	   fp=PageFactory.initElements(driver,FavoritePage.class);
	   fp.clickSignInButton();
	}

	@When("enter login details {string},{string}")
	public void enter_login_details(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	  fp.enterUserName(string);
	  fp.enterPassword(string2);
	}

	@When("i click the Login button")
	public void i_click_the_login_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    fp.clickLoginButon();
		Thread.sleep(3000);
	}

	@Then("verify the PopUp Message.")
	public void verify_the_pop_up_message() {
	    // Write code here that turns the phrase above into concrete actions
		Alert alert = driver.switchTo().alert(); // switch to alert
		String alertMessage= driver.switchTo().alert().getText(); // capture alert message
	    assertEquals("Logged In",alertMessage);
	    // click on OK to accept with accept()
	    alert.accept();
	    System.out.println("Loggin Accepted");

	}

	@Then("click on Favorite button in header")
	public void click_on_favorite_button_in_header() {
		fp.clickFavourite();
	}

	@Then("Page Url should be {string}")
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

	@Then("remove book from favorite with title {string}")
	public void remove_book_from_favorite_with_title(String string) throws InterruptedException {
			Thread.sleep(2000);
			assertTrue(fp.isRemovePresent(string));
	}
	
	@Then("verify book with title {string} already absent")
	public void verify_book_with_title_already_absent(String string) throws InterruptedException {
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert(); // switch to alert
		String alertMessage= driver.switchTo().alert().getText(); // capture alert message
	    assertEquals("No books added",alertMessage);
	      // click on OK to accept with accept()
	    alert.accept();
		System.out.println(fp.isRemovePresent(string));

	}


	@Then("verify book removed successfully")
	public void verify_book_removed_successfully() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
		    wait.until(ExpectedConditions.alertIsPresent());
		    Alert alert1 = driver.switchTo().alert();
			String alertMessage= driver.switchTo().alert().getText(); // capture alert message
		    assertEquals("removed successfully",alertMessage);

		    Thread.sleep(3000);
		    alert1.accept();
		} catch (Exception e) {
		    // No alert exists
		}

		try {
		    wait.until(ExpectedConditions.alertIsPresent());
		    Alert alert2 = driver.switchTo().alert();
			String alertMessage= driver.switchTo().alert().getText(); // capture alert message
		    assertEquals("No books added",alertMessage);

		    Thread.sleep(3000);
		    alert2.accept();
		} catch (Exception e) {
		    // No alert exists
		}
		

	}
	



	@Then("Click on logout")
	public void click_on_logout() throws InterruptedException {
		Thread.sleep(3000);

		fp.clickLogout();
		
		Alert alert = driver.switchTo().alert(); // switch to alert
		String alertMessage= driver.switchTo().alert().getText(); // capture alert message
		assertEquals("Logged out",alertMessage);
	    // click on OK to accept with accept()
	    alert.accept();

	}

	@Then("close browser")
	public void close_browser() {
		System.out.println("********* Closing browser **************");
		driver.quit();
	}
	
	
	@Then("click on Books button in header")
	public void click_on_books_button_in_header() {
		fp.clickBooks();
	}

	@Then("add to favorite {string}")
	public void add_to_favorite(String string) {
		fp.AddToFav(string); 
		Alert alert = driver.switchTo().alert(); // switch to alert
		alert.accept();

	}

}
