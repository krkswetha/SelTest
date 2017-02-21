package automationFramework;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Util {
	static WebDriver driver;
	
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sampangik\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
	}
	static WebDriver getFFDriver(){
		
		if(driver == null){
//			System.setProperty("webdriver.gecko.driver", "C:\\karthik\\portableApps\\PortableApps\\FirefoxPortable\\FirefoxPortable.exe");
//			File pathToBinary = new File("C:\\karthik\\portableApps\\PortableApps\\FirefoxPortable\\FirefoxPortable.exe");
//			FirefoxBinary ffbinary = new FirefoxBinary(pathToBinary);
//			FirefoxProfile ffprofile = new FirefoxProfile();
//			driver = new FirefoxDriver(ffbinary, ffprofile);
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		return driver;
		
	}
}
