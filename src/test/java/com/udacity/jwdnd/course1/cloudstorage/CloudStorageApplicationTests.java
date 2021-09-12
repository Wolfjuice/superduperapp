package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.time.Duration;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudStorageApplicationTests {

	@LocalServerPort
	private int port;

	private WebDriver driver;

	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void beforeEach() {
		this.driver = new ChromeDriver();
	}

	@AfterEach
	public void afterEach() {
		if (this.driver != null) {
			driver.quit();
		}
	}

	@Test
	public void getLoginPage() {
		driver.get("http://localhost:" + this.port + "/login");
		Assertions.assertEquals("Login", driver.getTitle());
	}

	@Test
	public void getSignupPage() {
		driver.get("http://localhost:" + this.port + "/signup");
		Assertions.assertEquals("Sign Up", driver.getTitle());
	}

	@Test
	public void getUnauthorizedHomePage() {
		driver.get("http://localhost:" + this.port + "/home");
		Assertions.assertEquals("Login", driver.getTitle());
	}

	@Test
	public void getUnauthorizedResultPage() {

		driver.get("http://localhost:" + this.port + "/result");

		Assertions.assertEquals("Login", driver.getTitle());
	}

	@Test
	public void signMeUp() {

		driver.get("http://localhost:" + this.port + "/signup");
		WebElement inputFirstName = driver.findElement(By.id("inputFirstName"));
		inputFirstName.sendKeys("Wild");
		WebElement inputLastName = driver.findElement(By.id("inputLastName"));
		inputLastName.sendKeys("Animal");
		WebElement inputUsername = driver.findElement(By.id("inputUsername"));
		inputUsername.sendKeys("Lion");
		WebElement inputPassword = driver.findElement(By.id("inputPassword"));
		inputPassword.sendKeys("Meat");
		WebElement signUpButton = driver.findElement(By.id("submit-button"));
		signUpButton.click();

		Assertions.assertEquals("Login", driver.getTitle());

	}

	@Test
	public void logMeInAndThenLogMeOut() {


		driver.get("http://localhost:" + this.port + "/login");
		WebElement Username = driver.findElement(By.id("inputUsername"));
		Username.sendKeys("Lion");
		WebElement Password = driver.findElement(By.id("inputPassword"));
		Password.sendKeys("Meat");
		WebElement loginButton = driver.findElement(By.id("letsLogIn"));
		loginButton.click();
		Assertions.assertEquals("Home", driver.getTitle());
		WebElement logoutButton = driver.findElement(By.id("letsLogOut"));
		logoutButton.click();
		Assertions.assertEquals("Login", driver.getTitle());
	}
	@Test
	public void createNewNote() {

		driver.get("http://localhost:" + this.port + "/login");
		WebElement Username = driver.findElement(By.id("inputUsername"));
		Username.sendKeys("Lion");
		WebElement Password = driver.findElement(By.id("inputPassword"));
		Password.sendKeys("Meat");
		WebElement loginButton = driver.findElement(By.id("letsLogIn"));
		loginButton.click();
		Assertions.assertEquals("Home", driver.getTitle());

		WebElement showForm = driver.findElement(By.id("openNoteForm"));
		showForm.click();


		WebElement notetitle = driver.findElement(By.id("note-title"));
		WebElement notedescription = driver.findElement(By.id("note-description"));
		notetitle.sendKeys("Greatest Alligator");
		notedescription.sendKeys("Pigeon blood ruby is the most sought-after color variety of ruby gemstone. Pigeon Blood Ruby meaning is primarily associated with its color that matches exactly with the blood drawn from a freshly killed pigeon.It displays bright red hue with a slight tint of purple that appears deep red when seen in light.");
		WebElement savechanges = driver.findElement(By.id("save-changes"));
		savechanges.click();
		Assertions.assertEquals("Home", driver.getTitle());

	}







}
