package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id = "txtUsername")
	WebElement eleUserNameTextBox;

	@FindBy(id = "txtPassword")
	WebElement elePasswordTextBox;

	@FindBy(id = "btnLogin")
	WebElement btnLogin;

	private void enterUserName(String un)
	{
		System.out.println("Entering Username " + un);
		eleUserNameTextBox.sendKeys(un);
		
	}
	private void enterPassword(String pwd)
	{
		System.out.println("Entering Password " + pwd);
		elePasswordTextBox.sendKeys(pwd);
		
	}
	
	private void clickOnLogin()
	{
		System.out.println("clicking on loging button");
		btnLogin.click();
	}
	
	public void loginToApp(String un, String pwd)
	{
		System.out.println("Login using " + un + " and " + pwd);
		enterUserName(un);
		enterPassword(pwd);
		clickOnLogin();
	}
	public LoginPage(WebDriver driver)
	{
		System.out.println("initializing webelements of a Page");
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}