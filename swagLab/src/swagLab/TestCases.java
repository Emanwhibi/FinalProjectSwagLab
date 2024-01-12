package swagLab;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import dev.failsafe.internal.util.Assert;

public class TestCases {
	String myWebSite = "https://www.saucedemo.com/inventory.html";
	String UserName = "standard_user";
	String Password = "secret_sauce";
	WebDriver driver = new ChromeDriver();
	Random rand = new Random();

	@BeforeTest

	public void myBeforeTest() {
		driver.manage().window().maximize();
		driver.get(myWebSite);

	}

	@Test(priority = 1)

	public void loginTest() throws InterruptedException {
		WebElement UserNameInput = driver.findElement(By.id("user-name"));
		WebElement PasswordInput = driver.findElement(By.id("password"));
		WebElement LogIn = driver.findElement(By.className("submit-button"));

		UserNameInput.sendKeys("standard_user");
		PasswordInput.sendKeys("secret_sauce");
		LogIn.click();

		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void listitem() throws InterruptedException {
		WebElement myList= driver.findElement(By.className("inventory_list"));
		List<WebElement> AllItem=myList.findElements(By.className("inventory_item"));

		int index= rand.nextInt(AllItem.size());
		int indextwo= rand.nextInt(AllItem.size());
		
		while (index == indextwo) {
		    indextwo = rand.nextInt(AllItem.size());
		}

		AllItem.get(index).findElement(By.className("btn_primary")).click();

		AllItem.get(indextwo).findElement(By.className("btn_primary")).click();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
		Thread.sleep(6000);		



	}



	@Test(priority = 4)
	public void logoutTest() throws InterruptedException {
		WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
		menuButton.click();
		Thread.sleep(3000);
		WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
		logoutButton.click();
		Thread.sleep(7000);

	}

	@Test(priority = 3)
	public void checkoutTest() throws InterruptedException {
		WebElement cart = driver.findElement(By.cssSelector(".shopping_cart_link"));
		cart.click();

		WebElement checkoutButton = driver.findElement(By.cssSelector(".checkout_button"));
		checkoutButton.click();

		WebElement firstNameField = driver.findElement(By.id("first-name"));
		WebElement lastNameField = driver.findElement(By.id("last-name"));
		WebElement zipCodeField = driver.findElement(By.id("postal-code"));
		WebElement continueButton = driver.findElement(By.cssSelector(".cart_button"));
		
		Thread.sleep(5000);

		firstNameField.sendKeys("Eman");
		lastNameField.sendKeys("Whibi");
		zipCodeField.sendKeys("12345");
		continueButton.click();
		Thread.sleep(5000);

		WebElement finishButton = driver.findElement(By.cssSelector(".cart_button"));
		finishButton.click();
		Thread.sleep(7000);

	}

	@AfterTest
	public void MyAfterTest() {
	}

}
