package insuranceapp.extentReports;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShots {
	
	public static String getScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+ "/resources/report/screenshots/"+System.currentTimeMillis()+".jpg";
		File destFile = new File(path);
		FileUtils.copyFile(sourceFile, destFile);
		return path;
		
	}

}
