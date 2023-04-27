package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {
	WebDriver driver = null;

	@Given("open Google Chrome browser")
	public void open_google_chrome_browser() {
System.out.println("Starting - browser is open");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path: " + projectPath);
		
		System.setProperty("webdriver.chrome.driver",projectPath + "/src/test/resources/drivers/chromedriver" );
	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Ending - browser is open");
	}


	@And("navigate to the Sapiens IDIT Suite home page")
	public void navigate_to_the_sapiens_idit_suite_home_page() throws InterruptedException {
		driver.navigate().to("https://vh-idit-uat.sapiensmgs.com/idit-web/web-framework/login.do?isSameWindow=true");
		Thread.sleep(1000);
	}

	@When("^the user enters a valid (.*)$")
	public void the_user_enters_a_valid_username(String username) {
		driver.findElement(By.id("UserName")).sendKeys(username);
	}

	@And("^user enters a valid (.*)$")
	public void user_enters_a_valid_password(String password) {
		driver.findElement(By.id("Password")).sendKeys(password);
	}

	@And("the user clicks the button Login")
	public void the_user_clicks_the_button_login() {
		driver.findElement(By.id("Login")).click();
	}

	@Then("^the login is (.*)$")
	public void the_login_is_successful(String status) {
		System.out.println("The Status of the test is " + status);
		
		//driver.close();
		//driver.quit();
      WebElement errorMessage = driver.findElement(By.id("login_error_span"));
      //The maximum number of attempts to login was reached; please contact your system administrator.
      String expectedErrorMessage = "The maximum number of attempts to login was reached; please contact your system administrator.";
      String actualErrorMessage = errorMessage.getText();

      Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}
}



//V2
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class FailedTestScenario {
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }
//
//    @Test
//    public void loginTest() {
//        driver.get("https://example.com/login");
//        WebElement emailField = driver.findElement(By.id("email"));
//        emailField.sendKeys("invalidemail@example.com");
//
//        WebElement passwordField = driver.findElement(By.id("password"));
//        passwordField.sendKeys("password");
//
//        WebElement loginButton = driver.findElement(By.id("login-button"));
//        loginButton.click();
//
//        WebElement errorMessage = driver.findElement(By.className("error-message"));
//        String expectedErrorMessage = "Invalid email or password";
//        String actualErrorMessage = errorMessage.getText();
//
//        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
//}

