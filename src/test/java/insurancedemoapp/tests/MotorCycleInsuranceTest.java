package insurancedemoapp.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import framework.DriverFactory;
import framework.ReadExcelData;
import insurancedemoapp.objects.AutomobileEnterProductDataObjects;
import insurancedemoapp.objects.EnterInsuranceDataObjects;
import insurancedemoapp.objects.InsuranceAppHomePageObjects;
import insurancedemoapp.objects.MotorcycleEnterVehicleDataObjects;
import insurancedemoapp.objects.SelectPriceOptionObjects;
import insurancedemoapp.objects.SendQuoteObjects;

public class MotorCycleInsuranceTest {
	public WebDriver driver;

	SoftAssert softAssert = new SoftAssert();

	WebDriverWait wait;
	String parentWindowHandle;
	public String successMsg;
	
	DriverFactory remoteDriver = new DriverFactory();

	@Parameters("browserName")
	@BeforeTest
	public void initializeDriver(@Optional("Chrome") String browserName) {
		driver = remoteDriver.initializeDriver(browserName);
		driver.get("http://sampleapp.tricentis.com/");
		parentWindowHandle = driver.getWindowHandle();
	}

	@Test(dataProvider = "motorcycleVehicleData", priority = 11)
	public void motorcycleEnterVehicleData(String[] data) {

		String make = data[0];
		String enginePerformance = data[1];
		String dateOfManufacture = data[2].split(",")[1];
		String noOfSeats = Integer.toString((int) Double.parseDouble(data[3]));
		String listPrice = data[5];
		String annualMileage = data[6];
        String model = data[4];
		String cylinderCapacity = Integer.toString((int) Double.parseDouble(data[7]));

		InsuranceAppHomePageObjects home = new InsuranceAppHomePageObjects(driver);
		MotorcycleEnterVehicleDataObjects vehicleData = new MotorcycleEnterVehicleDataObjects(driver);

		home.getNavMotorcycleEl().click();

		Select selectMake = new Select(vehicleData.getMakeInputEl());
		selectMake.selectByValue(make);

		vehicleData.getEnginePerormanceInputEl().sendKeys(enginePerformance);

		vehicleData.getDateofmanufactureInpEl().sendKeys(dateOfManufacture);

		Select noOfSeatsSelect = new Select(vehicleData.getNumberofseatsInpEl());
		noOfSeatsSelect.selectByValue(noOfSeats);

		Select fuelTypeModel = new Select(vehicleData.getModelInpEl());
		fuelTypeModel.selectByValue(model);

		
		vehicleData.getCylindercapacityEl().sendKeys(cylinderCapacity);

		vehicleData.getListpriceInpEl().sendKeys(listPrice);

		vehicleData.getAnnualmileageInpEl().sendKeys(annualMileage);

		Assert.assertTrue(vehicleData.getEnterVehicleDataCounter().getText().equals("0"),
				"vehicle data not entered correctly");
		vehicleData.getNextenterinsurantdata().click();

	}

	@DataProvider(name = "motorcycleVehicleData")
	public Object[][] motorcycleVehicleData() throws IOException {
		String filePath = "./src/test/resources/insuranceDemoAppData.xlsx";
		Object[][] data = ReadExcelData.getExcelData(filePath, "motorcycleVehicleData");

		return data;

	}

	@Test(dataProvider = "motorcycleInsuranceData", priority = 12)
	public void motorcycleEnterInsuranceData(String[] data) {
		EnterInsuranceDataObjects insurance = new EnterInsuranceDataObjects(driver);
		String firstName = data[0];
		String lastName = data[1];
		String dateOfBirth = data[2].split(",")[1];
		String country = data[5];
		String zipCode = Integer.toString((int) Double.parseDouble(data[6]));
		String occupation = data[8];
		String hobbies[] = data[9].split(",");

		insurance.getFirstnameEl().sendKeys(firstName);
		insurance.getLastnameEl().sendKeys(lastName);
		insurance.getBirthdateEl().sendKeys(dateOfBirth);

		Select countrySelect = new Select(insurance.getCountryEl());
		countrySelect.selectByValue(country);

		insurance.getZipcodeEl().sendKeys(zipCode);

		Select occupationSelect = new Select(insurance.getOccupationEl());
		occupationSelect.selectByValue(occupation);

		for (String hobby : hobbies) {

			if (hobby.equals("Bungee Jumping")) {
				wait = new WebDriverWait(driver, Duration.ofMillis(5000));
				insurance.getBungeeJumpingEl().click();
			}
			if (hobby.equals("Other")) {
				insurance.getOtherEl().click();
			}
			if (hobby.equals("Cliff Diving")) {
				insurance.getBirthdateEl().click();
			}
		}
		Assert.assertTrue(insurance.getEnterInsuranceDataCounter().getText().equals("0"),
				"Insurance data not entered correctly");
		insurance.getNextEnterProductDataEl().click();

	}

	@DataProvider(name = "motorcycleInsuranceData")
	public Object[][] motorcycleVehicleDataInsuranceData() throws IOException {
		String filePath = "./src/test/resources/insuranceDemoAppData.xlsx";
		Object[][] data = ReadExcelData.getExcelData(filePath, "automobileInsuranceData");

		return data;

	}

	@Test(dataProvider = "motorcycleProductData", priority = 13)
	public void motorcycleEnterProductData(String[] data) {
		AutomobileEnterProductDataObjects product = new AutomobileEnterProductDataObjects(driver);
		String startDate = data[0];
		String insuranceSum = data[1];
		String damageInsurance = data[3];
		String[] optionalProducts = data[4].split(",");

		product.getStartDateEl().sendKeys(startDate);
		Select insuranceSumSelect = new Select(product.getInsuranceSumEl());
		insuranceSumSelect.selectByVisibleText(insuranceSum);

		Select damageInsuranceSelect = new Select(product.getDamageInsurance());
		damageInsuranceSelect.selectByValue(damageInsurance);

		for (String option : optionalProducts) {
			if (option.equals("Euro Protection")) {
				product.getEuroProtectionEl().click();
			} else {
				product.getLegalDefenseInsuranceEl().click();
			}
		}

		Assert.assertTrue(product.getEnterProductDataCounter().getText().equals("0"),
				"Product data not entered correctly");

		product.getNextSelectPriceOptionEl().click();

	}

	@DataProvider(name = "motorcycleProductData")
	public Object[][] motorcycleProductData() throws IOException {
		String filePath = "./src/test/resources/insuranceDemoAppData.xlsx";
		Object[][] data = ReadExcelData.getExcelData(filePath, "automobileProductData");

		return data;

	}

	@Test(dataProvider = "motorcyclePriceOptionData", priority = 14)
	public void motorcycleSelectPriceOption(String[] data) throws InterruptedException {
		SelectPriceOptionObjects price = new SelectPriceOptionObjects(driver);

		String priceOption = data[0];

		if (priceOption.equals("Silver")) {
			price.getSilverOptionEl().click();
		}
		if (priceOption.equals("Gold")) {
			price.getGoldOptionEl().click();
		}
		if (priceOption.equals("Platinum")) {
			price.getPlatinumOptionEl().click();
		} else {
			price.getUltimateOptionEl().click();
		}

		Assert.assertTrue(price.getPriceOptionCounter().getText().equals("0"), "Price Option not selected");

		wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(price.getNextsendquoteBtn()));

		price.getNextsendquoteBtn().click();

	}

	@DataProvider(name = "motorcyclePriceOptionData")
	public Object[][] motorcyclePriceOptionData() throws IOException {
		String filePath = "./src/test/resources/insuranceDemoAppData.xlsx";
		Object[][] data = ReadExcelData.getExcelData(filePath, "automobilePriceOptionData");

		return data;

	}

	@Test(dataProvider = "motorcycleSendQuoteData", priority = 15)
	public void motorcycleSendQuote(String[] data) throws InterruptedException {
		String email = data[0];
		String username = data[2];
		String password = data[3];
		String confirmPassword = data[4];
		SendQuoteObjects quote = new SendQuoteObjects(driver);
		quote.getEmailElement().sendKeys(email);
		quote.getUsernameElement().sendKeys(username);
		quote.getPasswordElement().sendKeys(password);
		quote.getConfirmpasswordElement().sendKeys(confirmPassword);
		Assert.assertTrue(quote.getSendQuoteCounter().getText().equals("0"), "Quote didn't Sent");
		quote.getSendemailBtn().click();

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		successMsg = quote.getSuccessTextEl().getText();
		Assert.assertTrue(!successMsg.equals(null), "Sending Quote Failed!");

	}

	@DataProvider(name = "motorcycleSendQuoteData")
	public Object[][] motorcycleSendQuoteData() throws IOException {
		String filePath = "./src/test/resources/insuranceDemoAppData.xlsx";
		Object[][] data = ReadExcelData.getExcelData(filePath, "automobileSendQuoteData");
		
		return data;

	}

	@AfterTest
	public void teardown() {
		remoteDriver.tearDown(driver);
	}

}
