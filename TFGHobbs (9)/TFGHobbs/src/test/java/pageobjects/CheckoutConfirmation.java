package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutConfirmation {

	WebDriver driver;

	public CheckoutConfirmation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//iframe[contains(@id,'Cardinal-CCA-IFrame')]")
	public WebElement form; 
	
	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,' Enter Code Here')]")
			//"input[@placeholder='Enter Code Here']")
	public WebElement inputOTPNumber;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'content')]//input[@value='SUBMIT']")
	public WebElement confirmSubmit;
	
	@FindBy(how = How.XPATH, using = "//*[@id='root']//span[text()='Thank you for your order!']")
	public WebElement orderConfirmation;

	@FindBy(how = How.XPATH, using = "//div[@id='root']//button[@type='button']")
	public WebElement closeOrderConfirmationPopupBtn;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Log Out')]")
	public WebElement LogOutBtn;

	// .....p2_desktop_guestcustomer checkout.....................................

	@FindBy(how = How.XPATH, using = "//input[@id='newPassword']")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@id='newPasswordConfirm']")
	public WebElement confirmPassword;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Create Account')]")
	public WebElement createGuestaccount;
//	@FindBy(how = How.XPATH, using = "//div[@class='confirmation__login-form mt-4']//label[contains(text(),'Confirm Password*')]//following::div[contains(text(),'Please lengthen this text to 8 characters or more (you are currently using 3 characters).')]")
//	public WebElement passwordError;
	
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'confirmation__login-form mt-4')]//div[@class='invalid-feedback'])[1]")
	public WebElement passwordError;
	
	@FindBy(how = How.XPATH, using = "//div[@class='checkout-step__errors mb-4']//li[@class='error-summary__message ']")
	public WebElement CreditcardError;
}
