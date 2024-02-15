package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Basket;
import pageobjects.PDP;
import utility.WebDriverManagedef;

public class BasketStepDefinition {
	WebDriver driver = HomePageStepDefinition.driver;
	Basket basket = new Basket(driver);
	PDP pd= new PDP(driver);
    PDPStepDefinition pdpstep = new PDPStepDefinition();
    PLPStepDefinition objplp = new PLPStepDefinition();																																   
	static String cartamt;
	WebDriverManagedef webdef = new WebDriverManagedef();
	static String bagText;
	String newSize;
	public String Amount;
	public static String BagProduct;

	@Test
	@Then("user is on basket page")
	public void user_is_on_basket_page() throws Throwable {
		try {
		Assert.assertTrue(driver.getTitle().contains("Shopping Bag"), "User not on basket page");
		WebDriverManagedef.takeScreenshots(driver);
		cartamount();
		BagProduct=pd.productnameinbag.getText();
		Assert.assertEquals(BagProduct.toLowerCase(), objplp.productname.toLowerCase());
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}

	}

	@Test
	@When("user clicks on check out securely button")
	public void user_clicks_on_check_out_securely_button() throws Throwable {
		try {
		webdef.waitvisibilityof(driver, basket.checkoutSecurelyBtn, 30);														
		webdef.JsClick(basket.checkoutSecurelyBtn, driver);
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	public void cartamount() {
		try {
		cartamt = basket.minicartTotal.getText();
		cartamt = cartamt.replaceAll("�", "");
		System.out.println("cartamount " + cartamt);
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	// ..............................p2_all_desktop_Basket...................................
	@Test
	@When("user selects quantity from the quantity dropdown")
	public void user_selects_quantity_from_the_quantity_dropdown() throws Throwable {
		try {
		bagText = basket.bagcount.getText();
		System.out.println(bagText);
		String initialQuantity = basket.quantity.getAttribute("value");
		System.out.println("initial Quantity :" + initialQuantity);
		Amount = basket.subtotal.getText();
															 
		webdef.selectDropdownOption(basket.quantityDropdown, "index", "4");
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}
	
	@Test
	@Then("Coupon cannot be added to your cart error message is thrown")
	public void coupon_cannot_be_added_to_your_cart_error_message_is_thrown() throws Throwable {
		try {
			Thread.sleep(3000);
			String validationMsg = basket.errormsg.getText();
			int count = validationMsg.length();
			if (count > 0) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus= "Passed";
			} else {
				WebDriverManagedef.stepstatus = "Failed";
				Assert.assertTrue(false, "Basket error message is not showing");	
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
	@Then("product quantity is updated")
	public void product_quantity_is_updated() throws Throwable {
		try {
		Thread.sleep(3000);
		String Quantity = basket.quantity.getAttribute("value");
		System.out.println("Updated Quantity :" + Quantity);
		String currentAmnt = basket.subtotal.getText();
		WebDriverManagedef.stepstatus= "Passed";
		if ((Amount != currentAmnt)) {
			Assert.assertTrue(true);
			WebDriverManagedef.stepstatus= "Passed";
		} else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "Product amount is not equal");	
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
	@When("user selects size from the size dropdown")
	public void user_selects_size_from_the_size_dropdown() throws Throwable {
		try {
		newSize = basket.size.getAttribute("value");
		webdef.selectDropdownOption(basket.size, "index", "3");
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {
			Assert.assertTrue(false);
			}
	}

	@Test
	@Then("product size is updated")
	public void product_size_is_updated() throws Throwable {
		try {
		String updatedSize = basket.size.getAttribute("value");		
			if (newSize != updatedSize) {
				Assert.assertTrue(true);
				WebDriverManagedef.stepstatus= "Passed";
		}else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "Product size is not equal");		
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
	@When("user clicks on remove link")
	public void user_clicks_on_remove_link() throws Throwable {
		try {
		webdef.JsClick(basket.removeProduct, driver);
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	 @Test
	 @Then("product is removed from the bag")
	  public void product_is_removed_from_the_bag() throws Throwable {
	        try {
	            Thread.sleep(5000);
	            driver.navigate().refresh();
	            webdef.waitvisibilityof(driver, basket.emptyBasket, 50);
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
	@When("user clicks on Move to  Wishlist link")
	public void user_clicks_on_Move_to_Wishlist_link() throws Throwable {
		try {
			webdef.JsClick(basket.movetowishlist, driver);
			WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}	
	}
	
	@Test
    @Then("product is in wishlist")
    public void Verify_product_in_wishlist() throws Throwable {
        try {
            webdef.JsClick(basket.wishlistIcon, driver);
            Thread.sleep(3000);
            driver.navigate().refresh();
           String wishlistpdt=basket.pdtWishlist.getText().toLowerCase();
           String bagProduct=BagProduct.toLowerCase();
           Assert.assertEquals(wishlistpdt, bagProduct);

        } catch (AssertionError | Exception e) {
            WebDriverManagedef.stepstatus = "Failed";
            WebDriverManagedef.error = (e.getMessage());
        }
        if (WebDriverManagedef.stepstatus == "Failed") {
            Assert.assertTrue(false);
        }
    }
	
	@Test
    @Then("product is moved to wishlist")
    public void product_is_moved_to_wishlist() throws Throwable {
        try {
            webdef.JsClick(basket.wishlistIcon, driver);
            Thread.sleep(3000);
            driver.navigate().refresh();
            Thread.sleep(2000);
            String bagProduct=BagProduct.toLowerCase();
            int count= basket.pdtWishlist().size();
          for (int num = 1; num <count;num++) {
        	  String wishlistpdt=  basket.pdtWishlist().get(num).getText().toLowerCase();
        	 System.out.println(wishlistpdt+"  "+bagProduct);
        	  if(wishlistpdt.equals(bagProduct))
        	  {
        		  Assert.assertEquals(wishlistpdt, bagProduct);  
        		  break;
        	  }
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
	@When("user enters invalid promocode")
	public void user_enters_invalid_promocode(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {
		webdef.JsClick(basket.inputPromocode, driver);
		basket.inputPromocode.sendKeys(dataTable.cell(1, 0));
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@When("user clicks on Apply button")
	public void user_clicks_on_Apply_button() throws Throwable {
		try {												   
		webdef.JsClick(basket.applyButton, driver);
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}


	@Test
	@When("user  enters promocode")
	public void user_enters_promocode(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		try {													   
		webdef.JsClick(basket.promocodeAfterEntry, driver);
		basket.promocodeAfterEntry.sendKeys(dataTable.cell(1, 0));
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@Then("promocode is applied")
	public void promocode_is_applied() throws Throwable {
		try {
		String codemsg = basket.codeApplied.getText();
		int message = codemsg.length();
		if (message > 0) {
			Assert.assertTrue(true);
			WebDriverManagedef.stepstatus= "Passed";
		} else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "Promocode is not applied");
		}
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}

	}

	// ......................p3_all__desktop_basket............................................

	@Test
	@When("user scrolldowns from the basket page to view the recommended products")
	public void user_scrolldowns_from_the_basket_page_to_view_the_recommended_products() throws Throwable {
		try {
		webdef.JsScrollBy(driver, 0, 500);
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@Then("user views the recommended products")
	public void user_views_the_recommended_products() throws Throwable {
			try {		
			    	if (basket.recommendations1.isDisplayed()) {
                    Assert.assertTrue(true);
                    WebDriverManagedef.stepstatus = "Passed";
                }
             }
		catch(AssertionError | Exception  e)
               {
                  if(basket.recommendations2.isDisplayed())
                   {
                       Assert.assertTrue(true);
                       WebDriverManagedef.stepstatus = "Passed";
                   }
                   else {
                       Assert.assertTrue(false);
                       WebDriverManagedef.error=(e.getMessage());					 
                       WebDriverManagedef.stepstatus = "Failed";
                   }
                }
        if (WebDriverManagedef.stepstatus == "Failed") {
            Assert.assertTrue(false);
        }

	}

	@Test
	@When("user clicks on the country icon from the header")
	public void user_clicks_on_the_country_icon_from_the_header() throws Throwable {
		try {		
		webdef.waitElementClickable(driver, basket.countrySelector, 60);
		webdef.JsClick(basket.countrySelector, driver);
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@Then("user is on country panel")
	public void user_is_on_country_panel() throws Throwable {
		try {
		if (basket.countryWindow.isDisplayed()) {
			Assert.assertTrue(true);
			WebDriverManagedef.stepstatus= "Passed";
		} else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "country panel is available in basket");
		}
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
	@Then("user clicks on the bag icon from the header")
	public void user_clicks_on_the_bag_icon_from_the_header() throws Throwable {
		try {	
		Thread.sleep(1000);
		webdef.JsClick(basket.bagIcon, driver);
		Thread.sleep(2000);
		WebDriverManagedef.stepstatus= "Passed";
		}catch (AssertionError | Exception  e) {
			WebDriverManagedef.stepstatus="Failed";	
			WebDriverManagedef.error=(e.getMessage());
		}
		if(WebDriverManagedef.stepstatus=="Failed") {		
			Assert.assertTrue(false);
			}
	}

	@Test
    @Then("user views the  products available for the current selected {string}")
    public void user_views_the_products_available_for_the_current_selected(String country) throws Throwable {
        try {
            if (pd.productnameinbag.isDisplayed()) {
                Assert.assertEquals(pd.productnameinbag.getText(), objplp.productname);
                Assert.assertTrue(true);
                WebDriverManagedef.stepstatus = "Passed";
            } else {
                WebDriverManagedef.stepstatus = "Failed";
                Assert.assertTrue(false, "Product is not available in selected country");
            }
        } catch (AssertionError | Exception e) {
            WebDriverManagedef.stepstatus = "Failed";
            WebDriverManagedef.error = (e.getMessage());
        }
        if (WebDriverManagedef.stepstatus == "Failed") {
            Assert.assertTrue(false);
        }

    }


	// ...................................p3_all_empty_basket...............................

	@Test
	@Then("user is on basket page and views the empty basket")
	public void user_is_on_basket_page_and_views_the_empty_basket() throws Throwable {
		try {
		if (basket.emptyBasket.isDisplayed()) {
			Assert.assertTrue(true);
			WebDriverManagedef.stepstatus= "Passed";
		} else {
			WebDriverManagedef.stepstatus = "Failed";
			Assert.assertTrue(false, "Product is showing in basket and the basket is not empty");
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
