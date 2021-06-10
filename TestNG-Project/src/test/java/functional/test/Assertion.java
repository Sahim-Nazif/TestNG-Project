package functional.test;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion {

	public WebDriver driver;

	@Test(priority = 1, description = "Driver setup")
	public void webDriverSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/abtest");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(priority = 2)
	public void compareText() {

		String expectedTitle = "A/B Test Variation 1";
		WebElement title = driver.findElement(By.tagName("h3"));
		String actualTitle = title.getText();
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test(priority = 3)
	public void closeBrowser() {

		driver.close();
	}

}
