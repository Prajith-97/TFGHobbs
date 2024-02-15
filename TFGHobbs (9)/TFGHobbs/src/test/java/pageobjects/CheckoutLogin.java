package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutLogin {

	WebDriver driver;

	public CheckoutLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Continue Securely']")
	public WebElement continueSecurelyBtn;

	@FindBy(how = How.XPATH, using = "//form[@name='login-form']//following-sibling::a[contains(text(),'Checkout as guest')]")
	public WebElement checkoutAsGuestBtn;

	@FindBy(how = How.XPATH, using = "//*[@id='ext-gen44']//*[@class='page-title']")
	public WebElement GoToYourAccountPage;

	@FindBy(how = How.XPATH, using = "//*[contains(@id,'deliver-component')]//a[contains(@class,'CloseButton')]")
	public WebElement closeBtn;

	@FindBy(how = How.XPATH, using = "//input[@id='login-form-email']")
	public WebElement inputEmail;

	@FindBy(how = How.XPATH, using = "//input[@id='login-form-password']")
	public WebElement inputPassword;

	@FindBy(how = How.XPATH, using = "//input[@id='usePassword-yes']")
	public WebElement passwordRadioBtn;

	@FindBy(how = How.XPATH, using = "//button[text()='Log in and save time']")
	public WebElement loginAndSaveTimeBtn;

	@FindBy(how = How.XPATH, using = "//div[@class='invalid-feedback' and text()='Please enter a valid email address']")
	public WebElement emailError;

	@FindBy(how = How.XPATH, using = "//li[@class='error-summary__message ']")
	public WebElement errormesssage;

	@FindBy(how = How.XPATH, using = "//label[@class='label custom-control-label' and contains(text(),'Continue as guest')]")
	public WebElement continueasguest;
}
