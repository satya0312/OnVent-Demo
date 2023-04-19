package online.onvent.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import online.onvent.qa.base.Base;
import online.onvent.qa.pageobjects.*;
import online.onvent.qa.utilities.Utilis;

public class LiveWallTest extends Base {
	String MessageintxtBox;

	LiveWallPageObjects LiveWallPage;

	public LiveWallTest() {
		super();
		
	}

	// Taking the Screenshot of LiveWall Page
	@Test(priority = 1)
	public void TakeLiveWallScreenshot() throws Throwable {
		Thread.sleep(5000);
		//LiveWallPage = new LiveWallPageObjects(driver);
		Thread.sleep(5000);
		Utilis Utilis1 = new Utilis();
		Utilis1.CaptureScreenShot(driver);

	}

	//Sending Message in LiveWall TextBox
	@Test(priority = 2)
	public void ProvideMessageInLiveWall() throws Throwable {

		LiveWallPage = new LiveWallPageObjects(driver);
		MessageintxtBox = LoadPropertiesFile("MessageInLiveWall") + " " + "[" + GetDatastamp() + "]";
		LiveWallPage.EnterMessageInLiveWall(LoadPropertiesFile("MessageInLiveWall") + " " + "[" + GetDatastamp() + "]");

	}

	//Verify the message in the LiveWall
	@Test(priority = 3)
	public void VerifyMessageInLiveWall() throws Throwable {

		String EnteredMessage = LiveWallPage
				.VerifyMessageOnWall(LoadPropertiesFile("firstName") + " " + LoadPropertiesFile("lastName"));
		Assert.assertTrue(EnteredMessage.contentEquals(MessageintxtBox),
				"The entered message and Message on live wall are different");

	}

	//Logout from the Appllication
	@Test(priority = 4)
	public void LogOutFromApplicatio() {

		LiveWallPage.ClickOnMyAccount();
		//LiveWallPage.ClickOnLogOut();
	}

}
