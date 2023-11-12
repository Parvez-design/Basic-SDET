package TestCases;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Problem_4 extends BaseTest{
	
	@Test(priority = 1, enabled=true, timeOut = 10000)
	public static void verifyLinks() {
		String[] s = {"products", "solutions", "resources", "rpa", "company"};
		action = new Actions(driver);
		WebElement products = driver.findElement(By.linkText("Products"));
		WebElement solutions = driver.findElement(By.linkText("Solutions"));
		WebElement resources = driver.findElement(By.linkText("Resources"));
		WebElement beyondRPA = driver.findElement(By.linkText("Beyond RPA"));
		WebElement company = driver.findElement(By.linkText("Company"));
		waitt(products);
		action.keyDown(Keys.CONTROL).click(products).keyUp(Keys.CONTROL).build().perform();
		waitt(solutions);
		action.keyDown(Keys.CONTROL).click(solutions).keyUp(Keys.CONTROL).build().perform();
		waitt(resources);
		action.keyDown(Keys.CONTROL).click(resources).keyUp(Keys.CONTROL).build().perform();
		waitt(beyondRPA);
		action.keyDown(Keys.CONTROL).click(beyondRPA).keyUp(Keys.CONTROL).build().perform();
		waitt(company);
		action.keyDown(Keys.CONTROL).click(company).keyUp(Keys.CONTROL).build().perform();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getCurrentUrl());
		}
	}
}
