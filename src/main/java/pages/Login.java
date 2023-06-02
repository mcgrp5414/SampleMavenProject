package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	WebDriver driver;
	By user = By.name("username");
	By password=By.name("password");
	By message=By.xpath("//p[contains(text(),'Please enter')]");
	By login = By.name("signon");
	
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	
	//set the username in textbox
	public void setUserName(String strUserName) {
		driver.findElement(user).sendKeys(strUserName);
	}
	
	//set the password in textbox
	public void setPassword(String strPassword) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(strPassword);
	}
	
	//Click on Login button
	public void clickLogin() {
		driver.findElement(login).click();
	}
	
	//get the message of login page
	public String getLoginText() {
		return driver.findElement(message).getText();
	}
	
	// this POM method will be used in test cases to do the login
	public void loginToApplication(String strUserName,String strPassword) {
		//fill user name
		this.setUserName(strUserName);
		this.setPassword(strPassword); //to fill password
		this.clickLogin(); // to click login button
	}
}
