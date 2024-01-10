package test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.chromium.ChromiumDriver;

public class ECommerceTest2 extends BaseTest {

	@Test
	public void fillForm() throws InterruptedException {
		double sum = 0.0;

		driver.findElement(
				By.xpath("//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']"))
				.sendKeys("Ankur Dey");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[1]"))
				.click();
		driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[2]"))
				.click();

		driver.findElement(By.xpath(
				"//android.widget.ImageButton[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']"))
				.click();

		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		for (int i = 0; i < count; i++) {
			String priceText = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i)
					.getText();
			double price = Double.parseDouble(priceText.substring(1, priceText.length() - 1));
			sum = sum + price;

		}

		double lastPageTotal = Double.parseDouble(
				driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(2,
						driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().length()
								- 1));
		Assert.assertEquals(lastPageTotal, sum);
		
		WebElement terms = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(terms);
		System.out.println(driver.findElement(By.id("android:id/message")).getText());
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
		
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(AppiumBy.className("android.widget.Button")).click();
		
		Thread.sleep(2000);
		Set <String> contextNames = driver.getContextHandles();
		for(String x : contextNames) {
		System.out.println(x);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("audrey bitoni");
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		

	}
}
