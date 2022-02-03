package insurancedemoapp.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomobileEnterProductDataObjects {
	WebDriver driver;
	public AutomobileEnterProductDataObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="startdate")
	WebElement startDateEl;
	
	@FindBy(id="insurancesum")
	WebElement insuranceSumEl;
	
	@FindBy(id="meritrating")
	WebElement meritRatingEl;
	
	@FindBy(id="damageinsurance")
	WebElement damageInsurance;
	
	@FindBy(css="#EuroProtection + span")
	WebElement EuroProtectionEl;
	
	@FindBy(css="#LegalDefenseInsurance + span")
	WebElement LegalDefenseInsuranceEl;

	@FindBy(id="courtesycar")
	WebElement courtesycarEl;
	
	@FindBy(id= "nextselectpriceoption")
	WebElement nextSelectPriceOptionEl;
	
	@FindBy(css = "#enterproductdata span")
    WebElement enterProductDataCounter;
	
	
	
	public WebElement getEnterProductDataCounter() {
		return enterProductDataCounter;
	}


	public WebElement getStartDateEl() {
		return startDateEl;
	}


	public WebElement getInsuranceSumEl() {
		return insuranceSumEl;
	}


	public WebElement getMeritRatingEl() {
		return meritRatingEl;
	}


	public WebElement getDamageInsurance() {
		return damageInsurance;
	}


	public WebElement getEuroProtectionEl() {
		return EuroProtectionEl;
	}


	public WebElement getLegalDefenseInsuranceEl() {
		return LegalDefenseInsuranceEl;
	}


	public WebElement getCourtesycarEl() {
		return courtesycarEl;
	}


	public WebElement getNextSelectPriceOptionEl() {
		return nextSelectPriceOptionEl;
	}


	
}
