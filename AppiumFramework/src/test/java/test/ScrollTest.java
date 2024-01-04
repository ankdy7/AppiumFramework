package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollTest extends BaseTest {

	@Test
	public void executeTest() {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//when you know which element to scroll to
		String scrollTo = "\""+"Picker"+"\"";
		scrollToElement(scrollTo);
		//keepScrolling();
		
		

	}
}
