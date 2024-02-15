package stepdefs;

import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.CheckoutDelivery;
import pageobjects.CheckoutPayment;
import pageobjects.CountrySelector;
import pageobjects.HomePage;
import pageobjects.PLP;
import utility.WebDriverManagedef;
import utility.WebDriverManagerAppium;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class HomePageStepDefinition {
	static WebDriver driver;
	String driverstate;
	static HomePage homePage;
	PLP plp = new PLP(driver);
	WebDriverManagedef webdef = new WebDriverManagedef();
	CountrySelector countrySelect=new CountrySelector(driver);
	static Boolean executionmobile = false;
	String oldStore = null;
	static String email;
	static String RegionVal,Environment;
	public List<String> list;


	@Given("website HOBBS url is launched for {string} in {string}")
	@Test
	@Severity(SeverityLevel.MINOR)
	public void website_HOBBS_url_is_launched_for_in(String Region, String Device) throws Throwable  {
		RegionVal=Region;
		Environment =System.getProperty("Environment");
		switch (Device.toUpperCase()) {
		case "MOBILE":
			try {
				// OS = System.getProperty("OS");
				String Android = System.getProperty("androidStatus");
				String Apple = System.getProperty("iOSStatus");

				// System.out.println(OS);

				if (Device.equalsIgnoreCase("Mobile") && Android.equalsIgnoreCase("true")) {
					// if (OS.equalsIgnoreCase("Android")
					WebDriverManagerAppium.setUpSuiteAndriod(Region);
					driver = WebDriverManagerAppium.driver;
					homePage = new HomePage(driver);
					executionmobile = true;
					WebDriverManagedef.stepstatus = "Passed";
				}

				if (Device.equalsIgnoreCase("Mobile") && Apple.equalsIgnoreCase("true")) {

					WebDriverManagerAppium.setUpSuiteIOS(Region);
					driver = WebDriverManagerAppium.driver;
					homePage = new HomePage(driver);
					executionmobile = true;
					WebDriverManagedef.stepstatus = "Passed";
				}
			} catch (Exception e) {
				WebDriverManagedef.stepstatus = "Failed";
				WebDriverManagedef.error = (e.getMessage());
				Assert.assertTrue(false, "pCloudy device connection failed.");

			}
//		if (WebDriverManagedef.stepstatus == "Failed") {
//			Assert.assertTrue(false);
//		}
			break;
		case "DESKTOP":
			try {
				if (Device.equalsIgnoreCase("Desktop")) {
					WebDriverManagedef.getRemoteWebDriver(Region);
					driver = webdef.driver;
					homePage = new HomePage(driver);
					WebDriverManagedef.takeScreenshots(driver);
					WebDriverManagedef.setAllureEnvironment();
					executionmobile = false;
				}
				WebDriverManagedef.stepstatus = "Passed";
			} catch (AssertionError | Exception e) {
				WebDriverManagedef.stepstatus = "Failed";
				WebDriverManagedef.error = (e.getMessage());
				Assert.assertTrue(false, "Browser driver creation failed.");
			}
//		if (WebDriverManagedef.stepstatus == "Failed") {
//			Assert.assertTrue(false);
//		}

			break;
		}
	}
	
	@Test()
	@When("user closes country selector gateway modal")
	public void user_closes_country_selector_gateway_modal() throws Throwable {
		try {
			try{
				webdef.waitvisibilityof(driver,homePage.Acceptcookies,10);
				webdef.JsClick(homePage.Acceptcookies,driver);
				Thread.sleep(2000);
				WebDriverManagedef.stepstatus= "Passed";
			}catch(Exception cookieNotFound){
				System.out.println("Cookie banner not visible");
			}
			try {
			if (homePage.countrySelectorGatewayCloseBtn.isDisplayed())
				{
					webdef.JsClick(homePage.countrySelectorGatewayCloseBtn, driver);
					WebDriverManagedef.takeScreenshots(driver);
					WebDriverManagedef.stepstatus = "Passed";
				}
			}
			catch (Exception e) {
				WebDriverManagedef.takeScreenshots(driver);
				WebDriverManagedef.stepstatus = "Passed";
				System.out.println("No Country Popup");
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
	@When("user selects {string} from country selector gateway modal")
	public void user_selects_from_country_selector_gateway_modal(String country) throws Throwable {
		try {
			Thread.sleep(4000);
			webdef.JsClick(homePage.dropdowncountrymobile, driver);
			Thread.sleep(3000);
			webdef.actionClass(driver, homePage.CountryInSelectorGateway(country));
			homePage.CountryInSelectorGateway(country).click();
			Thread.sleep(3000);
			webdef.actionClass(driver, homePage.gatewaySubmitbtn);
			homePage.gatewaySubmitbtn.click();
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
	@Then("user is on home page for website \"([^\"]*)\"$")
	public void user_is_on_home_page(String Region) throws Throwable {
		try {
			String website = null;
			String URL =webdef.GetRegionURL(Region,Environment);
			website = URL.substring(8);
			Boolean Status = false;
			webdef.waiturlContains(driver, "hobbs.com", 20);
			String objurl = driver.getCurrentUrl();
			System.out.println(objurl + "objurl");
			System.out.println(website + "website");
			if (objurl.contains(website)) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			} else {

				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "User is not in home page for website");
			}
			try {
				webdef.waitElementClickable(driver, countrySelect.countrySelectorPopup, 10);
				webdef.JsClick(countrySelect.countrySelectorPopup, driver);
				Assert.assertTrue(true, "popup handled");
				WebDriverManagedef.stepstatus= "Passed";
			}catch(Exception NotFound)
			{   WebDriverManagedef.stepstatus= "Passed";
				Assert.assertTrue(true, "No popups to handle");
			}
			
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@When("user clicks on accept and close CTA on cookie banner")
	@Test
	public void user_clicks_on_accept_and_close_cta_on_cookie_banner() throws Throwable {
		try {
			Thread.sleep(3000);
			WebDriverManagedef.takeScreenshots(driver);
			webdef.JsClick(homePage.acceptAndCloseBtn, driver);
			WebDriverManagedef.takeScreenshots(driver);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	@Then("the cookie banner is not visible")
	@Test
	public void the_cookie_banner_is_not_visible() throws Throwable {
		try {
			Thread.sleep(3000);
			Assert.assertNotEquals(0, homePage.acceptAndCloseBanner.getSize());
			WebDriverManagedef.takeScreenshots(driver);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	@When("user clicks on <SubCategory> from <MainCategory> category")
	@Test
	public void user_clicks_on_sub_category_from_main_category_category() throws Throwable{

		 try {
				list= webdef.getExcelSheet("Categories",Environment,RegionVal);
	            String mainProductCategory=list.get(0);
	            String subCategory= list.get(1);
	            webdef.actionClass(driver, homePage.MainCategory(mainProductCategory));
	            switch(mainProductCategory.toLowerCase()) {																													  
	             case "new in"        :
										
	                                     webdef.JsClick(homePage.SubCategory(subCategory), driver);
	                                      break;
	             case "what's new"        :
											 
					                     webdef.JsClick(homePage.SubCategorywhatnew(subCategory), driver);
					                      break;
	             case "clothing"      :
									
	                                      webdef.JsClick(homePage.SubCategoryClothing(subCategory), driver);
	                                      break;
	             case  "shoes"        :
									
	                                      webdef.JsClick(homePage.SubCategoryShoes(subCategory), driver);
	                                      break;
	             case "dresses"          :
										
	                                      webdef.JsClick(homePage.SubCategoryDress(subCategory), driver);
	                                      break;
	             case "occasion"  :
										
	            	                        webdef.JsClick(homePage.SubCategoryOccasion(subCategory), driver);
	            	                        break;                       	
	            } 
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
	@Then("user is on <SubCategory> PLP")
	public void user_is_on_sub_category_plp() throws Throwable {
		try {

			Thread.sleep(4000);
			WebDriverManagedef.takeScreenshots(driver);
			webdef.waitvisibilityof(driver, plp.productfromrow1, 30);
			System.out.println(driver.getTitle() + " title name");
			String productText =list.get(1);
			String[] array = productText.split(" ");
			int Length = array.length;
			System.out.println(Length);
			for (int i = 0; i < Length; i++) {
				System.out.println(array[i]);
				if (driver.getTitle().contains(array[i])) {
					System.out.println(array[i]);
					Assert.assertTrue(true);
					break;
				}
			}
			WebDriverManagedef.stepstatus = "Passed";
//			try {
//				webdef.waitvisibilityof(driver, countrySelector.popup, 20);
//				webdef.waitElementClickable(driver, countrySelector.popup, 20);
//				webdef.JsClick(countrySelector.popup, driver);	
//				Assert.assertTrue(true, "popup handled");
//				WebDriverManagedef.stepstatus= "Passed";
//			}catch(Exception NotFound)
//			{   WebDriverManagedef.stepstatus= "Passed";
//				Assert.assertTrue(true, "No popups to handle");
//			}

		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@When("user clicks on brand logo")
	@Test
	public void user_clicks_on_brand_logo() throws Throwable {
		
		if (HomePageStepDefinition.Environment.equals("LIVE"))
		{
		try {
			if(homePage.brandLogo.isDisplayed())
			{
				webdef.JsClick(homePage.brandLogo,driver);
				WebDriverManagedef.stepstatus = "Passed";
			}
		}
		catch (AssertionError | Exception  e) {	
			if(homePage.brandLogo1.isDisplayed())
			{
				webdef.JsClick(homePage.brandLogo1,driver);
				WebDriverManagedef.stepstatus = "Passed";
			}
			else
			{
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());	
			}
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
		}
		else {
			try {
				if(homePage.brandLogostage.isDisplayed())
				{
					webdef.JsClick(homePage.brandLogostage,driver);
					WebDriverManagedef.stepstatus = "Passed";
				}
			}
			catch (AssertionError | Exception  e) {	
				if(homePage.brandLogo1.isDisplayed())
				{
					webdef.JsClick(homePage.brandLogo1,driver);
					WebDriverManagedef.stepstatus = "Passed";
				}
				else
				{
				WebDriverManagedef.stepstatus = "Failed";
				WebDriverManagedef.error = (e.getMessage());	
				}
			}
			if (WebDriverManagedef.stepstatus == "Failed") {
				Assert.assertTrue(false);
			}	
		}
	}

	@Then("user is navigated to home page")
	@Test
	public void user_is_navigated_to_home_page() throws Throwable {
		try {
			Thread.sleep(2000);
			if(homePage.mainCategoryNavigation.isDisplayed() || homePage.burgerIcon.isDisplayed()) {
				Assert.assertTrue(true);
			}
	
			WebDriverManagedef.takeScreenshots(driver);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	@When("user clicks on burger menu")
	@Test
	public void user_clicks_on_burger_menu() throws Throwable {
		try {
			webdef.JsClick(homePage.burgerIcon, driver);
			WebDriverManagedef.takeScreenshots(driver);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@Then("subnav panel is opened")
	@Test
	public void subnav_panel_is_opened() throws Throwable {
		try {
			Assert.assertTrue(homePage.subNavigationPanel.isDisplayed());
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	
	// ...................p2_all_desktop_account........................................................

	@When("user clicks on my account icon on header")
	@Test
	public void user_clicks_on_my_account_icon_on_header() throws Throwable {
//		if (webdef.checkDriverStatus(driver)) {
			try {
				webdef.waitvisibilityof(driver,homePage.loginIcon,30);
				webdef.JsClick(homePage.loginIcon, driver);
				WebDriverManagedef.takeScreenshots(driver);
				WebDriverManagedef.stepstatus = "Passed";

			} catch (AssertionError | Exception e) {
				WebDriverManagedef.stepstatus = "Failed";
				WebDriverManagedef.error = (e.getMessage());
			}
//		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}														   															
	}

	@Then("user is on Login or Register page")
	@Test
	public void user_is_on_Login_Register_page() throws Throwable {
		try {
			webdef.waiturlContains(driver, "/login/", 30);
			if (homePage.loginEmail.isDisplayed()) {
				Assert.assertTrue(true);														
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "User not in login page");
			}
			  driver.navigate().refresh();
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}
	@When("user enters Email and Password")
	@Test
	public void user_enters_correct_Email_and_incorrect_Password(io.cucumber.datatable.DataTable dataTable)
			throws Throwable {
		try {
			
			homePage.loginEmail.clear();
			homePage.loginPassword.clear();
			
			homePage.loginEmail.sendKeys(dataTable.cell(1, 0));
			homePage.loginPassword.sendKeys(dataTable.cell(1, 1));
			Thread.sleep(1000);
			WebDriverManagedef.takeScreenshots(driver);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@When("user clicks on signin button")
	@Test
	public void user_clicks_on_signin_button() throws Throwable {
		try {
			webdef.waitElementClickable(driver, homePage.signinButton, 40);
			webdef.JsClick(homePage.signinButton, driver);
			WebDriverManagedef.takeScreenshots(driver);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@Then("validating the error message for Invalid login password")
	@Test
	public void invalid_login_or_password_Remember_that_password_is_case_sensitive_Please_try_again_error_is_thrown()
			throws Throwable {
		try {
			String validationMsg = homePage.errormsg.getText();
			if (validationMsg.contains("Invalid login or password. Remember that password is case-sensitive. Please try again")) 
			{
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			} 
			else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "Validation message is not showing");
			}

		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@When("user keeps Email blank")
	@Test
	public void user_keeps_Email_blank() throws Throwable {
		try {
			homePage.loginEmail.clear();
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@When("user enters Password")
	@Test
	public void user_enters_Password(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			homePage.loginPassword.clear();
			Thread.sleep(1000);
			homePage.loginPassword.sendKeys(dataTable.cell(1, 0));
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@Then("signin button is disabled")
	@Test
	public void signin_button_is_disabled() throws Throwable {
		try {
			webdef.JsClick(homePage.signinButton, driver);
			if (driver.getCurrentUrl().contains("/login/")) {
				WebDriverManagedef.stepstatus = "Passed";
			}
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@When("user keeps Password blank")
	@Test
	public void user_keeps_Password_blank() throws Throwable {
		try {
			Thread.sleep(1000);
			homePage.loginPassword.clear();
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@When("user enters Email address")
	@Test
	public void user_enters_a_valid_Email(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			homePage.loginEmail.clear();
			homePage.loginEmail.sendKeys(dataTable.cell(1, 0));
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@When("clicks on Forgotten your password link")
	@Test
	public void clicks_on_Forgotten_your_password_link() throws Throwable {
		try {
			Thread.sleep(2000);
			webdef.JsClick(homePage.forgotPassword, driver);
			Thread.sleep(3000);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@Then("user is on password reset page")
	@Test
	public void user_is_on_password_reset_page() throws Throwable {
		try {
			String resetText1 = "We'll email you a link to reset it.";
			String resetText2 = homePage.passResetPage.getText();
			Assert.assertEquals(resetText1, resetText2);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@Then("user reset Email ID")
	@Test
	public void user_enters_Email1(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			homePage.resetEmail.clear();
			homePage.resetEmail.sendKeys(dataTable.cell(1, 0));
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@Then("clicks on send reset password email button")
	@Test
	public void clicks_on_send_reset_password_email_button() throws Throwable {
		try {
			Thread.sleep(1000);
			webdef.JsClick(homePage.sendResetpassword, driver);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@Then("account recovery email is send to registered mobile number")
	@Test
	public void account_recovery_email_is_send_to_registered_mobile_number() throws Throwable {
		try {
			Thread.sleep(1000);
			Boolean b1 = homePage.passwordSendPage.isDisplayed();
			if (b1) {
				Assert.assertTrue(true);
				driver.navigate().back();
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				Assert.assertTrue(false, "Password send message is not showing");
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

	@Then("please enter a valid email address error is thrown")
	@Test
	public void please_enter_a_valid_email_address_error_is_thrown() throws Throwable {
		try {
			  String status=homePage.resetInvalidemail.getText();
			  if(status.contains("Please enter a valid email address"))
			  {
				  Assert.assertTrue(true, "validation error is thrown");
					WebDriverManagedef.stepstatus = "Passed";

			  }
			  
		  } catch (AssertionError | Exception  e) {
				WebDriverManagedef.stepstatus = "Failed";
				WebDriverManagedef.error = (e.getMessage());
			}
			if (WebDriverManagedef.stepstatus == "Failed") {
				Assert.assertTrue(false);
			}

	}

	@Then("user enters wrong EmailId")
	@Test
	public void user_enters_wrong_EmailId(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			homePage.resetEmail.sendKeys(dataTable.cell(1, 0));
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@When("user enters a valid Email account")
	@Test
	public void user_enters_a_valid_Email_account() throws Throwable {
		try {
			Thread.sleep(2000);
			if (executionmobile) {
				webdef.JsClick(homePage.mobregister, driver);
			}
			Thread.sleep(1000);
			String user = webdef.getSaltString();
			String useraccount = "G10X_"+user +"_g10x"+ "@gmail.com";
			webdef.waitvisibilityof(driver, homePage.createaccountEmail, 30);
			System.out.println(useraccount + " user account name");
			homePage.createaccountEmail.sendKeys(useraccount);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@When("clicks on Create account button")
	@Test
	public void clicks_on_Create_account_button() throws Throwable {
		try {
			Thread.sleep(3000);
			Boolean button = homePage.createAccountbutton.isDisplayed();
			if (button) {
				webdef.JsClick(homePage.createAccountbutton, driver);
			} else {
				System.out.println("Please enter a valid password");
			}
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@Then("user is on account register page")
	@Test
	public void user_is_on_account_register_page() throws Throwable {
		try {
			webdef.waiturlContains(driver, "/register/", 50);
			if (driver.getCurrentUrl().contains("register")) {
				Assert.assertTrue(true);														
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "User not in registeration page");
			}
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@Then("user enters registraion details")
	@Test
	public void user_enters_registraion_details(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			Thread.sleep(1000);
			homePage.regTitle.sendKeys(dataTable.cell(1, 0));
			homePage.regFirstname.sendKeys(dataTable.cell(1, 1));
			homePage.regLastname.sendKeys(dataTable.cell(1, 2));
			homePage.regPassword.sendKeys(dataTable.cell(1, 3));
			homePage.regConfirmPassword.sendKeys(dataTable.cell(1, 4));
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}								 
	}			 

	@Then("user clicks on Agree & Continue button")
	@Test
	public void user_clicks_on_Agree_Continue_button() throws Throwable {
		try {
			Thread.sleep(1000);
			String passlength = homePage.regConfirmPassword.getAttribute("maxlength");
			int size = passlength.length();
			if (size >= 8) {
				System.out.print("your password is valid");
			} else {
				System.out.print("Please enter a valid password");
			}
			String title = homePage.regTitle.getAttribute("value");
			String fname = homePage.regFirstname.getAttribute("name");
			String lname = homePage.regLastname.getAttribute("name");
			String email = homePage.regPassword.getAttribute("required value");
			String pass = homePage.regLastname.getAttribute("name");
			Thread.sleep(1000);
			String confirmpass = homePage.regLastname.getAttribute("name");
			Thread.sleep(1000);
			Boolean b1 = homePage.regSubmitbutton.isDisplayed();
			if (b1) {
				webdef.JsClick(homePage.regSubmitbutton, driver);
				Thread.sleep(2000);
			}

			else if (title == "" || fname == "" || lname == "" || email == "" || pass == "" || confirmpass == "") {
				System.out.println("Please fill out all the fields");

			}
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	@Then("new account is created and user is on account management page")
	@Test
	public void new_account_is_created_and_user_is_on_account_management_page() throws Throwable {
		try {
			webdef.waitTitleContains(driver, "Account", 10);
			if (driver.getTitle().contains("Account")) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			}
			Thread.sleep(2000);
			webdef.JsClick(homePage.logOut, driver);
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}


	// .................p2_all_mobilenavigation.............................................
	
	@Test
	@When("user clicks on X close button")
	public void user_clicks_on_X_close_button() throws Throwable {
		try {
			webdef.JsClick(homePage.burgernavClose, driver);
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
	@Then("burger menu closed")
	public void burger_menu_closed() throws Throwable {
		try {
			if (homePage.subNavigationPanel.isDisplayed()) {
				Assert.assertFalse(false);
			}
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	// ..................p2_all_desktop_newsletter..........................................
	@Test
	@When("user scrolls down")
	public void user_scrolls_down() throws Throwable {
		try {
			webdef.JsScrollTo(driver, 0);
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
	@Then("user is on  global footer")
	public void user_is_on_global_footer() throws Throwable {
		try {
			if (homePage.footer.isDisplayed()) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "User is not on global footer");
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
	@When("user enters an invalid Email")
	public void user_enters_invalid_Email1(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			webdef.JsScrollBy(driver, 0, 700);
			homePage.footerEmail.sendKeys(dataTable.cell(1, 0));
			Thread.sleep(2000);
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
	@When("user clicks on signup button")
	public void user_clicks_on_signup_button() throws Throwable {
		try {
			webdef.JsClick(homePage.footersignupButton, driver);
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
	@Then("error message is thrown")
	public void error_message_is_thrown() throws Throwable {
		try {
			if(homePage.resetInvalidemail.isDisplayed()){
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
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
	@When("user enters a valid Email")
	public void user_enters_a_valid_Email1() throws Throwable {
		try {
			homePage.footerEmail.clear();
			String user = webdef.getSaltString();
			String useraccount = "G10X_"+user +"_g10x"+ "@gmail.com";
			System.out.println(useraccount + " useraccount");
			homePage.footerEmail.sendKeys(useraccount);
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
	@Then("user is on news letter page")
	public void user_is_on_news_letter_page() throws Throwable {
		try {
			webdef.waiturlContains(driver,"newsletter",30);
			if (driver.getCurrentUrl().contains("newsletter")) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "User is not on news letter page");
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
	@When("user keeps all the  mandatory fields empty")
	public void user_keeps_all_the_mandatory_fields_empty() throws Throwable {
		try {
			String title = homePage.newsTitle.getAttribute("value");
			String fname = homePage.newsFirstname.getAttribute("value");
			String lname = homePage.newsLastname.getAttribute("value");
			System.out.println("title" + title);
			System.out.println("fname" + fname);
			System.out.println("lname" + lname);
			if (fname.isEmpty() && lname.isEmpty()) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "Mandatory fields empty");
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
	@Then("Accept and continue button is disabled")
	public void accept_and_continue_button_is_disabled() throws Throwable {
		try {
			if (homePage.acceptBtn.isEnabled()) {
				Assert.assertFalse(false);
			}
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
	@When("user selects the title from the title dropdown")
	public void user_selects_the_title_from_the_title_dropdown() throws Throwable {
		try {
			webdef.selectDropdownOption(homePage.newsTitle, "index", "4");
			Thread.sleep(3000);
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
	@When("user enters <Firstname> <Lastname>")
	public void user_enters_Firstname_Lastname(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			homePage.newsFirstname.sendKeys(dataTable.cell(1, 0));
			homePage.newsLastname.sendKeys(dataTable.cell(1, 1));
			Thread.sleep(3000);
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
	@When("user clicks on Accept and continue button")
	public void user_clicks_on_Accept_and_continue_button() throws Throwable {
		try {
			Thread.sleep(3000);
				if (homePage.acceptBtn.isDisplayed()) {
					Thread.sleep(2000);
					Assert.assertTrue(true);
					webdef.JsClick(homePage.acceptBtn, driver);
					WebDriverManagedef.stepstatus = "Passed";
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
	@Then("user is on next page")
	public void user_is_on_next_page() throws Throwable {
		try {
			if (homePage.nextletterPage.getText().contains("YOU'RE ON THE LIST")) {
				// if (homePage.nextletterPage.getText().contains("BETTER TOGETHER")){
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "User list validation failed");
			}
			driver.navigate().back();
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	@Test
	@When("user ticks on i would like to receive texts from Hobbs about offers and promotions.")
	public void user_ticks_on_I_d_like_to_receive_texts_from_Hobbs_about_offers_and_promotions() throws Throwable {
		try {
			webdef.JsClick(homePage.checkbox, driver);
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
	@When("user eneters a mobile number")
	public void user_eneters_a_mobile_number(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			homePage.mobile.sendKeys(dataTable.cell(1, 0));
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
	@Then("user is on the next page")
	public void user_is_on_the_next_page() throws Throwable {
		try {
			Thread.sleep(3000);
			if (!HomePageStepDefinition.Environment.equals("LIVE")) {
				if (homePage.nextletterPage.getText().contains("YOU'RE ON THE LIST")) {
					Assert.assertTrue(true);
					WebDriverManagedef.stepstatus = "Passed";
				} else {
					WebDriverManagedef.stepstatus = "Failed";
					Assert.assertTrue(false, "User list validation failed");
				}
			}else{
			System.out.println("N/A in LIVE Env");
			WebDriverManagedef.stepstatus = "Passed";
		}
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	

	@Then("user is on account management page")
	@Test
	public void user_is_on_account_management_page() throws Throwable {
		try {
			Thread.sleep(3000);
			webdef.waiturlContains(driver, "account", 20);
			if (driver.getCurrentUrl().contains("/account")) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			}
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	@When("user clicks on Logout button")
	@Test
	public void user_clicks_on_Logout_button() throws Throwable {
		try {
			webdef.JsClick(homePage.logOut, driver);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}
	@Then("user logout from account page")
	@Test
	public void Verify_Logout() throws Throwable {
		try {
			webdef.waitTitleContains(driver, "Hobbs", 20);
			String objurl = driver.getCurrentUrl();
			if (objurl.contains("hobbs.com/")) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "User not on homepage");
			}
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}
	// ....................p3_all_storeLocator...........................................

	@Test
	@When("user clicks on find a hobbs store link from the footer")
	public void user_clicks_on_find_a_hobbs_store_link_from_the_footer() throws Throwable {
		try {
			webdef.JsScrollTo(driver, 0);
			webdef.JsClick(homePage.hobbsStore, driver);
			WebDriverManagedef.takeScreenshots(driver);
			Thread.sleep(3000);
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
	@Then("user is on store locator page")
	public void user_is_on_store_locator_page() throws Throwable {
		try {
			if (driver.getCurrentUrl().contains("/stores/")) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "User is not on store locator page");

			}
			Thread.sleep(6000);
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	@Test
	@When("user enters a town in uk")
	public void user_enters_a_town_in_uk(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			driver.navigate().refresh();
			homePage.city.sendKeys(dataTable.cell(1, 0));
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}
	  
	/* us region*/
	
	@Test
	@When("user enters a town in us")
	public void user_enters_a_town_in_us(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			homePage.city.sendKeys(dataTable.cell(1, 0));
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
	@When("user clicks on search button")
	public void user_clicks_on_search_button() throws Throwable {
		try {
			webdef.JsClick(homePage.searchButton, driver);
			Thread.sleep(3000);
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
	@Then("user views all stores in the given town")
	public void user_views_all_stores_in_the_given_town() throws Throwable {
		try {
			if (homePage.storeList.isDisplayed()) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "All store list not showing");
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
	@When("user enters a town")
	public void user_enters_a_town(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			homePage.city.clear();
			homePage.city.sendKeys(dataTable.cell(1, 0));
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
	@When("keeps the city blank")
	public void keeps_the_city_blank() throws Throwable {
		try {
			homePage.city.clear();
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
	@Then("validation error is thrown")
	public void validation_error_is_thrown() throws Throwable {
		try {
			String validationMsg = homePage.validationError.getText();
			if(validationMsg.contains("We're sorry, we couldn't find results for your search"))
			{
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus= "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false,"Validation message is not showing");
			}
		} catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	@Test
	@When("user enters <Place> in the City field")
	public void user_enters_Place_in_the_address_field(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
				
//			driver.navigate().refresh();
			Thread.sleep(2000);
			homePage.city.clear();
			homePage.city.sendKeys(dataTable.cell(1, 0));	
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
	@When("user selects a country")
	public void user_selects_a_country() throws Throwable {
		try {
			webdef.selectDropdownOption(homePage.country, "visibletext", "China");
			Thread.sleep(2000);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	// ..................p3_all_account.......................................................


	@Test
	@When("user enters email address to create Account")
	public void user_enters_existing_email_address(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			homePage.createaccountEmail.clear();
			homePage.createaccountEmail.sendKeys(dataTable.cell(1, 0));
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
	@Then("email address already in use error is thrown")
	public void email_address_already_in_use_error_is_thrown() throws Throwable {
		try {
			String validationMsg = homePage.existingEmailerror.getText();
			if (validationMsg.contains("This email is already used")) 
				{
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus= "Passed";
			} else {
				Assert.assertTrue(false,"Validation message is not shown");
				WebDriverManagedef.stepstatus = "Failed";
			}
			webdef.JsScrollBy(driver, 0, -200);
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	@Test
	@When("user clicks on update details button")
	public void user_clicks_on_update_details_button() throws Throwable {
		try {
			webdef.JsClick(homePage.updateDetailsbtn, driver);
			Thread.sleep(3000);
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
	@Then("user is on account details page")
	public void user_is_on_account_details_page() throws Throwable {
		try {
			webdef.waiturlContains(driver, "/details", 40);
			String currentPage=driver.getCurrentUrl();
			if(currentPage.contains("/account/details"))
			{
				Assert.assertTrue(true);
			 WebDriverManagedef.stepstatus = "Passed";
			}
			 else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "User is not in Account details page.");
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
	@Then("user enters current password and new password")
	public void user_enters_current_password_and_new_password(io.cucumber.datatable.DataTable dataTable)
			throws Throwable {
		try {
			webdef.JsScrollBy(driver, 0, 750);
			webdef.waitvisibilityof(driver, homePage.currentPassword, 30);
			homePage.currentPassword.sendKeys(dataTable.cell(1, 0));
			homePage.newPassword.sendKeys(dataTable.cell(1, 1));
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
	@Then("user confirms the new password")
	public void user_confirms_the_new_password(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			homePage.confirmPassword.sendKeys(dataTable.cell(1, 0));
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
	@Then("user clicks on save changes button")
	public void user_clicks_on_save_changes_button() throws Throwable {
		try {
			webdef.JsClick(homePage.passwordSavebtn, driver);
			Thread.sleep(2000);
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
	@Then("user updates title and Mobile number")
	public void user_updates_title_and_Mobile_number(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			webdef.selectDropdownOption(homePage.changeTitle, "visibletext", "Dr");
			homePage.changePhonenumber.clear();
			homePage.changePhonenumber.sendKeys(dataTable.cell(1, 0));
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
	@Then("enters password")
	public void enters_password(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			homePage.password.sendKeys(dataTable.cell(1, 0));
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
	@Then("clicks on save changes button")
	public void clicks_on_save_changes_button() throws Throwable {
		try {
			webdef.JsClick(homePage.detailsSavebtn, driver);
			Thread.sleep(3000);
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
	@When("user clicks on the edit payment and billing option")
	public void user_clicks_on_the_edit_payment_and_billing_option() throws Throwable {
		try {
			webdef.JsScrollBy(driver, 0, 250);
			webdef.JsClick(homePage.editPaymentbtn, driver);
			Thread.sleep(3000);
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
	@Then("user is on account payment page")
	public void user_is_on_account_payment_page() throws Throwable {
		try {
			webdef.waiturlContains(driver, "/payment", 40);
			if (driver.getCurrentUrl().contains("account/payment/")) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "User is not in account payment page");
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
	@Then("user clicks on edit address option")
	public void user_clicks_on_edit_address_option() throws Throwable {
		try {
			webdef.JsScrollBy(driver, 0, 250);
			webdef.JsClick(homePage.editAddressbtn, driver);
			Thread.sleep(3000);
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
	@Then("user updates the current details in the card")
	public void user_updates_the_current_details_in_the_card(io.cucumber.datatable.DataTable dataTable)
			throws Throwable {
		try {
			webdef.waitvisibilityof(driver, homePage.accFirstname, 40);
			webdef.JsScrollBy(driver, 0, 500);
			Thread.sleep(1000);
			webdef.waitElementClickable(driver, homePage.editCity, 40);
			homePage.editCity.clear();
			homePage.editCity.sendKeys(dataTable.cell(1, 0));
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
	@Then("clicks on save card details button")
	public void clicks_on_save_card_details_button() throws Throwable {
		try {
			webdef.JsScrollBy(driver, 0, 500);
			webdef.JsClick(homePage.savecardDetailsbtn, driver);
			Thread.sleep(2000);
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
	@When("user clicks on view orders button")
	public void user_clicks_on_view_orders_button() throws Throwable {
		try {
			Thread.sleep(3000);
			webdef.JsClick(homePage.viewOrderbtn, driver);
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
	@Then("user views the order details")
	public void user_views_the_order_details() throws Throwable {
		try {
			webdef.waiturlContains(driver, "/history/", 40);
			String currentPage=driver.getCurrentUrl();
			if(currentPage.contains("/orders/history"))
			{
				Assert.assertTrue(true);
			WebDriverManagedef.stepstatus = "Passed";
			}
			else {
					WebDriverManagedef.stepstatus = "Failed";
					Assert.assertTrue(false, "User is not in Order history page");
				}
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
	@When("user clicks on preference centre button")
	public void user_clicks_on_preference_centre_button() throws Throwable {
		try {
			driver.navigate().refresh();
			webdef.waitElementClickable(driver, homePage.preferenceStorebtn, 40);
			webdef.JsClick(homePage.preferenceStorebtn, driver);
			Thread.sleep(3000);
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
	@Then("user is on Account-preference page")
	public void user_is_on_Account_preference_page() throws Throwable {
		try {
			if (driver.getCurrentUrl().contains("/Account-PreferenceCenter")) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "User is not in Account-preference page");
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
	@When("user enters prefered town")
	public void user_enters_prefered_town(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			webdef.JsScrollBy(driver, 0, 100);
			webdef.JsClick(homePage.postalCode, driver);
			homePage.postalCode.sendKeys(dataTable.cell(1, 0));
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
	@When("user selects {string} from the  address dropdown")
	public void user_selects_from_the_address_dropdown(String store) throws Throwable {
		try {
			WebElement element = homePage.favoriteStore(store);
			element.click();
			Thread.sleep(6000);
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
	@When("user clicks on add a preferred store button")
	public void user_clicks_on_add_a_preferred_store_button() throws Throwable {
		try {
			webdef.JsClick(homePage.storeAddbtn, driver);
			Thread.sleep(25000);
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
	@Then("preferred store is added to the site")
	public void preferred_store_is_added_to_the_site() throws Throwable {
		try {
			oldStore = homePage.favStoreText.getText();
			if (homePage.favStoreText.isDisplayed()) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "Preferred store is not added to the site");

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
	@When("when user clicks on the change button from Account-preference page")
	public void when_user_clicks_on_the_change_button_from_Account_preference_page() throws Throwable {
		try {
			webdef.JsClick(homePage.changeStorebtn, driver);
			Thread.sleep(3000);
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
	@Then("preferred store is added to the website")
	public void preferred_store_is_added_to_the_website() throws Throwable {
		try {
			String updatedstorename = homePage.favStoreText.getText();
			if (oldStore != updatedstorename) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "Preferred store is not added to the website");
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
	@When("user clicks on the remove choice button from Account-preference page")
	public void user_clicks_on_the_remove_choice_button_from_Account_preference_page() throws Throwable {
		try {
			webdef.JsClick(homePage.changeStorebtn, driver);
			Thread.sleep(3000);
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
	@Then("preferred store is removed from the website")
	public void preferred_store_is_removed_from_the_website() throws Throwable {
		try {
			if (homePage.postalCode.isDisplayed()) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "Preferred store is not removed from the website");
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
	@When("user clicks on the Log out button from the account management page")
	public void user_clicks_on_the_Log_out_button_from_the_account_management_page() throws Throwable {
		try {
			webdef.JsScrollintoView(driver, homePage.logOut);
			webdef.JsClick(homePage.logOut, driver);
			Thread.sleep(3000);
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
	@Then("user is logged out from account management page")
	public void user_is_logged_out_from_account_management_page() throws Throwable {
		try {
			if (homePage.mainPage.isDisplayed()) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "User is not logged out from account management page");
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
    @When("user enters <Order number><Order email> and <Billing postcode>")
    public void user_enters_Order_number_Order_email_and_Billing_postcode(io.cucumber.datatable.DataTable dataTable)
            throws Throwable {
		 if (!Environment.equals("LIVE"))
			{
			 try {
	            String orderID=dataTable.cell(1, 0);
	            String[] orderIDVal=orderID.split(",");
	            if (Environment.equals("DEV"))
	                orderID=orderIDVal[0];
	            else
	                orderID=orderIDVal[1];
	            homePage.orderNumber.sendKeys(orderID);
	            homePage.orderEmail.sendKeys(dataTable.cell(1, 1));
	            homePage.orderPostcode.sendKeys(dataTable.cell(1, 2));
	            WebDriverManagedef.stepstatus= "Passed";
		        }catch (AssertionError | Exception  e) {
		            WebDriverManagedef.stepstatus = "Failed";
		            WebDriverManagedef.error = (e.getMessage());
		        }
			}
			else
			{
				Assert.assertTrue(true, "Scenario is N/A for LIVE environment");
				WebDriverManagedef.stepstatus = "Passed";
			}
     if (WebDriverManagedef.stepstatus == "Failed") {
         Assert.assertTrue(false);
     }

    }

	@Test
	@When("clicks on view status button")
	public void clicks_on_view_status_button() throws Throwable {
		if (!Environment.equals("LIVE"))
		{
			try {
				webdef.JsClick(homePage.vieworderStatus, driver);
				WebDriverManagedef.stepstatus = "Passed";
				Thread.sleep(3000);
			} catch (AssertionError | Exception e) {
				WebDriverManagedef.stepstatus = "Failed";
				WebDriverManagedef.error = (e.getMessage());
			}
		}
		else
		{
			Assert.assertTrue(true, "Scenario is N/A for LIVE environment");
			WebDriverManagedef.stepstatus = "Passed";
		}	
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	@Test
	@Then("user is on order tracking page")
	public void user_is_on_order_tracking_page() throws Throwable {
		if (!Environment.equals("LIVE"))
		{
				try {
					if (driver.getCurrentUrl().contains("/customer-service/order-tracking/details/")) {
						Assert.assertTrue(true);
						WebDriverManagedef.stepstatus = "Passed";
					} else {
						WebDriverManagedef.stepstatus = "Failed";
						Assert.assertTrue(false, "user is not in order tracking page");
					}
		
				} catch (AssertionError | Exception e) {
					WebDriverManagedef.stepstatus = "Failed";
					WebDriverManagedef.error = (e.getMessage());
				}
		}
		else
		{
			Assert.assertTrue(true, "Scenario is N/A for LIVE environment");
			WebDriverManagedef.stepstatus = "Passed";
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	// ..............................p3_all_account.............................................
	@Test
	@When("user enters a valid Email address")
	public void user_enters_a_valid_Email_address() throws Throwable {
		try {
			Thread.sleep(2000);
			homePage.createaccountEmail.clear();
			String user = webdef.getSaltString();
			String NewuserAccount = "G10X_"+user + "_G10x@gmail.com";
			System.out.println(NewuserAccount + " :user account");
			homePage.createaccountEmail.sendKeys(NewuserAccount);
			Thread.sleep(2000);
			WebDriverManagedef.takeScreenshots(driver);
			email = homePage.createaccountEmail.getAttribute("value");
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
	@When("user enters  valid email and password")
	public void user_enters_valid_email_and_password(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			homePage.loginEmail.sendKeys(email);
			homePage.loginPassword.sendKeys(dataTable.cell(1, 0));
			WebDriverManagedef.takeScreenshots(driver);
			Thread.sleep(3000);
			WebDriverManagedef.stepstatus = "Passed";
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}
	
	@Then("Please enter a valid email address error  is caught")
	@Test
	public void please_enter_a_valid_email_address_error_is_caught() throws Throwable {
		try {
			Thread.sleep(2000);
			 if (homePage.badEmailerror.isDisplayed())
			{
				 webdef.highlightObjects(driver,homePage.badEmailerror);
				 Assert.assertTrue(true);
				WebDriverManagedef.stepstatus= "Passed";
				
			}
			else if (homePage.errormsg.isDisplayed())
			{
				 webdef.highlightObjects(driver,homePage.errormsg);
				String validationMsg = homePage.errormsg.getText();
				if(validationMsg.contains("Invalid login or password. Remember that password is case-sensitive. Please try again")) 
					{
						Assert.assertTrue(true);
						WebDriverManagedef.stepstatus= "Passed";
					}
				else {
					WebDriverManagedef.stepstatus = "Failed";
					Assert.assertTrue(false,"Valid email address error is not caught");
				}
			} 
		
			else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false,"Valid email address error is not caught");
			}
			}
			catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}
@Test
	@When("user clicks on the Accept and continue button")
	public void userClicksOnTheAcceptAndContinueButton() throws Throwable {
		try{
			if (!HomePageStepDefinition.Environment.equals("LIVE"))
			{
				if (homePage.acceptBtn.isDisplayed()) {
					Assert.assertTrue(true);
					webdef.JsClick(homePage.acceptBtn, driver);
					WebDriverManagedef.stepstatus = "Passed";
				}
			}else{
				System.out.println("You are in LIVE Env");
				WebDriverManagedef.stepstatus = "Passed";
			}
		} catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
	if (WebDriverManagedef.stepstatus == "Failed") {
		Assert.assertTrue(false);
	}
	}
}
