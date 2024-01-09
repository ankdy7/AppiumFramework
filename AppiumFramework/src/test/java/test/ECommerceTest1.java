package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ECommerceTest1 extends BaseTest {

	@Test
	public void fillForm() throws InterruptedException {

		driver.findElement(
				By.xpath("//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']"))
				.sendKeys("Ankur Dey");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		// driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		String scrollTo = "\"" + "Azerbaijan" + "\"";
		// scrollToElement(scrollTo);
		// driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1'
		// and @text='Azerbaijan']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		// Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name"),"Please
		// enter your name");
		scrollTo = "\"" + "Jordan 6 Rings" + "\"";
		scrollToElement(scrollTo);

		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

		for (int i = 0; i < count; i++) {
			String name = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

			if (name.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

			}

		}

		driver.findElement(By.xpath(
				"//android.widget.ImageButton[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']"))
				.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText(),
				"Jordan 6 Rings");

	}
}
