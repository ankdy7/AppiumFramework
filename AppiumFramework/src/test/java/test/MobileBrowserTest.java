package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobileBaseTest {
	
	@Test
	public void browserTest() {
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("audrey bitoni");
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.ENTER);
	}

}
