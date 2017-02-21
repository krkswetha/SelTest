package automationFramework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TC1Login {
	WebDriver driver;
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", Constants.chromePath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.baseUrl);
	}
	@Test(priority=0, dataProvider="dataprovider")
	
	public void login_test_success(String uid, String pwd) 
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(uid,pwd);
		//loginPage.login("mngr66605", "pyrErum");
		HomePage homePage = new HomePage(driver);
		//File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Assert.assertTrue(homePage.getTitle().toLowerCase().contains("guru99 bank"));
//		try {
//			FileUtils.copyFile(src, new File("c:\\tmp\\"+uid+pwd));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	@Test(priority=0, dataProvider="dataprovider")
	public void login_test_fail(String uid, String pwd){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(uid,pwd);
		//loginPage.login("mngr66605", "k");
		Alert alert = driver.switchTo().alert();
		// Get the text of the alert or prompt
		Assert.assertTrue(alert.getText().equalsIgnoreCase(Constants.loginFailErrorMsg));  
		// And acknowledge the alert (equivalent to clicking "OK")
		//File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		alert.accept();
//		try {
//			FileUtils.copyFile(src, new File("c:\\tmp\\"+uid+pwd));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
	@AfterTest
	public void kill()
	{
	driver.close();
	}
	@DataProvider(name="dataprovider")
	public Object[][] getData(Method m)
	{
		if(m.getName().equalsIgnoreCase("login_test_success")){
			return new Object[][] {{"mngr66605", "pyrErum"}};
		} else
		{
			return new Object[][] {
				{"mngr66605", "swetha"},
				{"mngr66605", "1"},
				{"mngr66605", "2"},
				{"mngr66605", "3"},
				{"mngr66605", "4"},
				{"mngr66605", "5"}
			};
			
		}
	}
//	public static void main(String[] s){
//		System.setProperty("webdriver.gecko.driver", "C:\\karthik\\installs\\firefox\\firefox.exe");
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sampangik\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();//Util.getFFDriver();
//		String baseUrl = "http://www.demo.guru99.com/V4/";
//		driver.get(baseUrl);
//		
//		By userName = By.name("uid");
//		By pwd = By.name("password");
//		By btnSubmit = By.name("btnLogin");
//		By btnReset = By.name("btnReset");
//		
//		driver.findElement(userName).sendKeys("mngr66605");
//		driver.findElement(pwd).sendKeys("pyrErum");
//		driver.findElement(btnSubmit).click();
//	}
}
