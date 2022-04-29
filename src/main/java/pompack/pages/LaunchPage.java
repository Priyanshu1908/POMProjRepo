package pompack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pompack.base.BasePage;
import pompack.util.Constants;

public class LaunchPage extends BasePage {
	
	@FindBy(className="zh-customers")
	public WebElement Customers;
	
	@FindBy(className="zh-support")
	public WebElement Support;
	
	@FindBy(className="zh-login")
	public WebElement Signin;
	
	@FindBy(className="zh-signup")
	public WebElement Signup;
	
	public LaunchPage(WebDriver driver, ExtentTest etest) {
		
		this.driver = driver;
			
		this.etest = etest;
		
	}
	
	
	public boolean gotoLoginPage() {
		
		driver.get(Constants.APP_URL);
		
		etest.log(LogStatus.INFO, "URL is opened");
		
		Signin.click();
		
		etest.log(LogStatus.INFO, "Login page is opened");
		
		LoginPage loginPage = new LoginPage(driver, etest);
		
		PageFactory.initElements(driver, loginPage);
		
		boolean loginstatus = loginPage.doLogin();
		
		if(loginstatus) {
			
			return true;
			
		}else {
			
			return false;
			
		}
		
	}

}
