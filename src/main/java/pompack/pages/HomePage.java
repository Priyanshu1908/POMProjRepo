package pompack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import pompack.base.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(css="span[class='_logo-calendar _logo-x96 zod-app-logo']")
	public WebElement Calender;
	
	@FindBy(css="Span[class='_logo-chat _logo-x96 zod-app-logo']")
	public WebElement Cliq;
	
	
	@FindBy(css="span[class='_logo-mail _logo-x96 zod-app-logo']")
	public WebElement Mail;
	
	public HomePage(WebDriver driver, ExtentTest etest) {
		
		this.driver = driver;
		
		this.etest = etest;
		
	}
	
	public boolean verifyHomePage() {
		
		return(isElementPresent(Calender));	
			
	}

}
