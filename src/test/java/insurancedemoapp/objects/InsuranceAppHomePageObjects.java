package insurancedemoapp.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsuranceAppHomePageObjects {
    WebDriver driver;
    
    public InsuranceAppHomePageObjects(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(id = "nav_automobile")
    WebElement navAutomobileEl;
    
    @FindBy(id = "nav_truck")
    WebElement navTruckEl;
    
    @FindBy(id = "nav_motorcycle")
    WebElement navMotorcycleEl;
    
    @FindBy(id = "nav_camper")
    WebElement navCamperEl;

	public WebElement getNavAutomobileEl() {
		return navAutomobileEl;
	}

	public WebElement getNavTruckEl() {
		return navTruckEl;
	}

	public WebElement getNavMotorcycleEl() {
		return navMotorcycleEl;
	}

	public WebElement getNavCamperEl() {
		return navCamperEl;
	}
    
    
}
