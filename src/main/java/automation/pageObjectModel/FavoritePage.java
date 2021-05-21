package automation.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavoritePage {
	
	public WebDriver ldriver;

	public FavoritePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[contains(.,'Favourite')]")
	@CacheLookup
	WebElement btnFavorite;
	
	@FindBy(xpath = "//a[contains(.,'Books')]")
	@CacheLookup
	WebElement btnBooks;

	//@FindBy(xpath="//a[@href='/favourite']")
	//private WebElement btnFavorite;
	@FindBy(xpath="//div[@class='card-body' and contains(.,'ROCK')]//a[contains(.,'Remove From Favourite')]")
	@CacheLookup
	WebElement btnRemoveROCK;
	
	@FindBy(xpath="//div[@class='card-body' and contains(.,'#NEVERAGAIN')]//a[contains(.,'Remove From Favourite')]")
	@CacheLookup
	WebElement btnRemoveNEVERAGAIN;
	
	@FindBy(xpath="//div[@class='card-body' and contains(.,'#NEVERAGAIN')]//button[contains(.,'Add To Favourite')]")
	@CacheLookup
	WebElement btnAddNEVERAGAIN;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logout;
	
	public void clickLogout() {
		this.logout.click();
	}
	
	public void clickFavourite() {
		this.btnFavorite.click();
	}
	
	public void clickBooks() {
		this.btnBooks.click();
	}
	
	public void clickRemoveRock() {

		this.btnRemoveROCK.click();
	}
	
	public void clickRemoveNeverAgain() {

		this.btnRemoveNEVERAGAIN.click();
	}
	
	public void AddToFav(String arg) {
		if(arg.equals("NEVERAGAIN"))
			this.btnAddNEVERAGAIN.click();
	}
	
	@FindBy(xpath="//input[@id='userName']")
	private WebElement username;
	@FindBy(xpath="//input[@id='psw']")
	private WebElement password;
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement loginButton;
	@FindBy(xpath="//button[contains(text(),'Sign in')]")
	private WebElement signInButton;
	
	

	public void enterUserName(String username) {
		this.username.sendKeys(username);
	}
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}
	public void clickLoginButon() {
		this.loginButton.click();
	}
	public void clickSignInButton() {
		this.signInButton.click();
	}


	public boolean isRemovePresent(String arg) {
	   try  {
		   
		   if(arg.equals("NEVERAGAIN"))
	    	 clickRemoveNeverAgain();
		   else if(arg.equals("ROCK"))
			   clickRemoveRock();
	       return true;
	    } 
   catch (	org.openqa.selenium.NoSuchElementException
 e) {
	        System.out.println("Not PRESENT !!!!!");
	    	return false;
	    }
	}
	
	

}
