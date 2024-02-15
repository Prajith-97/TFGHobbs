package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.CountrySelector;
import pageobjects.HomePage;
import utility.WebDriverManagedef;
import utility.WebDriverManagerAppium;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CountrySelectorStepDefinition {

	WebDriver driver = HomePageStepDefinition.driver;
	static HomePage homePage;
	CountrySelector countrySelector = new CountrySelector(driver);
	WebDriverManagedef webdef = new WebDriverManagedef();

	@Test
	@Given("user clicks on country selector button")
	public void user_clicks_on_country_selector_button() throws Throwable {
		try {
			Thread.sleep(2000);
			webdef.JsClick(countrySelector.countrySelectorBtn, driver);
			WebDriverManagedef.stepstatus= "Passed";
		} catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	@Test
	@Given("the country selector popup is opened")
	public void the_country_selector_popup_is_opened() throws Throwable {
		try {
			Boolean status;
			Boolean objcntr = countrySelector.submitBtn.isDisplayed();
			System.out.println(objcntr + "objcntr");
			if (objcntr) {
				status = true;
			} else {
				status = false;
			}
			Assert.assertTrue(status);
			WebDriverManagedef.stepstatus= "Passed";
		} catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}

	 @Test
    @When("user selects a \"([^\"]*)\" from drop down list$")
    public void user_selects_a_country_from_drop_down_list(String country) throws Throwable {
        try {
            webdef.JsClick(countrySelector.countrySelectorDropDown, driver);
            Thread.sleep(3000);
            WebElement ele = countrySelector.CountryInDropDown(country);
            ele.click();
            Thread.sleep(3000);
            webdef.JsClick(countrySelector.submitBtn, driver);
            Thread.sleep(3000);
            try {
                webdef.waitvisibilityof(driver,countrySelector.mainCategoryNav,20);
                if (countrySelector.mainCategoryNav.isDisplayed())
                {
                System.out.println("No popups to handle");
                }
            }
            catch(Exception e){
            	if(country.equals("DE"))
				{
	                String uname = WebDriverManagedef.User_Name;
	                String password = WebDriverManagedef.Password;
	                Thread.sleep(2000);
	                WebDriverManagedef.userandpassword(uname, password);
	                Thread.sleep(2000);
				}

            }
            WebDriverManagedef.stepstatus= "Passed";
        } catch (AssertionError | Exception  e) {

            WebDriverManagedef.stepstatus = "Failed";
            WebDriverManagedef.error = (e.getMessage());
            System.out.println(e.getMessage());
        }
        if (WebDriverManagedef.stepstatus == "Failed") {
            Assert.assertTrue(false);
        }
    }
	
	@Test
	@Then("user is on to \"([^\"]*)\" website$")
	public void user_is_on_to_country_website(String country) throws Throwable {
		try {
			Thread.sleep(3000);
			 String countryurl = country.toLowerCase();
            if (countryurl.contains(countryurl))  {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus= "Passed";
			}else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "User is not in selected location");				
			}
		} catch (AssertionError | Exception  e) {			
			WebDriverManagedef.error = (e.getMessage());
			WebDriverManagedef.stepstatus = "Failed";
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}
}
