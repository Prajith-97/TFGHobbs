package stepdefs;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Basket;
import pageobjects.CheckoutDelivery;
import pageobjects.CheckoutPayment;
import pageobjects.HomePage;
import utility.WebDriverManagedef;
import utility.WebDriverManagerAppium;

public class CheckoutPaymentStepDefinition {
	WebDriver driver = HomePageStepDefinition.driver;
	HomePage homePage;
	CheckoutPayment checkoutPayment = new CheckoutPayment(driver);
	WebDriverManagedef webdef = new WebDriverManagedef();

	@Test
	@Then("user is on payment page")
	public void user_is_on_payment_page() throws Throwable {
		try {
		Assert.assertTrue(checkoutPayment.placeOrderAndPaySecurelyBtn.isDisplayed());
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@When("user selects <PaymentType> payment method")
	public void user_selects_payment_type_payment_method(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {		
		webdef.waitvisibilityof(driver, checkoutPayment.PaymentMethod(dataTable.cell(1, 0)), 20);
		webdef.JsClick(checkoutPayment.PaymentMethod(dataTable.cell(1, 0)), driver);
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@When("user enters the credit card details")
	public void user_enters_the_credit_card_details(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			Thread.sleep(2000);
			driver.switchTo().frame(checkoutPayment.iframeCreditCardNumber);
			if (checkoutPayment.inputCreditCardNumber.isDisplayed()) {
				checkoutPayment.inputCreditCardNumber.sendKeys(dataTable.cell(1, 0));
				driver.switchTo().defaultContent();
				checkoutPayment.inputNameOnCard.sendKeys(dataTable.cell(1, 1));
				checkoutPayment.inputCardExpiryDate.sendKeys(dataTable.cell(1, 2));
				checkoutPayment.inputSecurityCode.sendKeys(dataTable.cell(1, 3));
				WebDriverManagedef.stepstatus = "Passed";
			}else{
				Assert.assertTrue(false,"Payment Failure");
				WebDriverManagedef.stepstatus = "Failed";
			}
		}
		catch(AssertionError | Exception e){
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}

		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@Then("place order and pay securely CTA button is enabled")
	public void place_order_and_pay_securely_CTA_button_is_enabled() throws Throwable {
		try {
		Assert.assertTrue(checkoutPayment.placeOrderAndPaySecurelyBtn.isEnabled());
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@When("user clicks on place order and pay securely CTA")
	public void user_clicks_on_place_order_and_pay_securely_cta() throws Throwable {
		try {
			if (!HomePageStepDefinition.Environment.equals("LIVE"))
			{
				webdef.JsClick(checkoutPayment.placeOrderAndPaySecurelyBtn, driver);
				Thread.sleep(10000);
				WebDriverManagedef.stepstatus= "Passed";
			}
			else
			{
				webdef.JsScrollBy(driver, 0, 750);
				webdef.highlightObjects(driver,checkoutPayment.placeOrderAndPaySecurelyBtn);
				Assert.assertTrue(true, "Place Order button is enabled for LIVE environment");
				WebDriverManagedef.stepstatus = "Passed";
			}
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {
			Assert.assertTrue(false);
		}
	}

	@Test
	@Then("user uncheck save card details")
	public void uncheck_save_card_details() throws Throwable {
		try {
		if (checkoutPayment.savecarddetailscheckbox.isSelected()) {
			webdef.JsClick(checkoutPayment.savecarddetailscheckbox, driver);
			WebDriverManagedef.stepstatus= "Passed";
			Assert.assertTrue(true);
		}else if(!checkoutPayment.savecarddetailscheckbox.isSelected()){
			WebDriverManagedef.stepstatus= "Passed";
			Assert.assertTrue(true);
		}	
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@When("user selects gift card payment method with <CardNumber> and <Pin>")
	public void user_selects_gift_card_payment_method_with_card_number_and_pin(
			io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
				String GiftcardID=dataTable.cell(1, 0);
				String[] Giftcard=GiftcardID.split(",");
				if (!HomePageStepDefinition.Environment.equals("LIVE")) 
					GiftcardID=Giftcard[0];
            else
            	GiftcardID=Giftcard[1];
				Thread.sleep(3000);
			webdef.JsClick(checkoutPayment.PaymentMethod("Gift Card"), driver);
			Thread.sleep(1000);
			checkoutPayment.giftCardNumber.sendKeys(GiftcardID);
			checkoutPayment.giftCardPin.sendKeys(dataTable.cell(1, 1));
			WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@When("user clicks on verify card CTA button")
	public void user_clicks_on_verify_card_cta_button() throws Throwable {
		try {
			if (!HomePageStepDefinition.Environment.equals("LIVE")) {
				webdef.JsClick(checkoutPayment.verifyGiftCard, driver);
				WebDriverManagedef.stepstatus= "Passed";
			}
			else
			{
				webdef.highlightObjects(driver,checkoutPayment.verifyGiftCard);
				Assert.assertTrue(true, "Verify Gift card button is enabled for LIVE environment");
				WebDriverManagedef.stepstatus = "Passed";
			}
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@When("user enters the amount to use")
	public void user_enters_the_amount_to_use() throws Throwable {
		if (!HomePageStepDefinition.Environment.equals("LIVE")) {
			try {
			Thread.sleep(2000);
			webdef.waitVisibilityofElementLocated(driver, checkoutPayment.amount(), 30);
			checkoutPayment.GiftCardAmount.sendKeys("1");
			WebDriverManagedef.stepstatus= "Passed";
			}catch (AssertionError | Exception e) {
				WebDriverManagedef.stepstatus="Failed";	
				WebDriverManagedef.error=(e.getMessage());
			}
		}
		else
			{
				
				Assert.assertTrue(true, "N/a scenario for LIVE environment");
				WebDriverManagedef.stepstatus = "Passed";
			}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@When("user clicks on reedem card CTA button")
	public void user_clicks_on_reedem_card_cta_button() throws Throwable {
		if (!HomePageStepDefinition.Environment.equals("LIVE")) {
			try {
			webdef.JsClick(checkoutPayment.redeemCard, driver);
			WebDriverManagedef.stepstatus= "Passed";
			}catch (AssertionError | Exception e) {
				WebDriverManagedef.stepstatus="Failed";	
				WebDriverManagedef.error=(e.getMessage());
			}
			Thread.sleep(3000);
		}
		else
			{
				
				Assert.assertTrue(true, "N/a scenario for LIVE environment");
				WebDriverManagedef.stepstatus = "Passed";
			}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
		
	}

	@Test
	@When("user clicks on place order and pay securely CTA button")
	public void user_clicks_on_place_order_and_pay_securely_cta_button() throws Throwable {
		try {
		Thread.sleep(3000);
		webdef.JsScrollBy(driver, 0, 150);
		webdef.JsClick(checkoutPayment.placeOrderAndPaySecurelyBtn1, driver);
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@And("user verifies saved card details")
	public void user_verifies_saved_card_details(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
		Assert.assertTrue(checkoutPayment.CardEnding(dataTable.cell(1, 0)).getText().contains(dataTable.cell(1, 0)));
		Assert.assertTrue(checkoutPayment.CardExpiry(dataTable.cell(1, 1)).getText().contains(dataTable.cell(1, 1)));
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@And("user enters saved card security code")
	public void user_enters_saved_card_security_code(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
		checkoutPayment.inputSavedCardSecurityCode.sendKeys(dataTable.cell(1, 0));
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

}
