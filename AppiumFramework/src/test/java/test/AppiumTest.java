package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumTest extends BaseTest {

	@Test
	public void AppiumBasics() throws MalformedURLException, InterruptedException {

		

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		String fieldName = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).getText();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		 driver.findElement(By.xpath(
				"//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout"))
				.getText();
		System.out.println(fieldName);
		driver.findElement(By.xpath(
				"//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout"))
				.click();

		Assert.assertEquals(fieldName, "3. Preference dependencies");
		driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Zzzz");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

	}
}
