package stepdefs;

import pageobjects.Basket;
import pageobjects.HomePage;
import pageobjects.PDP;
import pageobjects.PLP;
import utility.WebDriverManagedef;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PDPStepDefinition {

	WebDriver driver = HomePageStepDefinition.driver;
	HomePage homePage;
	PDP pdp = new PDP(driver);
	PLP plp = new PLP(driver);
	 Basket bag = new Basket(driver);
	WebDriverManagedef webdef = new WebDriverManagedef();
	PLPStepDefinition objplp = new PLPStepDefinition();
	List<WebElement> sortList;
	String productCount = null;
	static String msg;
	public List<String> list;
	public String BagProduct;
	
	@Test
	@Then("user is on the corresponding <Product> detail page")
	public void user_is_on_the_corresponding_product_detail_page(io.cucumber.datatable.DataTable dataTable)
			throws Throwable {
		try {
		Thread.sleep(6000);
		WebDriverManagedef.takeScreenshots(driver);
		Assert.assertTrue(driver.getTitle().contains(dataTable.cell(1, 0)));
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
	@When("user selects a <Size> on PDP")
	public void user_selects_a_size_on_pdp(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
		webdef.JsClick(pdp.ProductSizeInPdp(dataTable.cell(1, 0)), driver);
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
	@Then("the <Size> is selected on PDP")
	public void the_size_is_selected_on_pdp(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
		Assert.assertEquals(pdp.ProductSizeSelectedInPdp(dataTable.cell(1, 0)).getText(), dataTable.cell(1, 0),
				"Selected size incorrect");
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
	@Given("user searches for product from HomePage and lands on PDP")
	public void user_searches_for_product_from_HomePage_and_lands_on_PDP() throws Throwable
	{
		
		try {
			pdp.searchbar.isDisplayed();
			list= webdef.getExcelSheet("SearchData",HomePageStepDefinition.Environment,HomePageStepDefinition.RegionVal);
			pdp.searchbar.sendKeys(list.get(0));
			webdef.JsClick(pdp.searchIcon, driver);
			Thread.sleep(10000);
			WebDriverManagedef.takeScreenshots(driver);
			Assert.assertTrue(true);
			WebDriverManagedef.stepstatus = "Passed";
			} catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus = "Failed";
			WebDriverManagedef.error = (e.getMessage());
			System.out.println(e.getMessage());
			}
			if (WebDriverManagedef.stepstatus == "Failed") {
			Assert.assertTrue(false);
			}

			}
	

	@Test
	@When("user clicks add to bag button on PDP")
	public void user_clicks_add_to_bag_button_on_pdp() throws Throwable {
		try {
			Thread.sleep(10000);
		webdef.JsClick(pdp.addToBagInPDP, driver);
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
	@Then("the selected Product is added to bag")
	public void the_selected_product_is_added_to_bag() throws Throwable {
		try {
		Thread.sleep(3000);
		BagProduct=pdp.productnameinbag.getText();
		Assert.assertEquals(pdp.productnameinbag.getText(), objplp.productname);
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
	@Then("user clicks on view bag")
	public void user_clicks_on_view_bag() throws Throwable {
		try {												   
		webdef.JsClick(pdp.viewBagAndCheckout, driver);
		webdef.waitvisibilityof(driver, bag.checkoutSecurelyBtn, 30);
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
	@When("user clicks on mini bag")
	public void user_clicks_on_mini_bag() throws Throwable {
		try {
		webdef.Click(pdp.viewBag, driver);
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
	@When("user clicks on breadcrumb link for maincategory")
	public void user_clicks_on_Breadscrummaincategory() throws Throwable {
		try {
		webdef.JsClick(pdp.Breadscrummaincategory, driver);
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
	@When("user clicks on breadcrumb link for Home")
	public void user_clicks_on_BreadscrumHome() throws Throwable {
		try {
		Thread.sleep(2000);
		webdef.JsClick(pdp.BreadscrumHome, driver);
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
	@Then("user is on home page")
	public void user_is_on_home_page() throws Throwable {
		try {
		if (driver.getCurrentUrl().contains("hobbs.com/")) {
			Assert.assertTrue(true);
			WebDriverManagedef.stepstatus= "Passed";
		}else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "User is not in the home page");
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
	@Then("user is on PLP")
	public void user_is_on_PLP() throws Throwable {
		try {
			webdef.waitvisibilityof(driver, pdp.plphidefilterText, 30);
			if (pdp.plphidefilterText.isDisplayed()) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus = "Passed";
			}
			WebDriverManagedef.takeScreenshots(driver);
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
	@When("user clicks on the  selected product image")
	public void user_clicks_on_the_selected_product_image() throws Throwable {
		try {
		webdef.JsClick(pdp.largeImage, driver);
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
	@Then("product image is expanded")
	public void product_image_is_expanded() throws Throwable {
		try {
		Thread.sleep(1000);
		webdef.JsClick(pdp.ImageClose, driver);
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
	@When("user clicks on the review button")
	public void user_clicks_on_the_review_button() throws Throwable {
		try {
		Thread.sleep(3000);
		Boolean review = pdp.reviewButton.isDisplayed();
		if (review) {
			webdef.JsClick(pdp.reviewButton, driver);
			Assert.assertTrue(true);
			WebDriverManagedef.stepstatus= "Passed";
		}else {
			//WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "User not able to click the review button");
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
    @Then("user is on review panel")
    public void user_is_on_review_panel() throws Throwable {
        try {
            Thread.sleep(3000);
            String review = "REVIEWS";
            String panel = pdp.panelReview.getText();
            if (panel.contains(review)) {
                Assert.assertTrue(true);
                WebDriverManagedef.stepstatus = "Passed";
            } else {

                WebDriverManagedef.stepstatus = "Failed";
                Assert.assertTrue(false, "User is not on review panel");
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
	@When("user clicks on close button of the review panel")
	public void user_clicks_on_close_button_of_the_review_panel()  throws Throwable {
		try {
		
		Boolean rev=pdp.panelReview.isDisplayed();
		try {
		if (rev==true) {
			webdef.JsClick(pdp.reviewCloseBtn, driver);
		WebDriverManagedef.stepstatus= "Passed";
		}
		}catch(Exception exp)
		{
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(exp.getMessage());
		}
		}
		catch (Exception  e) {
			Assert.assertTrue(true,"Review option not present for product");
			WebDriverManagedef.stepstatus="Passed";	

		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}
	@Test
    @When("user clicks on close button")
    public void user_clicks_on_close_button() throws Throwable {
        try {
            webdef.JsClick(pdp.reviewCloseBtn, driver);
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
	@Then("review panel is closed")
	public void review_panel_is_closed() throws Throwable {
		try {
			Thread.sleep(1000);
		boolean visible = pdp.panelReview.isDisplayed();
		if (!visible) {
			Assert.assertTrue(true);
			WebDriverManagedef.stepstatus= "Passed";
		}else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "Review panel is not closed");
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
	@When("user clicks out of review panel")
	public void user_clicks_out_of_review_panel() throws Throwable {
		try {
		webdef.JsClick(pdp.reviewClickOut, driver);
		WebDriverManagedef.takeScreenshots(driver);
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
	@When("user clicks on the wishlist button")
	public void user_clicks_on_the_wishlist_button() throws Throwable {
		try {
		webdef.JsClick(pdp.wishlistButton, driver);
		Thread.sleep(1000);
		msg = plp.addwishlistMsg.getText();
		webdef.JsScrollBy(driver, 0, 150);
		webdef.highlightObjects(driver,plp.addwishlistMsg);
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
	@Then("product is added to wishlist")
	public void product_is_added_to_wishlist() throws Throwable {
		try {
			Thread.sleep(1000);
		String pdtname1 = pdp.productname1.getText();
		webdef.JsClick(pdp.wishlistIcon, driver);
		String name = pdp.productname2.getText();
		String pdtname2 = name.toUpperCase();
		Assert.assertEquals(pdtname1, pdtname2);
		WebDriverManagedef.takeScreenshots(driver);
		driver.navigate().back();
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
	@Then("user clicks on the selected wishlist button")
	public void user_clicks_on_wishlist_button() throws Throwable {
		try {
		webdef.JsClick(pdp.wishlistButtonRemove, driver);
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
	@Then("Product is removed from wishlist")
	public void product_is_removed_from_wishlist() throws Throwable {
	try {
	webdef.JsClick(pdp.wishlistIcon, driver);
	if (plp.emptyWishlist.getText().contains("START SHOPPING")) {
	Assert.assertTrue(true);
	WebDriverManagedef.stepstatus= "Passed";
	driver.navigate().back();
	} else {



	Assert.assertTrue(false);
	WebDriverManagedef.stepstatus = "Failed";
	Assert.assertTrue(false, "Product is not removed from wishlist");
	}
	}catch (AssertionError | Exception e) {
	WebDriverManagedef.stepstatus="Failed";
	WebDriverManagedef.error=(e.getMessage());
	}
	if(WebDriverManagedef.stepstatus=="Failed") {
	Assert.assertTrue(false);
	}



	}
	// .........p3_all_desktop_pdp............................................................

	@Test
	@When("user clicks on the swatches")
	public void user_clicks_on_the_swatches() throws Throwable {
		try {
		webdef.JsScrollBy(driver, 0, 1000);
			Boolean color = pdp.colorSwatch.isDisplayed();
			if (color) {
				int colorCount = pdp.color().size();
				System.out.println(colorCount);
				for (int i = 0; i <= colorCount; i++) {
					if (pdp.colorText(i).isDisplayed()) {
						Boolean selectedColor = pdp.colorText(i).isSelected();
						if (selectedColor == false) {
							webdef.JsClick(pdp.colorText(i), driver);
							Thread.sleep(4000);
							WebDriverManagedef.takeScreenshots(driver);

						}
					}

				}
				WebDriverManagedef.stepstatus= "Passed";
			} else if (!color) {
				System.out.println("No more colors available");
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "User not able to click on the swatches");
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
	@Then("color of the selected product is changed")
	public void color_of_the_selected_product_is_changed() throws Throwable {
		try {
		int count = pdp.color().size();
		if (count >= 1) {
			Assert.assertTrue(true);
			WebDriverManagedef.stepstatus= "Passed";
		} else {
			System.out.println("No color is selected");
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "Color of the selected product is not changed");
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
	@Then("user sorts the ratings")
	public void user_sorts_the_ratings() throws Throwable {
		try {
		webdef.selectGetOption(driver, pdp.reviewSortOption);
		}catch (AssertionError | Exception e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@When("user clicks the Loadmore button from the review panel")
	public void user_clicks_the_Loadmore_button_from_the_review_panel() throws Throwable {
		try {
		productCount = pdp.loadedproductCount.getText();
		System.out.println(productCount);
		if (pdp.loadmoreButton.isDisplayed()) {
			webdef.JsScrollintoView(driver, pdp.loadmoreButton);
			webdef.Click(pdp.loadmoreButton, driver);
			WebDriverManagedef.takeScreenshots(driver);
			Thread.sleep(3000);
			WebDriverManagedef.stepstatus= "Passed";
		} else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "No more review found");
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
	@Then("more reviews are loaded in review panel")
	public void more_reviews_are_loaded_in_review_panel() throws Throwable {
		try {
		webdef.JsScrollintoView(driver, pdp.loadedproductCount);
		String count = pdp.loadedproductCount.getText();
		System.out.println(count);
		if (count != productCount) {
			Assert.assertTrue(true);
			WebDriverManagedef.stepstatus= "Passed";
		} else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "More reviews are not loaded in review panel");
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
	@When("user clicks on size guide link")
	public void user_clicks_on_size_guide_link() throws Throwable {
		try {
		webdef.JsScrollBy(driver, 0, -1000);
		webdef.JsClick(pdp.sizeGuide, driver);
		WebDriverManagedef.takeScreenshots(driver);
		Thread.sleep(3000);
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
	@Then("size guide tables are displayed in panel")
	public void size_guide_tables_are_displayed_in_panel() throws Throwable {
		try {
		Assert.assertEquals(pdp.displaysizeChart.getText(), "SIZE CHART");
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
	@When("user clicks the close button on the size guide panel")
	public void user_clicks_the_close_button_on_the_size_guide_panel() throws Throwable {
		try {
		webdef.JsClick(pdp.sizepanelClose, driver);
		WebDriverManagedef.takeScreenshots(driver);
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
	@Then("size guide panel is closed")
	public void size_guide_panel_is_closed() throws Throwable {
		try {
		if (pdp.displaysizeChart.isDisplayed()) {
			Assert.assertTrue(false);
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "Size guide panel is not closed");
		} else {
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
	@When("user clicks on Delivery and Returns button")
	public void user_clicks_on_Delivery_and_Returns_button() throws Throwable {
		try {
		webdef.JsScrollBy(driver, 0, 500);
		webdef.JsClick(pdp.deliveryReturns, driver);
		WebDriverManagedef.takeScreenshots(driver);
		Thread.sleep(3000);
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
	@Then("user is on Delivery and Returns panel")
	public void user_is_on_Delivery_and_Returns_panel() throws Throwable {
		try {
		Assert.assertEquals(pdp.deliveryReturnPanel.getText(), "DELIVERY & RETURNS");
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
	@When("user clicks on the X close button in delivery and returns panel")
	public void user_clicks_on_the_X_close_button_in_delivery_and_returns_panel() throws Throwable {
		try {
		webdef.JsClick(pdp.deliveryReturnClose, driver);
		WebDriverManagedef.takeScreenshots(driver);
		Thread.sleep(20000);
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
	@Then("delivery and return panel is closed")
	public void delivery_and_return_panel_is_closed() throws Throwable {
		try {
		if (pdp.deliveryReturnPanel.isDisplayed()) {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "Delivery and return panel is not closed");
		} else {
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
	@When("user clicks on the recommended product")
	public void user_clicks_on_the_recommended_product() throws Throwable {
		try {
		webdef.JsScrollBy(driver, 0, 570);
		driver.navigate().refresh();
		Thread.sleep(5000);
			try {
				if (pdp.recommendedProduct.isDisplayed()) {
					webdef.JsClick(pdp.recommendedProduct, driver);
					WebDriverManagedef.stepstatus= "Passed";
					}
				}
			catch (Exception  notfound){
				WebDriverManagedef.stepstatus = "Passed";
				Assert.assertTrue(true, "No recommended products available");
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
	@Then("user is on PDP")
	public void user_is_on_PDP() throws Throwable {
		try {
		if (driver.getCurrentUrl().contains("/product/")) {
			Assert.assertTrue(true);
			WebDriverManagedef.stepstatus= "Passed";
		} else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "User is not in PDP Page");
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
    @Then("selected product is added to bag")
    public void selected_product_is_added_to_bag() throws Throwable {
        try {
            String productInMinicart = pdp.miniQuantity.getText();
//            System.out.println("******************************  " + productInMinicart);

            if (productInMinicart != "0") {
                Assert.assertTrue(true);
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
}

