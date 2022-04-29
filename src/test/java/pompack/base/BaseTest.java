package pompack.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;
import pompack.util.Constants;
import pompack.util.ExtentManager;

public class BaseTest {
	
	public WebDriver driver = null;
	
	public ExtentReports ereport = ExtentManager.getInstance();;
	
	public ExtentTest etest = ereport.startTest("LoginTest");
	
	public void openBrowser(String browserType) {
		
		etest.log(LogStatus.INFO, "Opening browser " + browserType);
		
		if(browserType.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_EXE);
			
			driver = new ChromeDriver();
			
		}else if(browserType.equalsIgnoreCase("firefox")) {
				
			System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_EXE);				
				
			driver = new FirefoxDriver();
		
		}else if(browserType.equalsIgnoreCase("ie")) {
			
			System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_EXE);
			
			driver = new InternetExplorerDriver();
			
		}
		
		etest.log(LogStatus.INFO, browserType + " browser got opened");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void reportPass() {
		
		etest.log(LogStatus.PASS, "Login Test Passed");
		
		takesScreenshot();
		
	}
	
	public void reportFail() {
		
		etest.log(LogStatus.FAIL, "Login Test Failed");
		
		Assert.fail("Login Test Failed");
		
		takesScreenshot();
		
	}
	
	public void takesScreenshot() {
		
		Date d = new Date();
		
		String filename = d.toString().replace(" ", "_").replace(":", "_")+".jpg";
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
		FileUtils.copyFile(srcFile, new File("screenshots//"+filename));
		
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		etest.log(LogStatus.INFO, "Screenshot -> " + etest.addScreenCapture(System.getProperty("user.dir")) + "screenshots//"+ filename);
	}

}
