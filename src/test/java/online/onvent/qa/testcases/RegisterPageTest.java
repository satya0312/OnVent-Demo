package online.onvent.qa.testcases;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import online.onvent.qa.base.Base;
import online.onvent.qa.pageobjects.*;


public class RegisterPageTest extends Base {
	RegisterPageObjects RegisterPage;
	

	WebDriver driver;
	Random rand = new Random();
    // Generate a random number between 1 and 100 (inclusive)
	int randomNumber = rand.nextInt(9000) + 1000;

	public RegisterPageTest() {
		super();
	}

	@BeforeSuite
	public void set_up() throws Throwable {

		driver = InitOfBrowserAndNavigateToURL(LoadPropertiesFile("browsername"));
		HomePageObjects homepage = new HomePageObjects(driver);

		homepage.ClickOnAllowAllCookies();
		Thread.sleep(5000);
		homepage.ClickOnJoinAsParticipant();

	}

	//Completing the registration part 1
	@Test(priority = 1)
	public void VerifyregistrationStep1() throws InterruptedException, IOException {
		RegisterPage = new RegisterPageObjects(driver);
		RegisterPage.EnterFirstName(LoadPropertiesFile("firstName"));
		RegisterPage.EnterLastName(LoadPropertiesFile("lastName"));
	    RegisterPage.EnterEmail("testbot-swd-"+randomNumber+LoadPropertiesFile("email"));
		RegisterPage.EnterPassword(LoadPropertiesFile("password"));
		RegisterPage.ConfirmPassword(LoadPropertiesFile("password"));
		//RegisterPage.uploadProfilePicture(
		//System.getProperty("user.dir") + "\\src\\main\\java\\online\\onvent\\qa\\testdata\\ProfileImage.png");

		RegisterPage.ClickOnPrivacyCheckBox();
		RegisterPage.ClickOnSignUp();
	}
	
	
	//verifying the Email OTP
	@Test(priority = 2)
	public void VerifyEmailVerificationCode() throws InterruptedException, Throwable {
		Thread.sleep(3000);
		RegisterPage = new RegisterPageObjects(driver);
		RegisterPage.EnterOTP(LoadPropertiesFile("OTP"));
	}

	//Completing the registration part 2
	@Test(priority = 3)
	public void VerifyregistrationStep2() throws Throwable {
		RegisterPage.SelectRequiredCountry(LoadPropertiesFile("country"));
		Thread.sleep(2000);
		RegisterPage.ClickOnPrivacyCheckBoxOnStep2();
		RegisterPage.CompleteRegistration();
	}
	
	


}
