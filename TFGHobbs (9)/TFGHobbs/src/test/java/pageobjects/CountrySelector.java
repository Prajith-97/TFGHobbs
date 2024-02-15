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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.WebDriverManagedef;

public class CountrySelector {

	WebDriver driver;

	public CountrySelector(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='main-nav']")
	public WebElement mainCategoryNav;
	
	@FindBy(how = How.XPATH, using = "//div[@class='country-selector-link']//a[@class='country-selector__current']//span")
			//"(//div[@class='country-selector']//preceding-sibling::a)[1]")
	public WebElement countrySelectorBtn;

	@FindBy(how = How.XPATH, using = "(//div[@id='countrySelector']//div)[2]")
	public WebElement countrySelectorPopup;

	@FindBy(how = How.XPATH, using = "//div[@id='countrySelector']//button")
	public WebElement submitBtn;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/header/nav/div/div/div[4]/div/div[1]/div/a/span[1]")
	public WebElement countrynameselected;

	@FindBy(how = How.ID, using = "countryDropdown")
	public WebElement countrySelectorDropDown;

	public WebElement CountryInDropDown(String country) {
		return driver.findElement(By.xpath("//div[@data-value='" + country + "']"));
	}


}
