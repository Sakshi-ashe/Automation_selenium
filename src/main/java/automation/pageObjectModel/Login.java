package automation.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
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
}
