package pageobjects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutDelivery {

	WebDriver driver;

	public CheckoutDelivery(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//a[@role='tab']//div)[2]")
	public WebElement deliveryRadioBtn;

	@FindBy(how = How.XPATH, using = "//input[@id='shippingMethod-STD']//parent::div")
	public WebElement standardDeliveryMethod;

	@FindBy(how = How.XPATH, using = "//input[@name='dwfrm_shipping_shippingAddress_shippingMethodID']")
	public WebElement defaultDeliveryMethod;
	
	@FindBy(how = How.XPATH, using = "//p[@class='checkout-shipping__method-name']")
	public WebElement existingDeliveryMethod;
	
//	@FindBy(how = How.XPATH, using = "//input[@id='shippingMethod-USASTD']//parent::div")
//	public WebElement defaultDeliveryMethod;

	public WebElement shippingMethod(String Method) {
		return driver.findElement(
				By.xpath("//*[@class='checkout-shipping__methods']//p[contains(text(),'" + Method + "')]"));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='title']")
	public WebElement dropdownTitle;

	public WebElement CustomerTitle(String title) {
		return driver.findElement(By.xpath("//*[@id='title']//option[contains(text(),'" + title + "')]"));
	}

	@FindBy(how = How.XPATH, using = "//select[@id='title']")
	public WebElement Title;
	@FindBy(how = How.XPATH, using = "//div[@class='address-fields row']//input[@id='firstName']")
	public WebElement inputFirstName;

	@FindBy(how = How.XPATH, using = "//div[@class='address-fields row']//input[@id='lastName']")
	public WebElement inputLastName;

	@FindBy(how = How.XPATH, using = "//div[@class='address-fields row']//input[@id='phoneNumber']")
	public WebElement inputMobileNumber;

	@FindBy(how = How.XPATH, using = "//div[@class='address-fields row']//input[@id='addressOne']")
	public WebElement inputAddressLineOne;

	@FindBy(how = How.XPATH, using = "//div[@class='address-fields row']//input[@id='addressTwo']")
	public WebElement inputAddressLineTwo;

	@FindBy(how = How.XPATH, using = "//div[@class='address-fields row']//input[@id='addressThree']")
	public WebElement inputAddressLineThree;

	@FindBy(how = How.XPATH, using = "//div[@class='address-fields row']//select[@id='stateCode']")
	public WebElement inputState;

	@FindBy(how = How.XPATH, using = "//div[@class='address-fields row']//input[@id='city']")
	public WebElement inputCity;

	@FindBy(how = How.XPATH, using = "//div[@class='address-fields row']//input[@id='postalCode']")
	public WebElement inputPostalCode;

	@FindBy(how = How.ID, using = "country")
	public WebElement dropdownCountry;

	@FindBy(how = How.XPATH, using = "//div[@id='address-content']//a[@class='address-lookup__toggle']")
	public WebElement enterAddressManually;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue to Payment')]")
	public WebElement continueToPaymentBtn;

	@FindBy(how = How.XPATH, using = "(//div[@class='address-summary']//span[contains(@class,'title')])[1]")
	public WebElement savedCustomerTitle;

	@FindBy(how = How.XPATH, using = "(//div[@class='address-summary']//span[contains(@class,'firstName')])[1]")
	public WebElement savedCustomerFirstName;

	@FindBy(how = How.XPATH, using = "(//div[@class='address-summary']//span[contains(@class,'lastName')])[1]")
	public WebElement savedCustomerLastName;

	@FindBy(how = How.XPATH, using = "(//div[@class='address-summary']//span[contains(@class,'address1')])[1]")
	public WebElement savedAddressOne;

	@FindBy(how = How.XPATH, using = "(//div[@class='address-summary']//span[contains(@class,'address2')])[1]")
	public WebElement savedAddressTwo;

	@FindBy(how = How.XPATH, using = "(//div[@class='address-summary']//span[contains(@class,'address3')])[1]")
	public WebElement savedAddressThree;

	@FindBy(how = How.XPATH, using = "(//div[@class='address-summary']//div[contains(@class,'city')])[1]")
	public WebElement savedCity;

	@FindBy(how = How.XPATH, using = "(//div[@class='address-summary']//div[contains(@class,'postalCode')])[1]")
	public WebElement savedPostalCode;

	@FindBy(how = How.XPATH, using = "//*[@id='dwfrm_shipping_shippingAddress_addressFields_saveAddress']")
	public WebElement savedeliveraddresscheckbox;

	public void StandardDeliveryMethodClick() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", standardDeliveryMethod);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='saved-addresses__new']//i[@class='font-icon icon-chevron-down saved-addresses__new-toggle__icon saved-addresses__new-toggle__icon--expanded']")
	public WebElement newAddress;

	public By addressinput1() {

		By element = By.xpath("//div[@class='address-fields row']//input[@id='addressOne']");
		return element;

	}

	public List<WebElement> deliveryMethodList() {
		return driver.findElements(By.xpath("//*[@id=\"address-content\"]/div/fieldset[2]/div/div/label"));
	}

}
