package pompack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pompack.base.BasePage;
import pompack.util.Constants;

public class LoginPage extends BasePage{
	
	@FindBy(id="login_id")
	public WebElement EmailField;
	
	@FindBy(id="nextbtn")
	public WebElement NextButton;
	
	@FindBy(id="password")
	public WebElement PasswordField;
	
	@FindBy(id="nextbtn")
	public WebElement SignInButton;
	
	public LoginPage(WebDriver driver, ExtentTest etest) {
		
		this.driver = driver;
		this.etest = etest;
		
	}
	
	
	public boolean doLogin() {
		
		EmailField.sendKeys(Constants.USERNAME);
		
		etest.log(LogStatus.INFO, "Username got entered");
		
		NextButton.click();
		
		PasswordField.sendKeys(Constants.PASSWORD);
		
		etest.log(LogStatus.INFO, "Password got entered");
		
		try{
			
			SignInButton.click();
			
		}catch(Exception e) {
			
			Assert.fail("Invalid Credentials");
			
			etest.log(LogStatus.FAIL, "Invalid Credentials");
			
		}
		
		HomePage homePage = new HomePage(driver, etest);
		
		PageFactory.initElements(driver, homePage);
		
		boolean loginsuccess = homePage.verifyHomePage();
		
		if(loginsuccess) {
			
			return true;
		
		}else {
			
			return false;
			
		}
	
	}

}
