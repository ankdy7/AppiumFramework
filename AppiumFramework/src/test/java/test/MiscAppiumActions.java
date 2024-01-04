package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class MiscAppiumActions extends BaseTest {

	@Test
	public void AppiumBasics() throws MalformedURLException, InterruptedException {

		//directly navigate to a particular page
		/*Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);*/

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		String fieldName = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).getText();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		//Screen Rotation
		DeviceRotation landscape = new DeviceRotation(0,0,90);
		driver.rotate(landscape);
		 driver.findElement(By.xpath(
				"//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout"))
				.getText();
		System.out.println(fieldName);
		driver.findElement(By.xpath(
				"//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout"))
				.click();

		Assert.assertEquals(fieldName, "3. Preference dependencies");
		//Copy Paste method
		driver.setClipboardText("Wifi Name");
		driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		//Buttons - back, home, recent
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		//adb shell dumpsys window | find "mCurrentFocus
		
		

	}
}
