package online.onvent.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Base {
	public static WebDriver driver;
	

	//Method to get the property value from the Config file
	public String LoadPropertiesFile(String Key) throws IOException {
		Properties prop = new Properties();
		File Propfile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\online\\onvent\\qa\\config\\Config.properties");

		FileInputStream fis = new FileInputStream(Propfile);
		prop.load(fis);
		return prop.getProperty(Key);
	}
	
	//Method to Initialize the Browser based on browser name and navigating to URL
	public WebDriver InitOfBrowserAndNavigateToURL(String browsername) throws InterruptedException {

		if (browsername.contentEquals("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.contentEquals("edge")) {
			driver = new EdgeDriver();

		}
		driver = new ChromeDriver();

		// Maximizing the Browser Window
		driver.manage().window().maximize();

		// Navigating to the Website
		try {
			driver.get(LoadPropertiesFile("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		return driver;

	}
	
	//Method to get the current date time stamp
	public String GetDatastamp() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}

}
