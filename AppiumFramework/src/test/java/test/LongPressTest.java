package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPressTest extends BaseTest {

	@Test
	public void executeTest() {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement item = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(item);
		
		System.out.println(driver.findElement(By.id("android:id/title")).getText());
		Assert.assertEquals(driver.findElement(By.id("android:id/title")).getText(), "Sample menu");
		

	}
}
