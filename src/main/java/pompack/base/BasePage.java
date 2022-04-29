package pompack.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

public class BasePage {
	
	public WebDriver driver = null;
	
	public ExtentTest etest = null;
	
	public boolean isElementPresent(WebElement element) {
		
		boolean displayedstatus = element.isDisplayed();
		
		if(displayedstatus) {
			
			return true;
			
		}else {
			
			return false;
		}
	}

}
