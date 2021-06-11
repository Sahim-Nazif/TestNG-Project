package functional.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTest {

	@Test(dataProvider = "register")
	public void driverSetup(String firstName, String lastName, String email, String phone, String password) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.funnelytics.io/register?_fs=4f04e95c-ed96-48ac-9793-02cbce4f4649");
		driver.findElement(By.id("first_name")).sendKeys(firstName);
		driver.findElement(By.id("last_name")).sendKeys(lastName);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("phoneNumber")).sendKeys(phone);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@DataProvider(name = "register")
	public Object[][] dataSet() {

		return new Object[][] { { "John", "Doe", "john@doe.com", "567 801 2001", "mypassword" }

		};

	}

}
