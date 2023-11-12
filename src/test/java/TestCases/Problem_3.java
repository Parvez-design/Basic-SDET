package TestCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Problem_3 extends BaseTest{
	
	@Test(priority = 1, enabled=true, timeOut = 5000)
	public static void verifyLogo() {
		WebElement logo = driver.findElement(By.xpath("//img[@src='/sites/default/files/images/default-images/logo-aa-new.svg']"));
		waitt(logo);
		Assert.assertTrue(logo.isDisplayed());
	}
	
	@Test(priority = 2, enabled=true, timeOut = 5000)
	public static void RequestDemo() {
		action = new Actions(driver);
		WebElement button = driver.findElement(By.cssSelector("a[title='Request demo']"));
		if(button.isEnabled()) {
			System.out.println("Button is enabled");
		}
	}
}
