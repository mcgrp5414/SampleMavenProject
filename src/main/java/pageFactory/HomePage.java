package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	@FindBy(xpath="//div[@id='WelcomeContent']")
	WebElement homePageUserName;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Get the username from the Homepage
	public String getHomePageDashboardUserName() {
		return homePageUserName.getText();
	}
}
