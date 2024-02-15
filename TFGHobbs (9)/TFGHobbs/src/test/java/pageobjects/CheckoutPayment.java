package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPayment {

	WebDriver driver;

	public CheckoutPayment(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement PaymentMethod(String paymentType) {
		return driver.findElement(
				By.xpath("//input[contains(@id,'paymentMethod')]//following::p[text()='" + paymentType + "']"));
	}

	@FindBy(how = How.XPATH, using = "//iframe[contains(@id,'flex-microform-')]")
	public WebElement iframeCreditCardNumber;

	@FindBy(how = How.XPATH, using = "//input[@name='credit-card-number']")
	public WebElement inputCreditCardNumber;

	@FindBy(how = How.XPATH, using = "//input[@id='cardOwner']")
	public WebElement inputNameOnCard;

	@FindBy(how = How.XPATH, using = "//input[@id='expirationDate']")
	public WebElement inputCardExpiryDate;

	@FindBy(how = How.XPATH, using = "//input[@id='securityCode']")
	public WebElement inputSecurityCode;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']//span[contains(text(),'Place Order & Pay Securely')]")
	public WebElement placeOrderAndPaySecurelyBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"dwfrm_billing\"]/fieldset[2]/div/div[2]/button")
	public WebElement placeOrderAndPaySecurelyBtn1;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'paymentMethod')]//following::p[text()='Gift Card']")
	public WebElement giftCard;

	@FindBy(how = How.ID, using = "giftCardNumber")
	public WebElement giftCardNumber;

	@FindBy(how = How.ID, using = "pin")
	public WebElement giftCardPin;

	@FindBy(how = How.XPATH, using = "//button[text()='Verify card']")
	public WebElement verifyGiftCard;

	@FindBy(how = How.ID, using = "amount")
	public WebElement GiftCardAmount;

	@FindBy(how = How.XPATH, using = "//*[@id=\"dwfrm_giftcard\"]/div/div[2]/div[2]/div/div/div[1]")
	public WebElement giftCardinvalidamountfeedback;

	@FindBy(how = How.XPATH, using = "//button[@name='redeem']")
	public WebElement redeemCard;

	@FindBy(how = How.XPATH, using = "//input[@id='savedCardSecurityCode']")
	public WebElement inputSavedCardSecurityCode;

	@FindBy(how = How.XPATH, using = "//*[@id='dwfrm_billing_creditCardFields_saveCard']")
	public WebElement savecarddetailscheckbox;

	public WebElement CardEnding(String cardEndingNumber) {
		return driver.findElement(By.xpath(
				"(//select[@id='savedCards']//following::span[contains(text(),'" + cardEndingNumber + "')])[1]"));
	}

	public WebElement CardExpiry(String cardExpiry) {
		return driver.findElement(
				By.xpath("(//select[@id='savedCards']//following::span[contains(text(),'" + cardExpiry + "')])[1]"));
	}

	public By amount() {
		By element = By.id("amount");
		return element;

	}

	@FindBy(how = How.XPATH, using = "//div[@class='col-12 saved-cards__container']//select[@id='savedCards']")
	public WebElement savedCard;
}
