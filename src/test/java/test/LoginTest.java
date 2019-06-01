package test;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.LoginPage;
import utils.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	
	WebDriver driver = null;
	LoginPage lpObj = null;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@BeforeClass
	public void createPageObj()
	{
		lpObj =  new LoginPage(driver);
	}
	
	
	@BeforeMethod
	public void launchApp()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	
	@Test(priority = 1)
	public void loginWithValidUserTest()
	{
		Reporter.log("Login test is Executing <br>");
		lpObj.loginToApp("Admin", "admin123");
	}
	
	@Test(priority = 2)
	public void loginWithInValidUserTest()
	{
		Reporter.log("Login test is Executing <br>");
		//lpObj.loginToApp("Admin123", "admin123");
		Assert.fail();
		
	}
	
	
	@AfterMethod
	public void checkExecutionstatus(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			TakesScreenshot ss = (TakesScreenshot) driver;
			File srcFile = ss.getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(srcFile, new File("reports\\ss\\Screenshot_"+ Utility.getDate()+ result.getName()+".png"));
						
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	@AfterClass
	public void clearPageObj()
	{
		lpObj = null;
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver = null;
	}
	
}