package functional.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GroupsByTestTypes {

	public WebDriver driver;

	@Test(priority = 1, description = "Driver setup")
	public void webDriverSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/inputs");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(priority = 2, groups = "regression")
	public void functionalTestingOne() {

		WebElement number = driver.findElement(By.xpath("//input[@type='number']"));

		number.sendKeys("3");
		delayRun(3000);

	}

	@Test(priority = 3, groups = "regression")
	public void functionalTestingTwo() {

		// check if link is working
		WebElement link = driver.findElement(By.xpath("//a[normalize-space()='Elemental Selenium']"));
		link.click();
		delayRun(2000);
		driver.quit();
	}

	public void checkLoginTitle() {

	}

	public void delayRun(long miliseconds) {

		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
