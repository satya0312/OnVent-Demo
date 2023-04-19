package online.onvent.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObjects {
	WebDriver driver;

	String COUNTRY_OPTION_XPATH = "//ul[contains(@class,'MuiList-root')]/li";

	@FindBy(name = "first")
	private WebElement EnterFirstName;

	@FindBy(name = "last")
	private WebElement EnterLastName;

	@FindBy(name = "email")
	private WebElement EnterEmail;

	@FindBy(name = "password")
	private WebElement EnterPassword;

	@FindBy(name = "passwordConfirmation")
	private WebElement ConfirmPassword;

	@FindBy(xpath = "//input[@class='jss8' and @type='checkbox']")
	private WebElement PrivacyCheckBox;

	@FindBy(xpath = "//button[@class='register-button']")
	private WebElement SignUpButton;

	@FindBy(xpath = "//input[@class='jss16' and @type='checkbox']")
	private WebElement PrivacyCheckBoxOnStep2;
	
	@FindBy(xpath = "//div[@class='upload-image']")
	private WebElement UplaodFilebtn;

	@FindBy(xpath = "//button[contains(text(),'Complete Registration')]")
	private WebElement CompleteRegistBtn;

	@FindBy(xpath = "//div[contains(@class,'MuiSelect-root') and contains(@id,'mui-component')]")
	private WebElement CountryDropDown;

    @FindBy(xpath = "//input[@type='file']")
	WebElement uploadProfilePicture;
    
    @FindBy(xpath = "//input[@type='text']")
   	WebElement EnterOTP;

	public RegisterPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void EnterFirstName(String FirstName) {
		EnterFirstName.sendKeys(FirstName);

	}

	public void EnterLastName(String LastName) {
		EnterLastName.sendKeys(LastName);
	}

	public void EnterEmail(String Email) {
		EnterEmail.sendKeys(Email);
	}

	public void EnterPassword(String Password) {
		EnterPassword.sendKeys(Password);
	}

	public void ConfirmPassword(String Password) {
		ConfirmPassword.sendKeys(Password);
	}

	public void ClickOnPrivacyCheckBox() {
		PrivacyCheckBox.click();
	}

	public void ClickOnSignUp() {
		SignUpButton.click();
	}

	public void ClickOnPrivacyCheckBoxOnStep2() {
		PrivacyCheckBoxOnStep2.click();
	}

	public void CompleteRegistration() {
		CompleteRegistBtn.click();
	}
	
	public void UploadProfilePicture() {
		UplaodFilebtn.sendKeys("C:\\Users\\Satya\\Desktop\\test.txt");
	}

	public void uploadProfilePicture(String pathOfTheProfilePicture) {
		uploadProfilePicture.sendKeys(pathOfTheProfilePicture);
	}
	
	public void EnterOTP(String OTP) {
		EnterOTP.sendKeys(OTP);
	}

	public void SelectRequiredCountry(String Country) throws InterruptedException {
		CountryDropDown.click();
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.xpath(COUNTRY_OPTION_XPATH));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(Country)) {
				option.click();
				break;
			}

		}

	}
}
