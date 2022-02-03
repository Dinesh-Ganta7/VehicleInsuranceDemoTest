package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports extent;
	
	public static ExtentReports getExtentReport() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+ "\\resources\\report\\index.html");
		spark.config().setReportName("Insurance Demo App Test Report");
		spark.config().setDocumentTitle("Insurance Demo App Test Report");
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Dinesh.G");
		extent.setSystemInfo("WebSite Name", "Vehicle Insurance Application");
		extent.setSystemInfo("WebPage Url", "http://sampleapp.tricentis.com/101/app.php");
		return extent;
		
	}

}
