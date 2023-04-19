package online.onvent.qa.utilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.io.FileHandler;

public class Utilis {
	
	public static String GetCurrentDatastamp() {
		Date date =new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss");
	    return formatter.format(date);
	}
	
public void CaptureScreenShot(WebDriver driver) {
		
		File scrScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String DestinationScreenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" +"First_[" + GetCurrentDatastamp()+"]"+ ".png";
		try {
			FileHandler.copy(scrScreenShot, new File(DestinationScreenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
