package test.ui;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
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
}
