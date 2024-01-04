package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ECommerceTest extends BaseTest{

	@Test
	public void fillForm() {
		
		//driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']")).sendKeys("Ankur Dey");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		String scrollTo = "\""+"Azerbaijan"+"\"";
		scrollToElement(scrollTo);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Azerbaijan']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name"),"Please enter your name");
		
	}
}
