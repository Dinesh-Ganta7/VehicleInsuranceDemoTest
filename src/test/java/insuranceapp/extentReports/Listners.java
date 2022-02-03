package insuranceapp.extentReports;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ExtentReport.ExtentReporter;

public class Listners implements ITestListener {

	ExtentTest test;
	ExtentReports rep = ExtentReporter.getExtentReport();
	WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = rep.createTest(result.getMethod().getMethodName());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");
		
		
		if(result.getMethod().getMethodName().contains("SendQuote")) {
			try {
			String successMsg = (String)result.getTestClass().getRealClass().getDeclaredField("successMsg").get(result.getInstance());
			test.log(Status.PASS, successMsg);
			}
			catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {

		// TODO Auto-generated method stub
		test.log(Status.FAIL, "Test Failed");

		String path;
		try {
			path = TakeScreenShots.getScreenshot(driver);
			test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		test.log(Status.FAIL, "Failed");

		String path;
		try {
			path = TakeScreenShots.getScreenshot(driver);
			test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		
		rep.flush();
	}
}
