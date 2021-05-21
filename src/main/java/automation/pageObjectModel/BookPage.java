package automation.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage {
	
	public WebDriver ldriver;
	public String str="";

	public BookPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Books')]")
	@CacheLookup
	WebElement btnBook;

	//@FindBy(xpath="//a[@href='/favourite']")
	//private WebElement btnFavorite;
	@FindBy(xpath="//body/app-root[1]/div[1]/app-book-list[1]/div[1]/div[1]/div[1]/div[1]/div[10]/div[1]/div[1]/button[1]")
	@CacheLookup
	WebElement btnAddRocksBook;
	
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logout;
	
	public void clickLogout() {
		this.logout.click();
	}
	
	public void clickBook() {
		System.out.println("clickFavourite() run!");
		this.btnBook.click();
	}
	
	
	public void clickAddRocksBook(String arg) {
		System.out.println("clickAddRocksBook() run!");
		str = arg;
		this.btnAddRocksBook.click();
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


	public boolean isAddRocksBookPresent(String arg) {
	    try {
	    	clickAddRocksBook(arg);
	    	return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
	

	

}
