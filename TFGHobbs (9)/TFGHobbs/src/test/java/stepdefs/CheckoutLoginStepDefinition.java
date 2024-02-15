package stepdefs;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Basket;
import pageobjects.CheckoutLogin;
import pageobjects.HomePage;
import utility.WebDriverManagedef;
import utility.WebDriverManagerAppium;

public class CheckoutLoginStepDefinition {

	WebDriver driver = HomePageStepDefinition.driver;
	HomePage homePage;
	CheckoutLogin checkoutLogin = new CheckoutLogin(driver);
	WebDriverManagedef webdef = new WebDriverManagedef();

	@Test
	@Then("user is on check out login page")
	public void user_is_on_check_out_login_page() throws Throwable {
		try {
		webdef.waiturlContains(driver,"/checkout/login/",30);
		Assert.assertTrue(driver.getTitle().contains("Checkout"));
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
	@When("user selects password radio button")
	public void user_selects_pwd_radio_button() throws Throwable {
		try {
		webdef.JsClick(checkoutLogin.passwordRadioBtn, driver);
		Thread.sleep(2000);
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
	@When("user enters valid <Password>")
	public void user_enters_valid_Password(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
		checkoutLogin.inputPassword.sendKeys(dataTable.cell(1, 0));
        WebDriverManagedef.stepstatus = "Passed";
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}

	}

	@Test
	@When("user enters an <EmailID> on check out login page")
	public void user_enters_an_email_id_on_check_out_login_page(io.cucumber.datatable.DataTable dataTable)
			throws Throwable {
		try {
		webdef.waitvisibilityof(driver, checkoutLogin.inputEmail, 40);
		Thread.sleep(1000);
        checkoutLogin.inputEmail.sendKeys(dataTable.cell(1, 0));
        Thread.sleep(2000);
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
	@When("user selects continue as guest option")
	public void user_selects_continue_as_guest_option() throws Throwable {
		try {
		if (!checkoutLogin.continueasguest.isSelected()) {
			webdef.JsClick(checkoutLogin.continueasguest, driver);
			WebDriverManagedef.stepstatus= "Passed";
		}else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "User not able to select continue as guest option");
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
    @When("user clicks Continue Securely button")
    public void user_clicks_continue_securely_button() throws Throwable {
        try {
            webdef.waitvisibilityof(driver, checkoutLogin.continueSecurelyBtn, 30);
            webdef.JsClick(checkoutLogin.continueSecurelyBtn, driver);
            WebDriverManagedef.stepstatus = "Passed";
            try {
                boolean status = checkoutLogin.checkoutAsGuestBtn.isDisplayed();
                if (status == true) {
                    webdef.JsClick(checkoutLogin.checkoutAsGuestBtn, driver);
                }
            } catch (Exception elementNotFound) {
                System.out.println("Not a DEV env");
            }
        } catch (AssertionError | Exception e) {
            WebDriverManagedef.stepstatus = "Failed";
            WebDriverManagedef.error = (e.getMessage());
        }
        if (WebDriverManagedef.stepstatus == "Failed") {
            Assert.assertTrue(false);
        }
    }


	@Test
	@And("user is on Go To Your Account page")
	public void user_verify_gotoAccount() throws Throwable {
		try {
		Thread.sleep(4000);
		Boolean status = checkoutLogin.checkoutAsGuestBtn.isDisplayed();
		Assert.assertTrue(status);
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	
//    @Test
//    @Then("user clicks Checkout as Guest button from go to Your Account page")
//    public void user_clicks_Checkout_as_Guest_button() throws Throwable {
//        try {
//            Thread.sleep(2000);
//            webdef.JsClick(checkoutLogin.checkoutAsGuestBtn, driver);
//            Thread.sleep(1000);
//            WebDriverManagedef.stepstatus = "Passed";
//        } catch (AssertionError | Exception e) {
//            WebDriverManagedef.stepstatus = "Failed";
//            WebDriverManagedef.error = (e.getMessage());
//        }
//        if (WebDriverManagedef.stepstatus == "Failed") {
//            Assert.assertTrue(false);
//        }
//    }

//    @Test
//    @When("user clicks on log in and save time button")
//    public void user_clicks_on_log_in_and_save_time_button() throws Throwable {
//        try {
//            webdef.JsClick(checkoutLogin.loginAndSaveTimeBtn, driver);
//            WebDriverManagedef.stepstatus = "Passed";
//        } catch (AssertionError | Exception e) {
//            WebDriverManagedef.stepstatus = "Failed";
//            WebDriverManagedef.error = (e.getMessage());
//        }
//        if (WebDriverManagedef.stepstatus == "Failed") {
//            Assert.assertTrue(false);
//        }
//
//    }


	// ..............................P2_ALL_Checkout_registered_error_forms............................

	@Test
	@Then("Please enter a valid email address error is displayed")
	public void please_enter_a_valid_email_address_error_is_displayed() throws Throwable {
		try {
		String continuebtnText = "Continue Securely";
		String continueTextExpected = continuebtnText.toUpperCase();
		String continueTextActual = checkoutLogin.continueSecurelyBtn.getText();
		Assert.assertEquals(continueTextActual, continueTextExpected);
		Assert.assertEquals("Please enter a valid email address", checkoutLogin.emailError.getText());
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
	@When("user enters Email ID on check out login page")
	public void user_enters_valid_Email_on_check_out_login_page(io.cucumber.datatable.DataTable dataTable)
			throws Throwable {
		try {
		Thread.sleep(1000);
		checkoutLogin.inputEmail.clear();
		checkoutLogin.inputEmail.sendKeys(dataTable.cell(1, 0));
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
	@When("user selects Yes my password is option")
	public void user_selects_Yes_my_password_is_option() throws Throwable {
		try {
		Thread.sleep(1000);
		webdef.JsClick(checkoutLogin.passwordRadioBtn, driver);
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
	@When("user enters incorrect password")
	public void user_enters_incorrect_password(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
		checkoutLogin.inputPassword.sendKeys(dataTable.cell(1, 0));
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
	@Then("Invalid login or password error is shown")
	public void invalid_login_or_password_error_is_shown() throws Throwable {
		try {
		Thread.sleep(2000);
		String validationMsg = checkoutLogin.errormesssage.getText();
		if(validationMsg.contains("Invalid login or password"))
		{
			Assert.assertTrue(true);
			WebDriverManagedef.stepstatus= "Passed";
		} else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "Invalid login or password error is not shown");
		}
		}catch(Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	// ........................p2_desktop_guestcustomer_checkout......................................
	@Test
	@When("user enters a valid email id on checkout login page")
	public void user_enters_a_valid_email_id_on_check_out_login_page() throws Throwable {
		try {
		String user = webdef.getSaltString();
		String useraccount = "G10X"+user + "_G10x@gmail.com";
		System.out.println(useraccount + "useraccount");
		checkoutLogin.inputEmail.sendKeys(useraccount);
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
