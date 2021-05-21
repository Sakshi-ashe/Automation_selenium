package automation.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {

	@FindBy(xpath="//input[@id='userName']")
	private WebElement username;
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	@FindBy(xpath="//input[@id='psw']")
	private WebElement password;
	@FindBy(xpath="//input[@id='name']")
	private WebElement name;
	///html/body/app-root/div[2]/app-user-component/div/div/div/div/form/div[1]/button
	@FindBy(xpath="//button[contains(text(),'Register')]")
	private WebElement register;
	
	public void enterUserName(String userName) {
		this.username.sendKeys(userName);
	}
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}
	public void enterEmail(String email) {
		this.email.sendKeys(email);
	}
	public void enterName(String name) {
		this.name.sendKeys(name);
	}
	public void clickRegister() {
		this.register.click();
	}
}
