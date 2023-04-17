package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {
	String parentWindowHandle;
	WebDriver driver = null;
	
	@Given("open Google Chrome browser")
	public void open_google_chrome_browser() {
System.out.println("Starting - browser is open");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path: " + projectPath);
		
		System.setProperty("webdriver.chrome.driver",projectPath + "/src/test/resources/drivers/chromedriver" );
	
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		parentWindowHandle = driver.getWindowHandle();
		
		System.out.println("Ending - browser is open");
	}


	@Given("navigate to the Sapiens IDIT Suite home page")
	public void navigate_to_the_sapiens_idit_suite_home_page() {
		driver.navigate().to("https://vh-idit-uat.sapiensmgs.com/idit-web/web-framework/login.do?isSameWindow=true");
	}

	@When("^the user enters a valid (.*)$")
	public void the_user_enters_a_valid_username(String username) {
		driver.findElement(By.id("UserName")).sendKeys(username);
	}

	@When("^user enters a valid (.*)$")
	public void user_enters_a_valid_password(String password) {
		driver.findElement(By.id("Password")).sendKeys(password);
	}

	@When("the user clicks the button Login")
	public void the_user_clicks_the_button_login() {
		driver.findElement(By.id("Login")).click();
	}

	@Then("^the login is (.*)$")
	public void the_login_is_successful(String status) {
		System.out.println("The Status of the test is " + status);
		//driver.getPageSource().contains("The username/password provided is invalid.");
		//driver.close();
		//driver.quit();
	}
//	@When("the user enters an incorrect password")
//	public void the_user_enters_an_incorrect_password() {
//		driver.findElement(By.id("Password")).sendKeys("fasss");
//	}
//
//	@Then("the login is unsuccessful")
//	public void the_login_is_unsuccessful() {
//		driver.getPageSource().contains("The username/password provided is invalid.");
//		//driver.close();
//		//driver.quit();
//	}


}
