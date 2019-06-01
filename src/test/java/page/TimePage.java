package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class TimePage {

	@FindBy (xpath="b[text()='Time']")
	private WebElement TimeLink;
	
	@FindBy (id="menu_time_Timesheets")
	private WebElement Timesheetlink;
	
	@FindBy (id ="menu_time_viewEmployeeTimesheet")
	private WebElement EmpTimeSheetlink;
	
	@FindBy (id="employee")
	private WebElement EmpSearchTestBox;
	
	@FindBy(id="btnView")
	private WebElement ViewBTN;
	
	@FindBy(id="btnAddTimesheet")
	private WebElement AddTimeSheetBTN;
	
	public  TimePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clicktimelink() {
		TimeLink.click();
		Reporter.log("clicking on the time link<br>");
	}
	public void verifytimePage(WebDriver driver) {
		String timeurl = driver.getCurrentUrl();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/time/viewEmployeeTimesheet", timeurl);
		
		
	}
	}
