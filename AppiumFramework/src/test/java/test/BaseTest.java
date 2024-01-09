package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	// global variables
	public AppiumDriverLocalService service;
	public AndroidDriver driver;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {

		
		// start appium server automatically
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\Dank\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		// define where appium starts
		URL url = new URL("http://127.0.0.1:4723/");
		// driver responsible for automation
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("DankPhone");

		options.setApp(
	//			"C:\\Users\\Dank\\Downloads\\eclipse-workspace-20240102T221256Z-001\\eclipse-workspace\\AppiumTest\\src\\test\\java\\Resources\\ApiDemos-debug.apk");
	"C:\\Users\\Dank\\git\\AppiumFramework\\AppiumFramework\\src\\test\\java\\Resources\\General-Store.apk");
		driver = new AndroidDriver(url, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void longPressAction(WebElement item) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) item).getId(), "duration", 2000));
	}

	public void scrollToElement(String scrollTo) {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(" + scrollTo + "))"));
	}

	public void keepScrolling() {
		boolean canScrollMore = true;

		// when you just want to scroll up or down
		while (canScrollMore) {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		}
	}
	
	public void swipeLeftToElement(WebElement firstImage, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)firstImage).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}

	// @AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
