package insurancedemoapp.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterInsuranceDataObjects {
	WebDriver driver;
	public EnterInsuranceDataObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstname")
	WebElement firstnameEl;
	
	@FindBy(id="lastname")
	WebElement lastnameEl;
	
	@FindBy(id="birthdate")
	WebElement birthdateEl;
	
	@FindBy(id="country")
	WebElement countryEl;
	
	@FindBy(id="zipcode")
	WebElement zipcodeEl;
	
	@FindBy(id="occupation")
	WebElement occupationEl;

	@FindBy(css="#speeding + span")
	WebElement speedingEl;
	
	@FindBy(css="#skydiving + span")
	WebElement skydivingEl;
	
	@FindBy(css="#bungeejumping + span")
	WebElement bungeeJumpingEl;
	
	@FindBy(css="#cliffdiving + span")
	WebElement cliffDivingEl;
	
	@FindBy(css="#other + span")
	WebElement otherEl;
	
	@FindBy(id= "nextenterproductdata")
	WebElement nextEnterProductDataEl;
	
	@FindBy(css = "#enterinsurantdata span")
    WebElement enterInsuranceDataCounter;
	
	public WebElement getEnterInsuranceDataCounter() {
		return enterInsuranceDataCounter;
	}


	public WebElement getFirstnameEl() {
		return firstnameEl;
	}


	public WebElement getLastnameEl() {
		return lastnameEl;
	}


	public WebElement getBirthdateEl() {
		return birthdateEl;
	}


	public WebElement getCountryEl() {
		return countryEl;
	}


	public WebElement getZipcodeEl() {
		return zipcodeEl;
	}


	public WebElement getOccupationEl() {
		return occupationEl;
	}


	public WebElement getSpeedingEl() {
		return speedingEl;
	}


	public WebElement getSkydivingEl() {
		return skydivingEl;
	}


	public WebElement getBungeeJumpingEl() {
		return bungeeJumpingEl;
	}


	public WebElement getCliffDivingEl() {
		return cliffDivingEl;
	}


	public WebElement getOtherEl() {
		return otherEl;
	}


	public WebElement getNextEnterProductDataEl() {
		return nextEnterProductDataEl;
	}

	
	
	
}
