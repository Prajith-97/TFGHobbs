package pageobjects;

import java.awt.Window;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.WindowsBy;

public class PLP {
	WebDriver driver;

	public PLP(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement selectlproductInPLP(int i) {
		return driver.findElement(
				By.xpath("//div[@class='product-tiles row no-gutters w-100']//div["+i+"]//div[@class='product']//div[@class='product-tile__name']"));
		
	}
	public WebElement selectproduct(int i) {
		return driver.findElement(
				By.xpath("//div[@class='product-tiles row no-gutters w-100']//div["+i+"]//div[@class='product']//div[@class='product-tile__name']//a"));
		
	}

	@FindBy(how = How.XPATH, using = "(//span[@class='product-detail__attribute__error text-danger'])[2]")
	public WebElement sizeErrorText;
	
	@FindBy(how = How.XPATH, using = "//a[@id='filters-toggle']//span[contains(text(),'Hide Filters')]")
	public WebElement hideFilterBtn;

	@FindBy(how = How.XPATH, using = "//*[@class='filters']//span[@class='filters__section__btn-icon filters__toggle-section__btn-icon']")
	public WebElement FilterBtnMobile;

	@FindBy(how = How.XPATH, using = "//a[@id='filters-toggle']//span[contains(text(),'Show Filters')]")
	public WebElement showFilterBtn;

	@FindBy(how = How.LINK_TEXT, using = "FIT")
	public WebElement FIT;

	@FindBy(how = How.XPATH, using = "/a[@class='filters__close-button']")
	public WebElement Filterclosebutton;

	public WebElement filter(String filtername) {
		return driver.findElement(By.linkText("filtername"));
	}

	public WebElement ProductNameInPLP(String productName) {
		return driver.findElement(
				By.xpath("//div[@id='product-search-results']//a[contains(text(),'" + productName + "')]"));
	}

	public WebElement MainFilter(String mainFilter) {
		return driver.findElement(By.xpath("//div[@id='filters']//span[contains(text(),'" + mainFilter + "')]"));
	}

	@FindBy(how = How.XPATH, using = "//div[@id='applied-filters']//span")
	public WebElement appliedFilterArea;
	
	public WebElement FilterTypeFit(String filterType) {
		return driver.findElement(By.xpath("//div[@id='fit']//span[contains(text(),'" + filterType + "')]"));
	}

	public WebElement FilterTypeUKSize(String Size) {
		return driver.findElement(By.xpath("//div[@id='size']//span[contains(text(),'" + Size + "')]"));
	}

	public WebElement FilterTypeSleeve(String category) {
		return driver.findElement(By.xpath("//div[@id='sleeve']//span[contains(text(),'" + category + "')]"));
	}

	@FindBy(how = How.XPATH, using = "//div[@id='availability']//span[contains(text(),'Only show items in stock')]")
	public WebElement Availabilitycheckbox;

	public List<WebElement> Availabilityproducts() {
		return driver.findElements(By.xpath(
				"//div[@class='product-tiles row no-gutters w-100']//div[starts-with(@class,'product-tile__wrapper product-tile__wrapper')]//div[@class='product']"));
	}

	public List<WebElement> productspricevalues() {
		return driver.findElements(By.xpath(
				"//div[@class='product-tiles row no-gutters w-100']//div[starts-with(@class,'product-tile__wrapper product-tile__wrapper')]//div[@class='product']//div[contains(@class,'product-tile__price')]//span[@class='value']"));
	}
	
	public List<WebElement> allProductsCountInPLP() {
		return driver.findElements(By.xpath(
				"//div[@class='product-tiles row no-gutters w-100']//div[starts-with(@class,'product-tile__wrapper product-tile__wrapper')]//div[@class='product']"));
	}
	public WebElement CheckoutofStock(int i) {
		return driver.findElement(By.xpath("(//div[@class='product-tile__image']//div[contains(text(),'Out of Stock')])["+i+"]"));
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='product-tiles row no-gutters w-100']//div[starts-with(@class,'product-tile__wrapper product-tile__wrapper')]//div[1]//div[@class='product-tile__body']//div[@class='product-tile__name']//a")
	public WebElement productfromrow1;

	@FindBy(how = How.XPATH, using = "//div[starts-with(@class,'product-detail__attribute product-detail__attribute--size')]//div[@class='product-detail__attribute__values-row row no-gutters']//div[1]/a")
	public WebElement productsizeselection;

	public List<WebElement> listallproductsize() {
		return driver.findElements(By.xpath(
				"//div[@class='product-detail__attribute product-detail__attribute--size mt-2 my-3']/div[2]/div/div"));
	}

	
		public WebElement selectlproductsize(int size) {
	//	return driver.findElement(By.xpath("(//p[contains(@class,'product-detail__attribute__value')])["+ size + "]"));
		//Nofilter
	return driver.findElement(By.xpath("(//span[@class='product-detail__attribute__value__text p-1'])[" + size + "]"));
		}
	public List<WebElement> listallQuickAddsize() {
		return driver.findElements(By.xpath(
				"//div[@class='product-tile__add-overlay-size-wrapper  text-center']"));
	}
	
	public WebElement qickaddSize(int size) {
		//return driver.findElement(By.xpath("//div[@class='product-tile__add-overlay-sizes-container row no-gutters w-100']//div["+size+"]/label"));
		return driver.findElement(By.xpath("//div[@class='product-tile__add-overlay-sizes col-12 h-100 d-flex flex-wrap position-static']//div[2]"));
	}
	
	@FindBy(how = How.XPATH, using = "//button[@class='add-to-cart btn btn-secondary']")
	public WebElement BagAddQuick;
	
	public WebElement productprice(int size) {
		return driver.findElement(By.xpath("//*[@id='product-search-results']/div[2]/div[3]/div/div[2]/div[" + size
				+ "]/div/div/div[2]/div[3]/a/div/span/span/span"));

	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='row no-gutters product-detail__attributes-accordion']/div[2]/div[1]/div/a/span[1]")
	public WebElement emailmewhenavailable;

	@FindBy(how = How.XPATH, using = "//div[@class='filters']//a[@id='filters-toggle']")
	public WebElement filterInMobile;

	@FindBy(how = How.XPATH, using = "//div[@class='col-6 pl-1']//a[contains(text(),'Apply Filters')]")
	public WebElement applyFiltersInMobile;
	// ....................p2_all_desktop_plp............................................

	@FindBy(how = How.ID, using = "sortOptions")
	public WebElement Drodpwnsortselection;

	public WebElement appliedfilters(String filterType) {
		return driver
				.findElement(By.xpath("//div[@id='applied-filters']//span[contains(text(),'" + filterType + "')]"));
	}
	public WebElement appliedfiltermobile(String filterType) {
		return driver
				.findElement(By.xpath("//div[@id='product-search-results']//span[contains(text(),'" + filterType + "')]"));
	}

	public By applyFilter(String filterType) {

		By element = By.xpath("//div[@id='applied-filters']//span[contains(text(),'" + filterType + "')]");
		return element;
	}

	public WebElement appliedfiltersclose(String filterType) {
		return driver.findElement(By.xpath(
				"//div[@id='applied-filters']//span[contains(text(),'" + filterType + "')]/parent::li/child::a/i"));
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='applied-filters']//ul[@class='values content']//a//i")
	public WebElement singlefilterCloseBtn;
	
	public WebElement Filtercolour(String colour) {
		return driver.findElement(By.xpath("//div[@id='colour']//span[contains(text(),'" + colour + "')]"));
	}
	
	public WebElement Filtercolor(String color) {
		return driver.findElement(By.xpath("//div[@id='color']//span[contains(text(),'" + color + "')]"));
	}
	public WebElement Filterstyle(String style) {
		return driver.findElement(By.xpath("//div[@id='style']//span[contains(text(),'" + style + "')]"));
	}

	public WebElement Filterpattern(String pattern) {
		return driver.findElement(By.xpath("//div[@id='pattern']//span[contains(text(),'" + pattern + "')]"));
	}

	public WebElement Filterneckline(String neckline) {
		return driver.findElement(By.xpath("//div[@id='neckline']//span[contains(text(),'" + neckline + "')]"));
	}
	
	public WebElement Filternlength(String length) {
		return driver.findElement(By.xpath("//div[@id='length']//span[contains(text(),'" + length + "')]"));
	}

	public String Stylesavailable() {
		return driver.findElement(By.xpath(
				"//div[@class='search-results__count-row row']//span[contains(@class,'results-count results-count--desktop')]"))
				.getText();
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"product-search-results\"]//p[contains(@class,'paging__page paging__page--button paging__page--next text-uppercase')]/i")
	public WebElement paginationfrwd;

	@FindBy(how = How.XPATH, using = "//*[@id='product-search-results']//p[contains(@class,'paging__page paging__page--button paging__page--back text-uppercase')]/i")
	public WebElement paginationback;

	@FindBy(how = How.XPATH, using = "//div[@class='paging__pages text-center']//p[contains(@class,'paging__page paging__page--of-last')][1]//span[contains(@class,'paging__page-text')]")
	public WebElement pagecount;

	@FindBy(how = How.XPATH, using = "//span[@class='page-sizes results-count__page-sizes']//*[contains(text(),'All')]")
	public WebElement ALL;

	@FindBy(how = How.XPATH, using = "//*[@id='product-search-results']//span[@class='page-sizes results-count__page-sizes']//span[@class='page-size-options']/a")
	public WebElement listeditems;

	@FindBy(how = How.XPATH, using = "//a[@class='filters__reset-link reset']")
	public WebElement clearallfilters;

	@FindBy(how = How.XPATH, using = "//*[@id=\"image-switch\"]")
	public WebElement imageswitch;

	public String imagesrc(int i) {
		return driver.findElement(By.xpath(
				"//div[@class='product-tiles row no-gutters w-100']//div[" + i + "]//div[@class='product']//img"))
				.getAttribute("src");
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"product-search-results\"]/div[2]/div[3]/div/div[2]/div[1]/div/div/div[1]/div[1]/a[2]")
	public WebElement firstimagequickadd;

	public WebElement selectquickaddsize(int i) {
		return driver.findElement(By.xpath(
				"//*[@class=\"product-tile__add-overlay container-fluid px-0 d-flex flex-wrap justify-content-center\"]/div[2]/div//label[contains(text(),'"
						+ i + "')]"));
	}

	@FindBy(how = How.XPATH, using = "//*[@class=\"product-tile__add-overlay container-fluid px-0 d-flex flex-wrap justify-content-center\"]/div[2]/div/div[3]/div/div/button[1]")
	public WebElement quickaddtobag;

	// ....................................p2_all_desktop_wishlist................................

	@FindBy(how = How.XPATH, using = "//div[@class='header-element header-element__wishlist wishlist']//span[@class='header-element__icon']//i")
	public WebElement wishlistIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='content-asset']//a[@class='btn btn-secondary w-lg-25 mt-3']")
	public WebElement emptyWishlist;

	public List<WebElement> plpHeartIcon() {
		return driver
				.findElements(By.xpath("//i[@class='font-icon icon-heart2 wishlist-icon wishlist-icon--inactive']"));
	}

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-secondary add-to-wish-list']//i[@class='font-icon icon-heart2 wishlist-icon wishlist-icon--inactive']")
	public WebElement wishlistBtn;

	@FindBy(how = How.XPATH, using = "//button[@class='remove-from-wishlist bg-transparent border-0']//i[@class='font-icon icon-cross ']")
	public WebElement productCloseBtn;

	@FindBy(how = How.XPATH, using = "//div[@class='wishlist__size-selector']//select[@class='input-select form-control']")
	public WebElement size;
	
	@FindBy(how = How.XPATH, using = "//button[@class='add-to-cart btn btn-block btn-secondary mt-2']")
	public WebElement addtoBag;

	@FindBy(how = How.XPATH, using = "//div[@class='product-card__image-container']")
	public WebElement productInBag;

	@FindBy(how = How.XPATH, using = "//div[@class='product-detail__add-to-wishlist__notification mt-2 py-1 text-center']")
	public WebElement addwishlistMsg;
	//div[contains(text(),'Added to Wishlist')]
	
	@FindBy(how = How.XPATH, using = "//div[@class='paging__next show-more text-center']//p")
	public WebElement loadMore;

	@FindBy(how = How.XPATH, using = "//div[@class='paging-status']//i[@class='d-block paging__status-bar--progress']")
	public WebElement pageStatus;

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'product-detail__attribute product-detail__attribute--size')]/div[2]/div/div/div/div/div[2]")
	public WebElement Uksizetooltip;
	
	@FindBy(how = How.XPATH, using = "(//span[@class='paging__page paging__page--current']//span)[1]")
	public WebElement currentpagePLP;
	
	@FindBy(how = How.XPATH, using = "//div[@class='col-6 pl-1']//a[contains(text(),'Apply Filters')]")
	public WebElement filterPanel;

}
