package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.HomePage;
import pageFactory.Login;

public class TestLoginWithPageFactory {

	WebDriver driver;
	Login objLogin;
	HomePage objHomePage;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:/Software/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://petstore.octoperf.com/actions/Account.action");
	}
	
	@Test
	public void test_HomePage_Appear_Correct() {
		objLogin = new Login(driver);
		
		//verify login page text
		String loginPageMessage=objLogin.getLoginText();
		System.out.println(loginPageMessage);
		Assert.assertTrue(loginPageMessage.contains("Please enter"));
		
		//To login to application
		objLogin.loginToApplication("j2ee", "j2ee");
		//go to next pafe
		objHomePage = new HomePage(driver);
		//Verify the Home Page username
		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("ABC"));
	}
}
