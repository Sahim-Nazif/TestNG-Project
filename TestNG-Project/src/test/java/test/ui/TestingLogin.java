package test.ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingLogin {

	public WebDriver driver;

	@Test(priority = 1)
	public void webDriverSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(priority = 2)
	public void typeInSearchBar() {

		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("tomsmith");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("SuperSecretPassword!");

		WebElement btn = driver.findElement(By.xpath("//button[@type='submit']"));

		btn.click();

	}

	@Test(priority = 3)
	public void closeBrowser() {
		driver.close();
	}

}
