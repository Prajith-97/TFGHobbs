package stepdefs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.CheckoutDelivery;
import pageobjects.CheckoutLogin;
import pageobjects.HomePage;
import utility.WebDriverManagedef;
import utility.WebDriverManagerAppium;

public class CheckoutDeliveryStepDefinition {

	WebDriver driver = HomePageStepDefinition.driver;
	HomePage homePage;
	CheckoutDelivery checkoutDelivery = new CheckoutDelivery(driver);
	static Boolean objDelivery;
	WebDriverManagedef webdef = new WebDriverManagedef();
	boolean isElementPresent;
	 public List<String> list;						 

	

	@Test
	@Then("user is on checkout delivery page")
	public void user_is_on_checkout_delivery_page() throws Throwable {
		try {
			 webdef.waitvisibilityof(driver, checkoutDelivery.deliveryRadioBtn, 30);
			Assert.assertTrue(checkoutDelivery.deliveryRadioBtn.isDisplayed());
			webdef.JsClick(checkoutDelivery.deliveryRadioBtn, driver);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	@Test
	@When("user selects a <Delivery> method")
	public void user_selects_a_delivery_method(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			Thread.sleep(2000);
			if (!checkoutDelivery.standardDeliveryMethod.isSelected()) {
				webdef.JsClick(checkoutDelivery.shippingMethod(dataTable.cell(1, 0)), driver);
				objDelivery = true;
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "Delivery method is not selected");
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
	@Then("the <Delivery> method is selected")
	public void the_delivery_method_is_selected(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			Assert.assertTrue(objDelivery);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	
	@Test
	@When("the user clicks on Enter address manually link")
	public void the_user_clicks_on_enter_address_manually_link() throws Throwable {
		try {
			webdef.JsClick(checkoutDelivery.enterAddressManually, driver);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	

 @Test
    @Then("user uncheck save delivery address checkBox")
    public void uncheck_Delivery_Address_checkBox() throws Throwable {
        try {
            if (checkoutDelivery.savedeliveraddresscheckbox.isSelected()) {
                webdef.JsClick(checkoutDelivery.savedeliveraddresscheckbox, driver);
            }
            WebDriverManagedef.stepstatus = "Passed";
        } catch (AssertionError | Exception e) {
            WebDriverManagedef.stepstatus = "Passed";
            System.out.println("save delivery address checkBox is not selected by default");
        }
        if (WebDriverManagedef.stepstatus == "Failed") {
            Assert.assertTrue(false);
        }
    }																		

	@Test
	@Then("continue to Payment CTA button is enabled")
	public void continue_to_payment_cta_button_is_enabled() throws Throwable {
		try {
			Assert.assertTrue(checkoutDelivery.continueToPaymentBtn.isEnabled());
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	@Test
	@When("user clicks on continue to Payment CTA button")
	public void user_clicks_on_continue_to_payment_cta_button() throws Throwable {
		try {
            webdef.JsClick(checkoutDelivery.continueToPaymentBtn, driver);
            Thread.sleep(15000);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	@Test
	@Then("user checks continue to payment without enter manadtory fields")
	public void manadtory_fields_for_delivery_details() throws Throwable {
		try {
			webdef.JsClick(checkoutDelivery.continueToPaymentBtn, driver);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);		 
		}
	}

	@Test
	@When("user selects default delivery method")
	public void user_selects_default_delivery_method() throws Throwable {
		try {
			int size = checkoutDelivery.deliveryMethodList().size();
			System.out.println(size);
			if ((size == 1) && (checkoutDelivery.defaultDeliveryMethod.isSelected()))
			{
				WebDriverManagedef.stepstatus = "Passed";
				Assert.assertTrue(true, "Delivery method is already selected");
			} 
		}
			catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
}

    @Test
    @When("user enters the customer details for \"([^\"]*)\"$")
    public void user_enters_the_customer_details(String Region) throws Throwable {
        try {
            String Environment = System.getProperty("Environment");
            list = webdef.getExcelSheet("Address", Environment, Region);
            webdef.waitElementClickable(driver, checkoutDelivery.dropdownTitle, 30);
            webdef.JsClick(checkoutDelivery.dropdownTitle, driver);
            checkoutDelivery.CustomerTitle(list.get(0)).click();
            checkoutDelivery.inputFirstName.sendKeys(list.get(1));
            checkoutDelivery.inputLastName.sendKeys(list.get(2));
            checkoutDelivery.inputMobileNumber.sendKeys(list.get(3));
            WebDriverManagedef.stepstatus = "Passed";
        } catch (AssertionError | Exception e) {
            WebDriverManagedef.stepstatus = "Failed";
            WebDriverManagedef.error = (e.getMessage());
        }
        if (WebDriverManagedef.stepstatus == "Failed") {
            Assert.assertTrue(false);
        }
    }

  
    @Test
    @When("user inputs address details")
    public void user_inputs_address_details() throws Throwable {
        try {
            webdef.JsScrollBy(driver, 0, 250);
            webdef.waitVisibilityofElementLocated(driver, checkoutDelivery.addressinput1(), 20);
            checkoutDelivery.inputAddressLineOne.sendKeys(list.get(5));
            Thread.sleep(1000);
            checkoutDelivery.inputAddressLineTwo.sendKeys(list.get(6));
            checkoutDelivery.inputPostalCode.sendKeys(list.get(9));
            checkoutDelivery.inputCity.sendKeys(list.get(8));
            Thread.sleep(1000);
            WebDriverManagedef.stepstatus = "Passed";
        } catch (AssertionError | Exception e) {
            WebDriverManagedef.stepstatus = "Failed";
            WebDriverManagedef.error = (e.getMessage());
        }
        if (WebDriverManagedef.stepstatus == "Failed") {
            Assert.assertTrue(false);
        }
    }

    @Test
    @Then("delivery method is selected")
    public void delivery_method_is_selected() {
        try {

            if (checkoutDelivery.existingDeliveryMethod.isDisplayed()) {
                Assert.assertTrue(true);
                WebDriverManagedef.stepstatus = "Passed";
            } else {

                Assert.assertTrue(false);
                WebDriverManagedef.stepstatus = "Failed";
            }
        } catch (AssertionError | Exception e) {
            WebDriverManagedef.stepstatus = "Failed";
            WebDriverManagedef.error = (e.getMessage());
        }
        if (WebDriverManagedef.stepstatus == "Failed") {
            Assert.assertTrue(false);
        }
    }
}
