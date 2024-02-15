package stepdefs;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CheckoutConfirmation;
import pageobjects.HomePage;
import utility.WebDriverManagedef;

public class CheckoutConfirmationStepDefinition {

	WebDriver driver = HomePageStepDefinition.driver;
	HomePage homePage = new HomePage(driver);
	CheckoutConfirmation checkoutConfirmation = new CheckoutConfirmation(driver);
	WebDriverManagedef webdef = new WebDriverManagedef();

	@Test
	@Then("user lands on confirmation page")
	public void user_lands_on_confirmation_page() throws Throwable {
		if (!HomePageStepDefinition.Environment.equals("LIVE"))
		{
			try {
				Thread.sleep(1000);
				if (checkoutConfirmation.CreditcardError.isDisplayed())
				{
					WebDriverManagedef.stepstatus="Failed";
					Assert.assertTrue(false,"User is not able to proceed with Credit card");
				}
			}
			catch(Exception exp) {
				WebDriverManagedef.stepstatus = "Passed";
			}
			try
			{
//				Thread.sleep(3000);
//				//webdef.waitvisibilityof(driver, checkoutConfirmation.inputOTPNumber, 20);
//				//webdef.waitElementClickable(driver, checkoutConfirmation.inputOTPNumber, 20);
//				
//			driver.switchTo().frame(checkoutConfirmation.form);
//			System.out.println("OPT page is showing inside frame window");
//				checkoutConfirmation.inputOTPNumber.sendKeys(dataTable.cell(1, 0));;
//				Thread.sleep(3000);
//			//	driver.switchTo().defaultContent();
//				Thread.sleep(1000);
//			    webdef.JsClick(checkoutConfirmation.confirmSubmit, driver);
				
			//	Thread.sleep(6000);
// Thread.sleep(1500);
				System.out.println(driver.getTitle());
				webdef.waiturlContains(driver, "confirmation", 50);
				if (driver.getCurrentUrl().contains("confirmation")) {
					Assert.assertTrue(driver.getTitle().contains("Confirmation"));
					WebDriverManagedef.stepstatus= "Passed";
				}else {
					WebDriverManagedef.stepstatus = "Failed";
					Assert.assertTrue(false, "User is not in confirmation page");
				}
			}
			catch (AssertionError | Exception e) {
				WebDriverManagedef.stepstatus="Failed";
				WebDriverManagedef.error=(e.getMessage());
			}
		}
		else
		{
			Assert.assertTrue(true, "N/A for LIVE environment");
			WebDriverManagedef.stepstatus = "Passed";
		}
		if(WebDriverManagedef.stepstatus=="Failed") {
			Assert.assertTrue(false);
		}
	}
	@Test
	@When("user clicks on log out button")
	public void user_clicks_on_log_out_button() throws Throwable {
		try {
			if (!HomePageStepDefinition.Environment.equals("LIVE")){
				webdef.JsClick(checkoutConfirmation.LogOutBtn, driver);
				Thread.sleep(2000);
				WebDriverManagedef.stepstatus= "Passed";
			}
			else{
				Assert.assertTrue(true, "N/A for LIVE environment");
				WebDriverManagedef.stepstatus = "Passed";
			}
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {
			Assert.assertTrue(false);
		}
	}

	@Test
	@Then("user is logged out")
	public void user_is_logged_out() throws Throwable {
		try {
			if (!HomePageStepDefinition.Environment.equals("LIVE")){
				Assert.assertTrue(homePage.mainCategoryNavigation.isDisplayed());
				WebDriverManagedef.stepstatus = "Passed";
			}
			else{
				Assert.assertTrue(true, "N/A for LIVE environment");
				WebDriverManagedef.stepstatus = "Passed";
			}
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {
			Assert.assertTrue(false);
		}

	}

	// ...........................p2_desktop_guest_customer_checkoout................................
	@Test
	@When("user enters password and confirm password")
	public void user_enters_password_and_confirm_password(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			if (!HomePageStepDefinition.Environment.equals("LIVE")) {
				checkoutConfirmation.password.clear();
				checkoutConfirmation.confirmPassword.clear();
				checkoutConfirmation.password.sendKeys(dataTable.cell(1, 0));
				checkoutConfirmation.confirmPassword.sendKeys(dataTable.cell(1, 1));
				WebDriverManagedef.stepstatus = "Passed";
			}else {
				Assert.assertTrue(true, "N/A for LIVE environment");
				WebDriverManagedef.stepstatus = "Passed";
			}
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@When("user clicks on create account button")
	public void user_clicks_on_create_account_button() throws Throwable {
		try {
			if (!HomePageStepDefinition.Environment.equals("LIVE")) {
				webdef.JsClick(checkoutConfirmation.createGuestaccount, driver);
				Thread.sleep(3000);
				WebDriverManagedef.stepstatus = "Passed";
			}else{
				Assert.assertTrue(true, "N/A for LIVE environment");
				WebDriverManagedef.stepstatus = "Passed";
			}
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@Then("guest account is created")
	public void guest_account_is_created() throws Throwable {
		try {
			if (!HomePageStepDefinition.Environment.equals("LIVE")) {
				webdef.waiturlContains(driver, "/account", 70);
				if (driver.getCurrentUrl().contains("/account")) {
					Assert.assertTrue(true);
					WebDriverManagedef.stepstatus = "Passed";
				} else {
					WebDriverManagedef.stepstatus = "Failed";
					Assert.assertTrue(false, "User is not in account page");
				}
			}else{

				Assert.assertTrue(true, "N/A for LIVE environment");
				WebDriverManagedef.stepstatus = "Passed";
			}
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@Then("password validation error is thrown")
	public void password_validation_error_is_thrown() throws Throwable {
		try {
			if (!HomePageStepDefinition.Environment.equals("LIVE")) {
				String validationMsg = checkoutConfirmation.passwordError.getText();
				if ((validationMsg.contains("Please lengthen this text to 8 characters")) || (validationMsg.contains("Please use at least 8 characters")))
				 {
					Assert.assertTrue(true);
					WebDriverManagedef.stepstatus = "Passed";
				} else {
					WebDriverManagedef.stepstatus = "Failed";
					Assert.assertTrue(false, "Password validation error is not showing");
				}
				Thread.sleep(3000);
			}else{
				Assert.assertTrue(true, "N/A for LIVE environment");
				WebDriverManagedef.stepstatus = "Passed";
			}


		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

}
