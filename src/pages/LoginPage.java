package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	By userID = By.name("uid");
	By password = By.name("password");
	By btnSubmit = By.name("btnLogin");
	By btnReset = By.name("btnReset");
	By titleText =By.className("barone");
	WebDriver driver;
	public LoginPage(WebDriver d){
		driver = d;
	}
	public void setUserName(String uname){
		driver.findElement(userID).sendKeys(uname);
	}
	
	public void setPwd(String pwd){
		driver.findElement(password).sendKeys(pwd);	
	}
	public void clickSubmit(){
		driver.findElement(btnSubmit).click();
	}
	public String getTitle(){
		return driver.findElement(titleText).getText();
	}
	public void login(String uid, String pwd){
		setUserName(uid);
		setPwd(pwd);
		clickSubmit();
		
	}
	
}
