package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static String url = "https://www.automationanywhere.com/";
	public static Actions action;
//	public static FileInputStream fileLoc;
//	public static Properties prop;
	@BeforeSuite
	public static void initialize() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		WebElement cookie = driver.findElement(By.id("onetrust-accept-btn-handler"));
		if(cookie.isEnabled()) cookie.click();
	}
	public static void waitt(WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).
		until(ExpectedConditions.visibilityOf(element));
	}
}
