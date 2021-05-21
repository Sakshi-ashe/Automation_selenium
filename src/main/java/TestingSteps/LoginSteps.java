package TestingSteps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import automation.pageObjectModel.Login;
import automation.pageObjectModel.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver;
	Login lp=new Login();	
	  String url="http://localhost:4200/register";
	@Before
	public void configuration() {
	
		

		System.setProperty("webdriver.chrome.driver","/home/sakshi.gupta3/Downloads/chromedriver_linux64/chromedriver");
	      
		 ChromeOptions options=new ChromeOptions();
		 
		 options.addArguments("start-maximized");
		 
		 driver= new ChromeDriver(options);
		
		
		 
		// WebDriverWait wait=new WebDriverWait(driver,10);
		 
	
}
	
	

@Given("Open the login in the chrome browser")
public void open_the_login_in_the_chrome_browser() {
    // Write code here that turns the phrase above into concrete actions
   driver.get(url);
   lp=PageFactory.initElements(driver,Login.class);
   lp.clickSignInButton();
}

@When("Enter login details {string},{string}")
public void enter_login_details(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
  lp.enterUserName(string);
  lp.enterPassword(string2);
}

@When("I click the Login button")
public void i_click_the_login_button() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
    lp.clickLoginButon();
	Thread.sleep(3000);
}

@Then("Verify the PopUp Message.")
public void verify_the_pop_up_message() {
    // Write code here that turns the phrase above into concrete actions
	Alert alert = driver.switchTo().alert(); // switch to alert
	String alertMessage= driver.switchTo().alert().getText(); // capture alert message
    assertEquals("Logged In",alertMessage);
    // click on OK to accept with accept()
    alert.accept();
    System.out.println("Loggin Accepted");

}
	@After
	public void end() {
		driver.close();
//		driver.quit();
	}
}
