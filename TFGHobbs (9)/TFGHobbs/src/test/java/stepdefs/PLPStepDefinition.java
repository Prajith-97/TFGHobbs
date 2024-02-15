package stepdefs;

import static org.testng.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import pageobjects.PDP;
import pageobjects.PLP;
import utility.WebDriverManagedef;
import utility.WebDriverManagerAppium;

public class PLPStepDefinition {
	WebDriver driver = HomePageStepDefinition.driver;
	PLP plp = new PLP(driver);
	PDP pdp = new PDP(driver);
	HomePage homePage = new HomePage(driver);
	HomePageStepDefinition homepage = new HomePageStepDefinition();
	WebDriverManagedef webdef = new WebDriverManagedef();
	public static String productname ;
	static String statusBefore = null;
	public static String productplp;
	static String statusAfter = null, srcupdated=null;
	static Boolean statusoutofstock,value;
	public static int count = 1;
	int currentpagecount;
																

	@Test
	@When("user clicks on <ActionPoint> of the <Product> on PLP")
	public void user_clicks_on_action_point_of_the_product_on_plp(io.cucumber.datatable.DataTable dataTable)
			throws Throwable {
		try {
		Thread.sleep(2300);
		webdef.JsClick(plp.ProductNameInPLP(dataTable.cell(1, 0)), driver);
		WebDriverManagedef.takeScreenshots(driver);
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
	@Then("user is on PDP page")
	public void user_is_on_PDP_page() throws Throwable {
	   try {
		   Thread.sleep(10000);
		   if(driver.getCurrentUrl().contains("/product/"))
		   {
			   Assert.assertTrue(true, "user is on product details page");
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
	@When("user clicks on hide filter button on PLP")
	public void user_clicks_on_hide_filter_button_on_plp() throws Throwable {
		try {
		webdef.JsClick(plp.hideFilterBtn, driver);
		WebDriverManagedef.takeScreenshots(driver);
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
	@When("user clicks on filter button on PLP for Mobile")
	public void user_clicks_on_hide_filter_button_on_plp_mobile() throws Throwable {
		try {
		webdef.waitElementClickable(driver, plp.FilterBtnMobile, 10);
		webdef.JsClick(plp.FilterBtnMobile, driver);
		Thread.sleep(3000);
		WebDriverManagedef.takeScreenshots(driver);
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
	@Then("user is on filter panel")
	public void userIsOnFilterPanel() {
	        try{
	            if(plp.filterPanel.isDisplayed()){
	                Assert.assertTrue(true);
	            }else{
	                Assert.assertTrue(false,"user is not in filter panel");
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
	@Then("show filter section is displayed on PLP")
	public void show_filter_section_is_displayed_on_plp() throws Throwable {
		try {
		if (plp.hideFilterBtn.isDisplayed()) {
			WebDriverManagedef.stepstatus= "Passed";
			Assert.assertTrue(true);
		} else {

			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "Show filter section is not displayed on PLP");
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
	@When("user clicks on show filter button on PLP")
	public void user_clicks_on_show_filter_button_on_plp() throws Throwable {
		try {
		Thread.sleep(3000);
		if (plp.showFilterBtn.isDisplayed()) {
			webdef.JsClick(plp.showFilterBtn, driver);
			WebDriverManagedef.stepstatus= "Passed";
		}else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "User not able to clicks on show filter button on PLP");
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
	@Then("hide filter option is displayed on PLP")
	public void hide_filter_option_is_displayed_on_plp() throws Throwable {
		try {
		if (plp.showFilterBtn.isDisplayed()) {
			WebDriverManagedef.stepstatus= "Passed";
			Assert.assertTrue(true);
		} else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "Hide filter option is not displayed on PLP");			
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
	@When("user applies a filter of <FilterName> in <MainFilter> on PLP")
	public void user_applies_a_filter_of_filter_name_in_main_filter_on_plp(io.cucumber.datatable.DataTable dataTable)
			throws Throwable {
		try {
		Thread.sleep(2000);
		webdef.JsScrollBy(driver, 0, 100);
		String textmainfilter = plp.MainFilter(dataTable.cell(1, 0)).getText();
		Thread.sleep(2000);
		if (textmainfilter.contains(dataTable.cell(1, 0))) {
			webdef.JsClick(plp.FilterTypeFit(dataTable.cell(1, 1)), driver);
			Thread.sleep(10000);
			WebDriverManagedef.stepstatus= "Passed";
		}else {			
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "Filter not applied");
		}
		Thread.sleep(2000);	
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	//...........................for Us region...........................................
	
	@Test
	@When("user applies filter of <FilterName> in <MainFilter> on PLP")
	public void user_applies_filter_of_filter_name_in_main_filter_on_plp(io.cucumber.datatable.DataTable dataTable)
			throws Throwable {
		try {
		Thread.sleep(2000);
		webdef.JsScrollBy(driver, 0, 100);
		String textmainfilter = plp.MainFilter(dataTable.cell(1, 0)).getText();
		Thread.sleep(2000);
		if (textmainfilter.contains(dataTable.cell(1, 0))) {
			webdef.JsClick(plp.Filtercolour(dataTable.cell(1, 1)), driver);
			Thread.sleep(10000);
			WebDriverManagedef.stepstatus= "Passed";
		}else {			
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "Filter not applied");
		}
		Thread.sleep(2000);	
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

//......................................................................................
	@Test
	@When("user applies a single filter of <FilterName> in <MainFilter> on PLP")
	public void user_applies_a_single_filter_of_filter_name_in_main_filter_on_plp(
			io.cucumber.datatable.DataTable dataTable) throws Throwable {
		Thread.sleep(2000);
		try {
			if (plp.MainFilter(dataTable.cell(1, 0)).isDisplayed()) {
				if (plp.Filtercolour(dataTable.cell(1, 1)).isDisplayed()){
					webdef.waitElementClickable(driver, plp.Filtercolour(dataTable.cell(1, 1)), 20);
					WebElement ele = plp.Filtercolour(dataTable.cell(1, 1));
					webdef.JsClick(ele, driver);
					Thread.sleep(10000);
				}
				Assert.assertTrue(true);
			}
			
		} catch (AssertionError | Exception e) {
			if (plp.Filtercolor(dataTable.cell(1, 1)).isDisplayed()){
				webdef.waitElementClickable(driver, plp.Filtercolor(dataTable.cell(1, 1)), 20);
				WebElement ele = plp.Filtercolor(dataTable.cell(1, 1));
				webdef.JsClick(ele, driver);
				Thread.sleep(6000);
				Assert.assertTrue(true);
			}
			else {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
			}
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}
	}
	@Test
	@When("user clicks on the cross icon of a single filter applied on PLP")
	public void user_clicks_on_the_cross_icon_of_a_single_filter_applied_on_PLP() throws Throwable {
	  try {
		  webdef.JsClick(plp.singlefilterCloseBtn, driver);
		  Thread.sleep(10000);
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
	@When("user applies a filter of <FilterName> in <MainFilter> on PLP for mobile")
	public void user_applies_a_filter_of_filter_name_in_main_filter_on_plp_mobile(
			io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
		Thread.sleep(10000);
		webdef.JsScrollBy(driver, 0, 170);
		if (plp.MainFilter(dataTable.cell(1, 0)).isDisplayed()) {
			String textmainfilter = plp.MainFilter(dataTable.cell(1, 0)).getText();
			Thread.sleep(10000);
			if (textmainfilter.contains(dataTable.cell(1, 0))) {
				webdef.JsClick(plp.FilterTypeFit(dataTable.cell(1, 1)), driver);
			}
		
			Thread.sleep(2000);
			WebDriverManagedef.stepstatus= "Passed";
		}else {
			
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "Filter not applied");
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
	@Then("<FilterName> filter is applied on PLP")
	public void filter_name_filter_is_applied_on_plp(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			Thread.sleep(6000);
		if (plp.appliedfilters(dataTable.cell(1, 0)).isDisplayed()||plp.appliedfiltermobile(dataTable.cell(1, 0)).isDisplayed()) {			
			Assert.assertTrue(true);
			WebDriverManagedef.stepstatus= "Passed";
		}else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "Filter not applied");
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
	@Then("user removes a filter from applied filter on PLP")
	public void removes_a_filter(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
		Thread.sleep(3000);
		System.out.println(plp.appliedfilters(dataTable.cell(1, 0)).getText());
		webdef.JsClick(plp.clearallfilters, driver);
		webdef.waitInvisibilityOf(driver, plp.applyFilter(dataTable.cell(1, 0)), 20);
		//if(plp.appliedfilters(dataTable.cell(1, 0)).isDisplayed()) {
			if(plp.FilterTypeFit(dataTable.cell(1, 0)).isDisplayed())
			{
			WebDriverManagedef.stepstatus= "Passed";
			Assert.assertTrue(true);
		}else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "user not able to removes a filter from applied filter on PLP");
		}		
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
			System.out.println(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}

	}
	@Test
	@When("user clicks on forward_arrow button")
	public void user_clicks_on_forward_arrow_button() throws Throwable {
	    
		try {
			Thread.sleep(16000);
			Boolean value = false;
			String stylescount = plp.Stylesavailable().replaceAll(" styles available", "");
			System.out.println(stylescount + " styles count");
			int count = Integer.parseInt(stylescount);
			if (count > 60) {
				value = true;
			}
			if (value) {
				int pgcount = Integer.parseInt(plp.pagecount.getText());
				System.out.println(pgcount + "page count");
				currentpagecount=Integer.parseInt(plp.currentpagePLP.getText());
				for (int i = 1; i <= pgcount - 1; i++) {
					webdef.JsClick(plp.paginationfrwd, driver);
					Thread.sleep(15000);
					WebDriverManagedef.takeScreenshots(driver);
					
				}
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
	@Then("user is on NEXT page")
	public void user_is_on_NEXT_page() {
	   try {
		int pagevalue=Integer.parseInt(plp.currentpagePLP.getText());
		if(currentpagecount != pagevalue)
		{
			Assert.assertTrue(true, "forward pagination successful");
			WebDriverManagedef.stepstatus = "Passed";
		}
		else {
			Assert.assertTrue(false, "forward pagination failed");
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

	@Test
	@When("user clicks on backward_arrow button")
	public void user_clicks_on_backward_arrow_button() throws Throwable {
		try {
			Thread.sleep(16000);
			Boolean value = false;
			String stylescount = plp.Stylesavailable().replaceAll(" styles available", "");
			System.out.println(stylescount + " styles count");
			int count = Integer.parseInt(stylescount);
			if (count > 60) {
				value = true;
			}
			if (value) {
				int pgcount = Integer.parseInt(plp.pagecount.getText());
				System.out.println(pgcount + " page count");
				for (int i = pgcount - 1; i >= 1; i--) {
					webdef.JsClick(plp.paginationback, driver);
					Thread.sleep(20000);
					WebDriverManagedef.takeScreenshots(driver);

				}
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
	@Then("user is on PREVIOUS page")
	public void user_is_on_PREVIOUS_page() {
		try {
			int pagevalue=Integer.parseInt(plp.currentpagePLP.getText());
			if(currentpagecount == pagevalue)
			{
				Assert.assertTrue(true, "backward pagination successful");
				WebDriverManagedef.stepstatus = "Passed";
			}
			else {
				Assert.assertTrue(false, "backward pagination failed");
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

	@Test
	@Then("single filter is removed from applied filter on plp")
	public void single_filter_is_removed_from_applied_filter_on_plp() {
		try {   
			Thread.sleep(20000);
		Boolean status=plp.appliedFilterArea.isDisplayed();
		if(status==true) {
			Assert.assertTrue(false, "Filter not removed");
			WebDriverManagedef.stepstatus = "Failed";
		}
	   
	   } catch(Exception exp) {
		   Assert.assertTrue(true, " your Filter removed");
		   WebDriverManagedef.stepstatus = "Passed";
		   WebDriverManagedef.error = (exp.getMessage());
		   
	   }
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

		}
	@Test
	@Then("user removes a filters from applied filter on PLP")
	public void removes_a_filters(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
		Thread.sleep(3000);
		System.out.println(plp.appliedfilters(dataTable.cell(1, 0)).getText());
		webdef.JsClick(plp.clearallfilters, driver);
		webdef.waitInvisibilityOf(driver, plp.applyFilter(dataTable.cell(1, 0)), 20);
		//if(plp.appliedfilters(dataTable.cell(1, 0)).isDisplayed()) {
			if(plp.Filtercolour(dataTable.cell(1, 0)).isDisplayed())
			{
			WebDriverManagedef.stepstatus= "Passed";
			Assert.assertTrue(true);
		}else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "user not able to removes a filter from applied filter on PLP");
		}		
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
			System.out.println(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}

	}

	@Test
	@Then("user removes multiple filter from applied filter on PLP")
	public void removes_multiple_filter(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
		Thread.sleep(4000);
		System.out.println(plp.appliedfilters(dataTable.cell(2, 0)).getText());
		webdef.JsClick(plp.clearallfilters, driver);
		webdef.waitInvisibilityOf(driver, plp.applyFilter(dataTable.cell(2, 0)), 50);
		try {
			plp.appliedfilters(dataTable.cell(2, 0)).isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue(true);	
			WebDriverManagedef.stepstatus= "Passed";
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
	@When("user applies multiple filter of <FilterName> in <MainFilter> on PLP")
	public void user_applies_multiple_filter_of_filter_name_in_main_filter_on_plp(
			io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
			if (plp.MainFilter(dataTable.cell(1, 0)).isDisplayed()) {
				try {
				if (plp.Filtercolour(dataTable.cell(1, 1)).isDisplayed()){
					webdef.waitElementClickable(driver, plp.Filtercolour(dataTable.cell(1, 1)), 20);
					WebElement ele = plp.Filtercolour(dataTable.cell(1, 1));
					webdef.JsClick(ele, driver);
					Thread.sleep(25000);
					}
				}
				 catch (Exception notfound) {
					webdef.waitElementClickable(driver, plp.Filtercolor(dataTable.cell(1, 1)), 20);
					WebElement ele = plp.Filtercolor(dataTable.cell(1, 1));
					webdef.JsClick(ele, driver);
				}
			}
			Thread.sleep(25000);
			if (plp.MainFilter(dataTable.cell(2, 0)).isDisplayed()) {
				webdef.waitElementClickable(driver, plp.Filterpattern(dataTable.cell(2, 1)), 20);
				WebElement ele = plp.Filterpattern(dataTable.cell(2, 1));
				webdef.JsClick(ele, driver);
				Thread.sleep(15000);
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


	@Test
	@Then("filters are applied on plp")
	public void VerifyAppliedfilters() throws Throwable {
		try {
			if (plp.clearallfilters.isDisplayed())
			{
				WebDriverManagedef.takeScreenshots(driver);
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
	@When("user applies all filters <FilterName> in <MainFilter> on PLP")
	public void user_applies_all_filter_of_filter_name_in_main_filter_on_plp(io.cucumber.datatable.DataTable dataTable)
			throws Throwable {
		webdef.JsScrollBy(driver, 0, 100);
		Thread.sleep(7000);
		try {
			try {
			if (plp.MainFilter(dataTable.cell(1, 0)).isDisplayed()) {
				if (plp.Filtercolour(dataTable.cell(1, 1)).isDisplayed()){
					webdef.waitElementClickable(driver, plp.Filtercolour(dataTable.cell(1, 1)), 20);
					WebElement ele = plp.Filtercolour(dataTable.cell(1, 1));
					webdef.JsClick(ele, driver);
					Thread.sleep(25000);
					}
				}
			}
			catch (Exception notfound) {
				webdef.waitElementClickable(driver, plp.Filtercolor(dataTable.cell(1, 1)), 20);
				WebElement ele = plp.Filtercolor(dataTable.cell(1, 1));
				webdef.JsClick(ele, driver);
				}
			Thread.sleep(25000);
			if (plp.MainFilter(dataTable.cell(2, 0)).isDisplayed()) {
				String uksize = plp.MainFilter(dataTable.cell(2, 0)).getText();
				if (uksize.contains(dataTable.cell(2, 0))) {
					webdef.JsClick(plp.FilterTypeUKSize(dataTable.cell(2, 1)), driver);
					Thread.sleep(25000);
				}
			}
			if (plp.MainFilter(dataTable.cell(3, 0)).isDisplayed()) {
				String textsubfilter = plp.MainFilter(dataTable.cell(3, 0)).getText();
				if (textsubfilter.contains(dataTable.cell(3, 0))) {
					webdef.JsClick(plp.FilterTypeSleeve(dataTable.cell(3, 1)), driver);
					Thread.sleep(25000);
				}
			}
			if (plp.MainFilter(dataTable.cell(4, 0)).isDisplayed()) {
				String pattern = plp.MainFilter(dataTable.cell(4, 0)).getText();
				if (pattern.contains(dataTable.cell(4, 0))) {
					webdef.JsClick(plp.Filterpattern(dataTable.cell(4, 1)), driver);
					Thread.sleep(25000);
				}
			}

			if (plp.MainFilter(dataTable.cell(5, 0)).isDisplayed()) {
				String textmainfilter = plp.MainFilter(dataTable.cell(5, 0)).getText();
				if (textmainfilter.contains(dataTable.cell(5, 0))) {
					webdef.JsClick(plp.FilterTypeFit(dataTable.cell(5, 1)), driver);
					Thread.sleep(25000);
				}
			}
			
			if (plp.MainFilter(dataTable.cell(6, 0)).isDisplayed()) {
				String textneckline = plp.MainFilter(dataTable.cell(6, 0)).getText();
				if (textneckline.contains(dataTable.cell(6, 0))) {
					webdef.JsClick(plp.Filterneckline(dataTable.cell(6, 1)), driver);
					Thread.sleep(20000);
				}
			}

//			if (plp.MainFilter(dataTable.cell(7, 0)).isDisplayed()) {
//				String style = plp.MainFilter(dataTable.cell(7, 0)).getText();
//				if (style.contains(dataTable.cell(7, 0))) {
//					webdef.JsClick(plp.Filterstyle(dataTable.cell(7, 1)), driver);
//					Thread.sleep(20000);
//				}
//			}
//			if (plp.MainFilter(dataTable.cell(8, 0)).isDisplayed()) {
//				String style = plp.MainFilter(dataTable.cell(8, 0)).getText();
//				if (style.contains(dataTable.cell(8, 0))) {
//					webdef.JsClick(plp.Filternlength(dataTable.cell(8, 1)), driver);
//					Thread.sleep(20000);
//				}
//			}
		Thread.sleep(6000);
		WebDriverManagedef.takeScreenshots(driver);
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
	@When("user removes all filters on PLP")
	public void user_removes_all_filter_of_filter_name_in_main_filter_on_plp(io.cucumber.datatable.DataTable dataTable)
			throws Throwable {
		try {
		Thread.sleep(1000);
		Boolean value = false;
		System.out.println(plp.appliedfilters(dataTable.cell(1, 0)).getText());
		if (plp.clearallfilters.isDisplayed()) {
			value = true;
			webdef.JsClick(plp.clearallfilters, driver);
			Thread.sleep(21000);
			WebDriverManagedef.takeScreenshots(driver);

		}
		Assert.assertTrue(value);
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
			System.out.println(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@When("user checks for available products in PLP")
	public void user_check_product_from_PLP() throws Throwable {
		try {
		webdef.waitvisibilityof(driver, plp.Availabilitycheckbox, 12);
		webdef.JsClick(plp.Availabilitycheckbox, driver);
		Thread.sleep(13000);
		int prodcutslist = plp.Availabilityproducts().size();
		if (prodcutslist > 0) {
			System.out.println(prodcutslist + "prodcuts lisr count");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false,"Products are not available in PLP");
		}
		WebDriverManagedef.takeScreenshots(driver);
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
	@When("user checks the availability of products in PLP")
	public void user_checks_the_availability_of_products_in_PLP() throws Throwable {
		try {
		webdef.JsClick(plp.filterInMobile, driver);
		webdef.waitvisibilityof(driver, plp.Availabilitycheckbox, 12);
		webdef.JsClick(plp.Availabilitycheckbox, driver);
		Thread.sleep(13000);
		int prodcutslist = plp.Availabilityproducts().size();
		if (prodcutslist > 0) {
			System.out.println(prodcutslist + "prodcuts list count");
			Assert.assertTrue(true);
			WebDriverManagedef.takeScreenshots(driver);

		} else {
			Assert.assertTrue(false);
		}
		Thread.sleep(2000);
		webdef.JsClick(plp.applyFiltersInMobile, driver);
		WebDriverManagedef.takeScreenshots(driver);
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
	@When("user selects the products from PLP")
	public void select_random_product_from_PLP() throws Throwable {
		try {
			Thread.sleep(10000);
			webdef.JsScrollBy(driver, 0, 200);
			int count = plp.allProductsCountInPLP().size();
			System.out.println("Total products in current page:" + count);
			for (int num = 1; num <= count;) {
					statusoutofstock=plp.CheckoutofStock(num).isDisplayed();
					System.out.println("OUTOFSTOCK     :"+statusoutofstock);
					if(statusoutofstock==false)
					{	
					System.out.println("product display status: " + plp.selectlproductInPLP(num).isDisplayed());
					System.out.println("product name : " + plp.selectlproductInPLP(num).getText());
					productname = plp.productfromrow1.getText();
					System.out.println(productname + "product name from first row in plp");
					webdef.waitElementClickable(driver, plp.selectproduct(num), 10);
					webdef.JsClick(plp.selectproduct(num), driver);
					Thread.sleep(2000);
					break;
					}
					else {
						
						num++;
					}
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

	@Test
	@Then("user selects randon size for the product")
	public void select_random_size_from_PLP() throws Throwable {
		try {
		Thread.sleep(10000);
		int sizelist = plp.listallproductsize().size();
		if (sizelist > 0) {
			System.out.println(sizelist + "size list count");
			for (int i = 1; i <= sizelist;) {
				System.out.println(plp.selectlproductsize(i).isDisplayed() + "isDisplayed");
				System.out.println(plp.selectlproductsize(i).isEnabled() + "isenabled");
				System.out.println(plp.selectlproductsize(i).isSelected() + "isselected");
				if (plp.selectlproductsize(i).isEnabled()) {
					System.out.println(plp.selectlproductsize(i).getText() + "selected size to click");
					Thread.sleep(2000);
					webdef.JsClick(plp.selectlproductsize(i), driver);
					try {
						Boolean emailme = plp.emailmewhenavailable.isDisplayed();
						System.out.println(emailme + "emailme");
						if (emailme == true) {
							i++;
						}
					} catch (Exception e) {
						break;
					}
				}
			}
		}
		WebDriverManagedef.takeScreenshots(driver);
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
	@Then("selected size is applied to the product")
	public void selected_size_is_applied_to_the_product() {
	    
		try {
			if (!plp.sizeErrorText.isDisplayed()) {
				Assert.assertTrue(true, "Random size is selected for the product");
				WebDriverManagedef.stepstatus = "Passed";
			}
			else {
				
				Assert.assertTrue(false, "Random size selection failed");
				WebDriverManagedef.stepstatus = "failed";
			}
		} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
		}
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}

	// --------------p2_all_desktop_plp............................................
	@Test
	@Then("user selects sort option from the sort dropdown")
	public void Price_Low_to_High(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
		Thread.sleep(2000);
		webdef.dropdpwnvalue(plp.Drodpwnsortselection, dataTable.cell(0, 0));
		Thread.sleep(10000);
		WebDriverManagedef.takeScreenshots(driver);
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
	@Then("products are sorted in low to high price")
	public void verify_Price_Low_to_High() throws Throwable {
		try {
		ArrayList<Integer> myList = new ArrayList<>();
		Thread.sleep(1000);
		int sizeofprices = plp.productspricevalues().size();
		System.out.println(sizeofprices + "string array of values");
		List<WebElement> pricevalues = plp.productspricevalues();
		for (int i = 1; i <= pricevalues.size(); i++) {
			try {
				String prices = plp.productprice(i).getText();
				System.out.println(prices);
				String prices1 = prices.replaceAll("�", "");
				myList.add(Integer.parseInt(prices1));
			} catch (Exception e) {
				i++;
			}
			i++;
		}

		Boolean isSorted = webdef.sortedverifylist(myList);
		System.out.println(isSorted + " is Sorted");
		System.out.println(myList + "List values");
		Assert.assertTrue(isSorted);
		Thread.sleep(3000);
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
			System.out.println(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}

	}

	@Test
	@Then("products are sorted in High to Low price")
	public void verify_Price_High_to_Low() throws Throwable {
		try {
		ArrayList<Integer> myList1 = new ArrayList<>();
		Thread.sleep(1000);
		int sizeofprices = plp.productspricevalues().size();
		System.out.println(sizeofprices + "string array of values");
		List<WebElement> pricevalues = plp.productspricevalues();
		for (int i = 1; i <= pricevalues.size();) {
			try {
				String prices = plp.productprice(i).getText();
				System.out.println(prices);
				String prices1 = prices.replaceAll("�", "");
				myList1.add(Integer.parseInt(prices1));
			} catch (Exception e) {
				i++;
			}
			i++;
		}

		Boolean isSorted = webdef.sortedverifylistdescending(myList1);
		System.out.println(isSorted + " is Sorted");
		System.out.println(myList1 + " list values");
		Assert.assertTrue(isSorted);
		Thread.sleep(3000);
		WebDriverManagedef.takeScreenshots(driver);
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
	@Then("user clear all the applied filters")
	public void clear_filters() throws Throwable {
		try {
		Thread.sleep(1000);
		webdef.JsClick(plp.clearallfilters, driver);
		Thread.sleep(20000);
		WebDriverManagedef.takeScreenshots(driver);
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
	@When("user clicks on clearAll filters")
	public void user_clicks_on_clearAll_filters() throws Throwable {
		try {
			
			webdef.waitElementClickable(driver, plp.clearallfilters, 30);
			try {
			webdef.JsClick(plp.clearallfilters, driver);
			Thread.sleep(30000);
			WebDriverManagedef.stepstatus = "Passed";
			Assert.assertTrue(true);
			}catch(Exception exp)
			{	Assert.assertTrue(false, "Element click interrupted");
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
	@Test
	@Then("all applied filters are removed from plp")
	public void all_applied_filters_are_removed_from_plp() {
		try {   
			Thread.sleep(25000);
		Boolean status=plp.appliedFilterArea.isDisplayed();
		if(status==true) {
			Assert.assertTrue(false, "Filter not removed");
			WebDriverManagedef.stepstatus = "Failed";
		}
	   
	   } catch(Exception exp) {
		   Assert.assertTrue(true, " your Filter removed");
		   WebDriverManagedef.stepstatus = "Passed";
		   WebDriverManagedef.error = (exp.getMessage());
		   
	   }
		if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
		}

	}
	
	@Test
	@When("user clicks on xx items per page")
	public void check_products() throws Throwable {
		try {
		String stylescount = plp.Stylesavailable().replaceAll(" styles available", "");
		System.out.println(stylescount + "styles count");
		int count = Integer.parseInt(stylescount);
		if (count > 60) {
			value = true;
			int prodcutslist = plp.Availabilityproducts().size();
			System.out.println(prodcutslist + "prodcuts list count");
			if (prodcutslist <= 60) {

				Assert.assertTrue(true);
			} else {

				Assert.assertTrue(false);
			}
		}
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
	@Then("user clicks ALL items per page")
	public void xx_products() throws Throwable {
		try {
		Boolean value = false;
		webdef.JsClick(plp.ALL, driver);
		Thread.sleep(15000);
		int prodcutslist = plp.Availabilityproducts().size();
		System.out.println(prodcutslist + " prodcuts list count");
		if (prodcutslist > 60) {
			value = true;
		}
		Assert.assertTrue(value);
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
	@Then("user checks the availabilty of styles per page and navigate to different pages")
	public void available_products() throws Throwable {
		try {
		Thread.sleep(16000);
		Boolean value = false;
		String stylescount = plp.Stylesavailable().replaceAll(" styles available", "");
		System.out.println(stylescount + " styles count");
		int count = Integer.parseInt(stylescount);
		if (count > 60) {
			value = true;
		}
		if (value) {
			int pgcount = Integer.parseInt(plp.pagecount.getText());
			System.out.println(pgcount + " page count");
			for (int i = 1; i <= pgcount - 1; i++) {
				webdef.JsClick(plp.paginationfrwd, driver);
				Thread.sleep(15000);
				WebDriverManagedef.takeScreenshots(driver);

			}
			for (int i = pgcount - 1; i >= 1; i--) {
				webdef.JsClick(plp.paginationback, driver);
				Thread.sleep(15000);
				WebDriverManagedef.takeScreenshots(driver);

			}
		}
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
	@Then("user click on model image toggle")
	public void model_image_toggle() throws Throwable {
		try {
		 value = false; 
		String src1 = plp.imagesrc(1);
		System.out.println(src1);
		 srcupdated = src1.replace("01.jpg?", "02.jpg?");
		System.out.println(srcupdated);
		webdef.JsClick(plp.imageswitch, driver);
		Thread.sleep(15000);
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
	@Then("verify products on model image toggle")
	public void Verify_model_image_toggle() throws Throwable {
		try {;
		String src2 = plp.imagesrc(1);
		if (srcupdated.contains(src2)) {
			value = true;
		}
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
	@Then("user clicks on image and select quick add option")
	public void quick_add() throws Throwable {
		try {
			//driver.navigate().refresh();
			//webdef.JsScrollBy(driver, 0, 500);
			Thread.sleep(3000);
		webdef.JsClick(plp.firstimagequickadd, driver);
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
	@Then("user select size and add to bag")
	public void quick_add_to_bag() throws Throwable {
		try
		{
	    //webdef.JsScrollBy(driver, 0, 500);
		 productplp = plp.productfromrow1.getText();
		System.out.println(productplp);
		int pdtsize = plp.listallQuickAddsize().size();
		if (pdtsize > 0) {
			for (int i = 2; i <= pdtsize; i++)
			{
				webdef.waitElementClickable(driver, plp.qickaddSize(i), 30);
				webdef.JsClick(plp.qickaddSize(i), driver);
				plp.qickaddSize(i).click();
				Thread.sleep(3000);
				webdef.waitvisibilityof(driver, plp.BagAddQuick, 30);
				
				Thread.sleep(3000);
				
				Boolean status=plp.BagAddQuick.isDisplayed();
				if(status==true)
				{
					System.out.println("selected size : :"+plp.qickaddSize(i).getText());
					webdef.JsClick(plp.BagAddQuick, driver);
					Thread.sleep(3000);
					break;
					
				}
			}
		}
		Assert.assertTrue(true);
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
	@Then("user verify product in basket")
	public void verify_product() throws Throwable {
		try {
			Thread.sleep(4000);
			webdef.JsClick(pdp.viewBag, driver);
			Thread.sleep(2000);
			System.out.print("Product in PLP : "+productplp);
			Assert.assertEquals(pdp.productnameinbag.getText().toLowerCase(), productplp.toLowerCase());
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
	@Then("user clicks on available items per page")
	public void available_product() throws Throwable {
		try {
		webdef.JsClick(plp.listeditems, driver);
		Thread.sleep(50000);
		int productlist = plp.Availabilityproducts().size();
		System.out.println(productlist + "prodcuts list count");
		if (productlist >= 60) {

			Assert.assertTrue(true);
			WebDriverManagedef.takeScreenshots(driver);
			WebDriverManagedef.stepstatus= "Passed";
		} else {

			WebDriverManagedef.stepstatus="Failed";	
			Assert.assertTrue(false);
		}
		
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
		webdef.JsClick(plp.listeditems, driver);
		Thread.sleep(50000);

	}

	// ....................................p2_all_desktop_wishlist................................
	@Test
	@When("user clicks on wishlist icon from header")
	public void user_clicks_on_wishlist_icon_from_header() throws Throwable {
		try {
		webdef.JsClick(plp.wishlistIcon, driver);
		WebDriverManagedef.takeScreenshots(driver);
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
	@Then("user is on wishlist page and views the empty wishlist")
	public void user_is_on_wishlist_page_and_views_the_empty_wishlist() throws Throwable {
		try {
		if (plp.emptyWishlist.getText().contains("START SHOPPING")) {
			Assert.assertTrue(true);
		} else {

			Assert.assertTrue(false);
		}
		WebDriverManagedef.takeScreenshots(driver);
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
	@Then("product added to wishlist")
	public void product_added_to_wishlist() throws Throwable {
		try {
		String message=PDPStepDefinition.msg;
		if (message.contains("Added to Wishlist")) {
			Assert.assertTrue(true);
		} else {

			Assert.assertTrue(false);

		}
		WebDriverManagedef.takeScreenshots(driver);
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
	@Then("user is on wishlist Page")
	public void user_is_on_wishlist_Page() throws Throwable {
		try {
			webdef.waiturlContains(driver,"/wishlist/",30);
		if (driver.getCurrentUrl().contains("/wishlist/")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		WebDriverManagedef.takeScreenshots(driver);
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
	@When("user clicks on close button of the product")
	public void user_clicks_on_close_button_of_the_product() throws Throwable {
		try {
		Thread.sleep(4000);
		webdef.JsClick(plp.productCloseBtn, driver);
		Thread.sleep(2000);
		WebDriverManagedef.takeScreenshots(driver);
		driver.navigate().refresh();
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
	@Then("product is removed from wishlist")
	public void product_is_removed_from_wishlist() throws Throwable {
		try {
		if (plp.emptyWishlist.getText().contains("START SHOPPING")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		WebDriverManagedef.takeScreenshots(driver);
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
	@When("user selects the size from the size dropdown")
	public void user_selects_the_size_from_the_size_dropdown() throws Throwable {
		try {
			Thread.sleep(2000);
			webdef.JsScrollBy(driver, 0, 500);
			Thread.sleep(1000);
			webdef.selectDropdownOption(plp.size, "index", "2");
			WebDriverManagedef.takeScreenshots(driver);
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
	@When("user clicks on ADD button")
	public void user_clicks_on_ADD_button() throws Throwable {
		try {
		
		if (plp.addtoBag.isDisplayed()) {
			webdef.JsClick(plp.addtoBag, driver);
		}
		Thread.sleep(2000);
		WebDriverManagedef.takeScreenshots(driver);
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
	@Then("product is added to bag")
	public void product_is_added_to_bag() throws Throwable {
		try {
		webdef.JsClick(pdp.viewBag, driver);
		Thread.sleep(2000);
		if (plp.productInBag.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		WebDriverManagedef.takeScreenshots(driver);
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
	@When("user adds products to wishlist from plp")
	public void user_adds_products_to_wishlist_from_plp() throws Throwable {
		try {
			webdef.JsScrollBy(driver, 0, 800);
			Thread.sleep(3000);
			count=0;
			List<WebElement> product = plp.plpHeartIcon();
			for (WebElement tempElement : product) {
				webdef.JsClick(tempElement, driver);
				Thread.sleep(1000);
				count++;
				if (count>11)
				{
					break;
				}
			}
		Thread.sleep(2000);
		WebDriverManagedef.takeScreenshots(driver);
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
	@When("user clicks on load more button")
	public void user_clicks_on_load_more_button() throws Throwable {
		try {
		webdef.JsScrollBy(driver, 0, 1300);
		Thread.sleep(2000);
		statusBefore = plp.pageStatus.getAttribute("style");
		System.out.println(statusBefore);
		webdef.JsClick(plp.loadMore, driver);
		Thread.sleep(3000);
		webdef.JsScrollBy(driver, 0, 900);
		statusAfter = plp.pageStatus.getAttribute("style");
		System.out.println(statusAfter);
		WebDriverManagedef.takeScreenshots(driver);
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
	@Then("next set of products are loaded")
	public void next_set_of_products_are_loaded() throws Throwable {
		try {
		if (statusAfter != statusBefore) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);

		}
		WebDriverManagedef.takeScreenshots(driver);
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
