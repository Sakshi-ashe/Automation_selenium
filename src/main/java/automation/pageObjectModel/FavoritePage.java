package automation.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavoritePage {
	
	public WebDriver ldriver;
	public String str="";

	public FavoritePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[contains(.,'Favourite')]")
	@CacheLookup
	WebElement btnFavorite;

	//@FindBy(xpath="//a[@href='/favourite']")
	//private WebElement btnFavorite;
	@FindBy(xpath="//div[@class='card-body' and contains(.,str)]//a[contains(.,'Remove From Favourite')]")
	@CacheLookup
	WebElement btnRemove;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logout;
	
	public void clickLogout() {
		this.logout.click();
	}
	
	public void clickFavourite() {
		System.out.println("clickFavourite() run!");
		this.btnFavorite.click();
	}
	
	public void clickRemove(String arg) {
		System.out.println("clickRemoveRockOFAges() run!");
		str = arg;
		this.btnRemove.click();
	}
	
	@FindBy(xpath="//input[@id='userName']")
	private WebElement username;
	@FindBy(xpath="//input[@id='psw']")
	private WebElement password;
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement loginButton;
	@FindBy(xpath="//button[contains(text(),'Sign in')]")
	private WebElement signInButton;
	
	
//	Alert alert = driver.switchTo().alert(); // switch to alert
//
//	String alertMessage= driver.switchTo().alert().getText(); // capture alert message
	
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
	    try {
	    	clickRemove(arg);
	    	return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}

	

}
