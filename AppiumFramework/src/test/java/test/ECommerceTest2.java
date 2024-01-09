package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

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

	}
}
