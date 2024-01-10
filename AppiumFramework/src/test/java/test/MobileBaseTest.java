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

public class MobileBaseTest {
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
		options.setChromedriverExecutable(
				"C:\\Users\\Dank\\git\\AppiumFramework\\AppiumFramework\\src\\test\\java\\Resources\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");

		driver = new AndroidDriver(url, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	// @AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
