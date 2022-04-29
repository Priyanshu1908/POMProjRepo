package pompack.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pompack.base.BaseTest;
import pompack.pages.LaunchPage;
import pompack.util.Constants;

public class LoginTest extends BaseTest {
	
	@Test
	public void testLogin() {
		
		openBrowser(Constants.BROWSER_TYPE);
		
		LaunchPage launchPage = new LaunchPage(driver, etest);
		
		PageFactory.initElements(driver, launchPage);
		
		boolean teststatus = launchPage.gotoLoginPage();
		
		if(teststatus) {
			
			reportPass();
			
		}else {
			
			reportFail();
		
		}

	}
	
	@AfterMethod
	public void testClosure() {
		
		if(ereport!=null) {
		
			ereport.endTest(etest);
			ereport.flush();
		}
		
		if(driver!=null) {
			
			driver.close();
		}
	}

}