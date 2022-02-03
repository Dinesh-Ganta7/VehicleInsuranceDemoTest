package insurancedemoapp.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MotorcycleEnterVehicleDataObjects {
	WebDriver driver;
	public MotorcycleEnterVehicleDataObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="make")
	WebElement makeInputEl;	
	
	@FindBy(id="engineperformance")
	WebElement enginePerormanceInputEl;
	
	@FindBy(id="dateofmanufacture")
	WebElement dateofmanufactureInpEl;
	
	@FindBy(id = "numberofseatsmotorcycle")
	WebElement numberofseatsInpEl;
	
	@FindBy(id = "model")
	WebElement modelInpEl;
	
	@FindBy(id = "cylindercapacity")
	WebElement cylindercapacityEl;
	

	@FindBy(id="listprice")
	WebElement listpriceInpEl;
	
	@FindBy(id="annualmileage")
	WebElement annualmileageInpEl;
	
	@FindBy(id="nextenterinsurantdata")
	WebElement nextenterinsurantdata;
	
	@FindBy(css = "#entervehicledata span")
    WebElement enterVehicleDataCounter;
	
	
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

	public WebElement getModelInpEl() {
		return modelInpEl;
	}

	public WebElement getCylindercapacityEl() {
		return cylindercapacityEl;
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
