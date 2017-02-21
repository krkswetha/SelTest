package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	By titleText =By.className("barone");
	WebDriver driver;
	public HomePage(WebDriver d){
		driver = d;
	}
	public String getTitle(){
		return driver.findElement(titleText).getText();
	}
}
