package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.TimePage;
import utils.Utility;

public class TimePageTest {

	WebDriver driver= null;
	TimePage TPobj = null;
	
	
	@BeforeMethod
	public void login() {
		LoginTest lpobj = new LoginTest();
		lpobj.loginWithValidUserTest();
	}
    @Test
    public void verifytimeurl() {
      TPobj = new TimePage(driver);
      TPobj.clicktimelink();
      TPobj.verifytimePage(driver);
      
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
}

