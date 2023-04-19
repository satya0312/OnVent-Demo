package online.onvent.qa.pageobjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LiveWallPageObjects {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@FindBy(xpath = "//textarea[@id='newPost']")
	private WebElement EnterMessage;

	@FindBy(id = "myaccount")
	private WebElement MyAccount;

	@FindBy(xpath = "//div/p[contains(text(),'Log out')]")
	private WebElement LogOut;

	@FindBy(xpath = "//button[@class='add-new-post']")
	private WebElement NewPostBtn;
	
	@FindBy(xpath = "//div[contains(@class,'live-wall-tab')]")
	private WebElement LiveWallTab;
	
	

	public LiveWallPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void EnterMessageInLiveWall(String Message) {

		EnterMessage.click();
		EnterMessage.sendKeys(Message);
		//EnterMessage.sendKeys(Keys.ENTER);
	}

	public void ClickOnMyAccount() {
		MyAccount.click();
	}

	public void ClickOnLogOut() {
		LogOut.click();
	}
	
	public boolean CheckLiveWallDisplayed() {

		
		// Use the explicit wait to wait for the element to become visible
		wait.until(ExpectedConditions.visibilityOf(LiveWallTab));

		boolean LivewallStatus =LiveWallTab.isDisplayed();
		System.out.println("the value is displayed");
		return LivewallStatus;
	}

	public String VerifyMessageOnWall(String FullName) {
		String MessageOnWall = null;

		List<WebElement> options = driver.findElements(
				By.xpath("//*[@id=\"wall-and-network-mobile\"]/div/div[2]/div/div[2]/div[2]/div/div[1]/div"));
		for (WebElement option : options) {
			WebElement name = option.findElement(By.xpath(".//p[@class = 'long-name']"));

			if (name.getText().equalsIgnoreCase(FullName)) {
				MessageOnWall= option.findElement(By.xpath(".//div[@class = 'post-container']/p")).getText();
				System.out.println(MessageOnWall);

				break;
			}
		}
		return MessageOnWall;
	}

}
