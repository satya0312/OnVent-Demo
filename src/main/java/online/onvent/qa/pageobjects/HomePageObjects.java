package online.onvent.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	WebDriver driver;

	// 'Join As Participant' Web Element
	@FindBy(xpath = "//div[@class='bottom-links-container']//span[text()='Join as participant']")
	private WebElement JoinAsParticipantBtn;

	@FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
	private WebElement AllowAllCookies;
	
	
	
	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Click on Allow All Cookies button
	public void ClickOnAllowAllCookies() {

		AllowAllCookies.click();

	}
	//Click on 'JoinAsParticipant' button
	public void ClickOnJoinAsParticipant() {
		JoinAsParticipantBtn.click();

	}

}
