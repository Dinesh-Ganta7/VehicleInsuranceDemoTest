package insurancedemoapp.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TruckEnterVehicleDataObjects {
	WebDriver driver;
	public TruckEnterVehicleDataObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="make")
	WebElement makeInputEl;	
	
	@FindBy(id="engineperformance")
	WebElement enginePerormanceInputEl;
	
	@FindBy(id="dateofmanufacture")
	WebElement dateofmanufactureInpEl;
	
	@FindBy(id = "numberofseats")
	WebElement numberofseatsInpEl;
	
	@FindBy(id="fuel")
	WebElement fuelTypeInpEl;
	
	@FindBy(id="payload")
	WebElement payloadEl;
	
	@FindBy(id="totalweight")
	WebElement totalweightEl;
	
	
	@FindBy(id="listprice")
	WebElement listpriceInpEl;
	
	@FindBy(id="annualmileage")
	WebElement annualmileageInpEl;
	
	@FindBy(id="nextenterinsurantdata")
	WebElement nextenterinsurantdata;
	
	@FindBy(css = "#entervehicledata span")
    WebElement enterVehicleDataCounter;
	
	public WebElement getPayloadEl() {
		return payloadEl;
	}

	public WebElement getTotalweightEl() {
		return totalweightEl;
	}


	public WebElement getMakeInputEl() {
		return makeInputEl;
	}

	public WebElement getEnginePerormanceInputEl() {
		return enginePerormanceInputEl;
	}

	public WebElement getDateofmanufactureInpEl() {
		return dateofmanufactureInpEl;
	}

	public WebElement getNumberofseatsInpEl() {
		return numberofseatsInpEl;
	}

	public WebElement getFuelTypeInpEl() {
		return fuelTypeInpEl;
	}

	public WebElement getListpriceInpEl() {
		return listpriceInpEl;
	}

	public WebElement getAnnualmileageInpEl() {
		return annualmileageInpEl;
	}

	public WebElement getNextenterinsurantdata() {
		return nextenterinsurantdata;
	}

	public WebElement getEnterVehicleDataCounter() {
		return enterVehicleDataCounter;
	}

}
