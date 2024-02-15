package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.WebDriverManagedef;

public class HomePage {

	public WebDriver driver;
	Actions actions;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/*
	 * @FindBy(how = How.XPATH, using =
	 * "//*[@id='countryGateway']/div/div/div/div/div/div[2]/form/div[1]/div/div[1]/div/div/span[1]/i")
	 * public WebElement dropdowncountrymobile;
	 */
	
	@FindBy(how = How.XPATH, using = "//*[@id='countryGateway']/div/div/div/div/div/div[2]/form/div[1]/div/div[1]/div/div/span[1]/i")
	public WebElement dropdowncountrymobile;

	@FindBy(how = How.XPATH, using = "//div[@id='countryGateway']//div//button[contains(text(),'View our Styles')]")
	public WebElement gatewaySubmitbtn;

	public WebElement CountryInSelectorGateway(String country) {
		return driver.findElement(By.xpath(
				"//*[@id= 'countryGateway']/div/div/div/div/div/div[2]/form/div[1]/div/div[2]/div/div[@data-value='"
						+ country + "']"));
	}

	@FindBy(how = How.XPATH, using = "//div[@id='countryGateway']//button//span")
	public WebElement countrySelectorGatewayCloseBtn;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'accept and close')]")
	public WebElement acceptAndCloseBtn;

	@FindBy(how = How.XPATH, using = "//nav[@id='main-nav']//span[text()='New In']")
	public WebElement mainCategory;

	@FindBy(how = How.XPATH, using ="//div[@class='navbar-header text-md-center mt-lg-2 mt-1 col']//img[@class='logo']")
			//"//a[@title='Hobbs Home']")
			
			//"//img[@class='logo']")
			//"//img[@class='header-image loading']")
	public WebElement brandLogo;
	@FindBy(how = How.XPATH, using = "(//img[contains(@class,'header-image')])[1]")
	//"//a[@class='navbar-header__logo-link']//img[@class='logo loading']")
    public WebElement brandLogostage;
	
	@FindBy(how = How.XPATH, using = "//div[@class='nav-menu__header__logo col-6 col-lg-4 pt-1 mb-sm-0 order-1']//img[@class='header-image']")
			//"//a[@class='navbar-header__logo-link']//img[@class='logo loading']")
	public WebElement brandLogo1;
	
	@FindBy(how = How.XPATH, using = "//*[@class='cookie-warning-messaging cookie-warning d-block']")
	public WebElement acceptAndCloseBanner;

	@FindBy(how = How.XPATH, using = "//*[@id='main-nav']")
	public WebElement mainCategoryNavigation;

	@FindBy(how = How.XPATH, using = "//*[@class='font-icon icon-menu ']")
	public WebElement burgerIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='nav-menu__header d-lg-none']")
	public WebElement subNavigationPanel;

	@FindBy(how = How.XPATH, using = "//div[@class='login']//span[text()='Register']")
	public WebElement mobregister;

	public WebElement MainCategory(String mainCategory) {
		return driver.findElement(By.xpath("//nav[@id='main-nav']//span[text()='" + mainCategory + "']"));
	}

	public WebElement SubCategory(String subCategory) {
		return driver.findElement(By.xpath("//ul[@id='new-items']//span[text()='" + subCategory + "']"));
	}

	public WebElement SubCategorywhatnew(String subCategory) {
		return driver.findElement(By.xpath("//ul[@id='new-items']//span[text()='" + subCategory + "']"));
	}
	public WebElement SubCategoryClothing(String subCategory) {
		return driver.findElement(By.xpath("//ul[@id='clothing-items']//span[contains(text(),'"+subCategory+"')]"));
	}
	public WebElement SubCategoryShoes(String subCategory) {
		return driver.findElement(By.xpath("//ul[@id='shoes-items']//span[contains(text(),'"+subCategory+"')]"));
	}
	public WebElement SubCategoryDress(String subCategory) {
		return driver.findElement(By.xpath("//ul[@id='dresses-items']//span[contains(text(),'"+subCategory+"')]"));
	}
	public WebElement SubCategoryOccasion(String subCategory) {
		return driver.findElement(By.xpath("//ul[@id='Occasionwear-items']//span[contains(text(),'"+subCategory+"')]"));
																 
	}

	public void SelectCategoryMobile(String mainCategory, String subCategory) {
		MainCategory(mainCategory).click();
		SubCategory(subCategory).click();
	}

	// ...............P2_ALL_ACCOUNT_STARTS................................
	@FindBy(how = How.XPATH, using = "//div[@class='header-element header-element__user user']//a")
	public WebElement loginIcon;

	@FindBy(how = How.ID, using = "login-form-email")
	public WebElement loginEmail;

	@FindBy(how = How.ID, using = "login-form-password")
	public WebElement loginPassword;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Sign in')]")
	public WebElement signinButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Forgotten your password?')]")
	public WebElement forgotPassword;

	@FindBy(how = How.ID, using = "reset-password-email")
	public WebElement resetEmail;

	@FindBy(how = How.ID, using = "submitEmailButton")
	public WebElement sendResetpassword;

	@FindBy(how = How.XPATH, using = "//input[@id='registration-form-email']")
	public WebElement createaccountEmail;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Create account')]")
	public WebElement createAccountbutton;

	@FindBy(how = How.ID, using = "registration-form-title")
	public WebElement regTitle;

	@FindBy(how = How.ID, using = "registration-form-fname")
	public WebElement regFirstname;

	@FindBy(how = How.ID, using = "registration-form-lname")
	public WebElement regLastname;

	@FindBy(how = How.ID, using = "registration-form-password")
	public WebElement regPassword;

	@FindBy(how = How.ID, using = "registration-form-password-confirm")
	public WebElement regConfirmPassword;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Agree & continue')]")
	public WebElement regSubmitbutton;

	@FindBy(how = How.XPATH, using = "//div[@class='account-nav col-sm-12 col-lg-3 pl-lg-0 ']//a[@title='Log Out']")
	public WebElement logOut;

	@FindBy(how = How.XPATH, using = "//div[@class='error-summary__heading ']//following::li[@class='error-summary__message ']")
	public WebElement errormsg;
	
	@FindBy(how = How.XPATH, using = 
			//"//div[contains(text(),'Please enter a valid email address')]")
            "//div[contains(text(),'This email address is invalid. Please double check your spelling is correct')]")
		public WebElement badEmailerror;
	
	@FindBy(how = How.XPATH, using = 
			//"//div[contains(text(),'Please enter a valid email address')]")
			"//div[contains(text(),'This email address is invalid. Please double check your spelling is correct')]")
	public WebElement badEmailerror1;

	@FindBy(how = How.XPATH, using = "(//div[@class='invalid-feedback'])[1]")
	public WebElement resetInvalidemail;

	@FindBy(how = How.XPATH, using = "//h6[text()='Why create an account?']")
	public WebElement regpagevalidation;

	@FindBy(how = How.XPATH, using = "//p[@class='mb-4']")
	public WebElement passResetPage;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign in')]")
	public WebElement passwordSendPage;

	@FindBy(how = How.XPATH, using = "//h5[@class='contact-preferences-title mt-5 mb-4']")
	public WebElement userRegisterPage;

	@FindBy(how = How.XPATH, using = "//a[@title='My Details']")
	public WebElement accountPage;

	// ....................p2_all_mobilenavigation.......................................

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-link nav-menu__close line-height-1 expanded']//i")
	public WebElement burgernavClose;

	// .............................p2_all_newsletter...................................

	@FindBy(how = How.XPATH, using = "//div[@class='col-12 col-lg-6 order-lg-2 text-center payment-methods']")
	public WebElement footer;

	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	public WebElement footerEmail;

	@FindBy(how = How.XPATH, using = "//button[@class='email-newsletter__submit pr-0']")
	public WebElement footersignupButton;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Please include')]")
	public WebElement emailError;

	@FindBy(how = How.XPATH, using = "//select[@id='title']")
	public WebElement newsTitle;

	@FindBy(how = How.XPATH, using = "//input[@id='firstName']")
	public WebElement newsFirstname;

	@FindBy(how = How.XPATH, using = "//input[@id='lastName']")
	public WebElement newsLastname;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Accept & Continue')]")
	public WebElement acceptBtn;

	@FindBy(how = How.XPATH, using = "//h2[@class='newsletter-form_heading thank-you']//span")
	
	//@FindBy(how = How.XPATH, using = "//h2[@class='newsletter-form__heading']//span")
	public WebElement nextletterPage;

	@FindBy(how = How.XPATH, using = "//div[@class='newsletter-form__optin__wrapper']//following::label[1]")
	public WebElement checkbox;

	@FindBy(how = How.XPATH, using = "//div[@class='form-group form-row form-group--text has-float-label form-row-input phone-fields collapse show']//input")
	public WebElement mobile;

	// ..................p3_all_account...............................................................

	@FindBy(how = How.XPATH, using = "//div[@class='invalid-feedback d-block']")
	public WebElement existingEmailerror;

	@FindBy(how = How.XPATH, using = "//div[@class='account-nav__menu p-0']//a[@title='My Details']")
	public WebElement updateDetailsbtn;

	@FindBy(how = How.XPATH, using = "//input[@id='currentPassword']")
	public WebElement currentPassword;

	@FindBy(how = How.XPATH, using = "//input[@id='newPassword']")
	public WebElement newPassword;

	@FindBy(how = How.XPATH, using = "//input[@id='newPasswordConfirm']")
	public WebElement confirmPassword;

	@FindBy(how = How.XPATH, using = "//form[@id='dwfrm_profile_login']//button[contains(text(),'Save Changes')]")
	public WebElement passwordSavebtn;

	@FindBy(how = How.XPATH, using = "//select[@class='input-select required form-control']")
	public WebElement changeTitle;

	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	public WebElement changePhonenumber;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "//form[@id='dwfrm_profile']//button[contains(text(),'Save Changes')]")
	public WebElement detailsSavebtn;

	@FindBy(how = How.XPATH, using = "//div[@class='account-nav__menu p-0']//a[@title='Payment & Billing']")
	public WebElement editPaymentbtn;

	@FindBy(how = How.XPATH, using = "//div[@class='saved-payments-list__card-footer pb-3']//a[contains(text(),'Edit Address')]")
	public WebElement editAddressbtn;

	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	public WebElement editCity;
	
	@FindBy(how = How.XPATH, using = "//input[@id='firstName']")
	public WebElement accFirstname;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Save Card Details')]")
	public WebElement savecardDetailsbtn;

	@FindBy(how = How.XPATH, using = "//div[@class='account-nav__menu p-0']//span[contains(text(),'Orders')]")
	public WebElement viewOrderbtn;

	@FindBy(how = How.XPATH, using = "//a[@class='account-nav__item d-block pr-2 py-3 preference-centre ']//span[contains(text(),'Preference Centre')]")
	public WebElement preferenceStorebtn;

	@FindBy(how = How.XPATH, using = "//input[@id='store-postal-code']")
	public WebElement postalCode;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add a preferred store')]")
	public WebElement storeAddbtn;

	@FindBy(how = How.XPATH, using = "//div[@class='store-address-wrapper']//p[@class='store-title']//i")
	public WebElement favStoreText;

	@FindBy(how = How.XPATH, using = "//div[@class='col-12 px-lg-5 col-lg-6 preferred-store']//button[@class='btn btn-save btn-block save-preffered-store btn-secondary']")
	public WebElement changeStorebtn;

	@FindBy(how = How.XPATH, using = "//div[@class='store-address-wrapper']//p[@class='store-title']")
	public WebElement oldstorename;

	@FindBy(how = How.XPATH, using = "//div[@class='account-nav col-sm-12 col-lg-3 pl-lg-0 hidden-md-down']//a[@title='Log Out']")
	public WebElement LogOutorder;

	@FindBy(how = How.XPATH, using = "//input[@id='trackorder-form-number']")
	public WebElement orderNumber;

	@FindBy(how = How.XPATH, using = "//input[@id='trackorder-form-email']")
	public WebElement orderEmail;

	@FindBy(how = How.XPATH, using = "//input[@id='trackorder-form-zip']")
	public WebElement orderPostcode;

	@FindBy(how = How.XPATH, using = "//div[@class='form-group pt-2 pb-0']//button[contains(text(),'View status')]")
	public WebElement vieworderStatus;

	public WebElement favoriteStore(String store) {
		return driver.findElement(By.xpath(
				"//div[@class='store-results-container w-100 position-relative']//ul//following::li[contains(text(),'"
						+ store + "')]"));

	}

	@FindBy(how = How.XPATH, using = "//div[@class='nav-menu__body w-100']//ul[@class='nav-menu__items nav-menu__items--level-1 list-unstyled mb-lg-0 px-2']")
	public WebElement mainPage;

	// ....................p3_all_storeLocator...........................................

	@FindBy(how = How.XPATH, using = "//div[@class='collapse collapsed d-lg-block']//li[@class='pb-lg-2']//a[contains(text(),'Find a Hobbs Store')]")
	public WebElement hobbsStore;

	@FindBy(how = How.XPATH, using = "//input[@id='store-postal-code']")
	public WebElement city;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary btn-block btn-lg btn-storelocator-search']//span[contains(text(),'Search')]")
	public WebElement searchButton;

	@FindBy(how = How.XPATH, using = "//div[@class='results striped']//span[contains(text(),'Search results near')]")
	public WebElement storeList;

	@FindBy(how = How.XPATH, using = "//div[@class='stores-details-container float-right w-100']//p[@class='text-center store-locator-no-results d-block']")
	public WebElement validationError;

	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	public WebElement country;

	@FindBy(how = How.XPATH, using = "//button[@id='onetrust-accept-btn-handler']")
	public WebElement Acceptcookies;

}