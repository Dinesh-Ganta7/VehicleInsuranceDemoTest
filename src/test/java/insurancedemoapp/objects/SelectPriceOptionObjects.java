package insurancedemoapp.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPriceOptionObjects {
	WebDriver driver;

	public SelectPriceOptionObjects(WebDriver driver) {
		this.driver  = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="#selectsilver + span")
	WebElement silverOptionEl;  

	
	@FindBy(css="#selectgold + span")
	WebElement goldOptionEl;
	

	@FindBy(css="#selectplatinum + span")
	WebElement platinumOptionEl;
	

	@FindBy(css="#selectultimate + span")
	WebElement ultimateOptionEl;
	
	@FindBy(css="#selectpriceoption span")
	WebElement priceOptionCounter;
	
	@FindBy(id = "nextsendquote")
	WebElement nextsendquoteBtn;
	
	public WebElement getNextsendquoteBtn() {
		return nextsendquoteBtn;
	}


	public WebElement getPriceOptionCounter() {
		return priceOptionCounter;
	}


	public WebElement getSilverOptionEl() {
		return silverOptionEl;
	}


	public WebElement getGoldOptionEl() {
		return goldOptionEl;
	}


	public WebElement getPlatinumOptionEl() {
		return platinumOptionEl;
	}


	public WebElement getUltimateOptionEl() {
		return ultimateOptionEl;
	}


	
	
	
	
}
