package insurancedemoapp.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendQuoteObjects {
	
	WebDriver driver;

	public SendQuoteObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement emailElement;
	
	@FindBy(id="username")
	WebElement usernameElement;
	
	@FindBy(id="password")
	WebElement passwordElement;
	
	@FindBy(id="confirmpassword")
	WebElement confirmpasswordElement;
	
	@FindBy(css="#sendquote span")
	WebElement sendQuoteCounter;
	
	@FindBy(id="sendemail")
	WebElement sendemailBtn;
	
	@FindBy(xpath = "//h2[text() = 'Sending e-mail success!']")
	WebElement successTextEl;

	public WebElement getSuccessTextEl() {
		return successTextEl;
	}

	public WebElement getEmailElement() {
		return emailElement;
	}

	public WebElement getUsernameElement() {
		return usernameElement;
	}

	public WebElement getPasswordElement() {
		return passwordElement;
	}

	public WebElement getConfirmpasswordElement() {
		return confirmpasswordElement;
	}

	public WebElement getSendQuoteCounter() {
		return sendQuoteCounter;
	}

	public WebElement getSendemailBtn() {
		return sendemailBtn;
	}
	
	

}
