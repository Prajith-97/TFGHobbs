//package stepdefs;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;
//import io.qameta.allure.Story;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//@Epic("Allure reporting for TFG Hobbs automation")
//@Feature("TestNG support")
//public class RunJourney2 {
//
//WebDriver driver;
//	
//	public void setupWebAutomation() throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		Thread.sleep(3000);
//	}
//	
//	@Test
//	@Story("accept cookie")
//	@Given("accept cookie")
//	public void accept_cookie() throws InterruptedException {
//		setupWebAutomation();
//		System.out.println("I am in accept cooki step");
//	}
//	
//	@Test
//	@Story("handle cookie")
//	@And("handle cookie")
//	public void handle_cookie() {
//		System.out.println("I am in handle cookie step");
//	}
//	
//	@Test
//	@Story("select random")
//	@Given("select random")
//	public void select_random() {
//		System.out.println("I am in select random step");
//	}
//	
//	@Test
//	@Story("on nav category")
//	@And("on nav category")
//	public void on_nav_category() {
//		System.out.println("I am in on nav category step");
//	}
//}
