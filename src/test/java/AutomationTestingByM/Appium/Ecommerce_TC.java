package AutomationTestingByM.Appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import AutomationTestingByM.Appium.PageObjects.FormFillPage;
import io.appium.java_client.AppiumBy;

public class Ecommerce_TC extends BaseTest {
	
	@Test
	public void FillForm() throws InterruptedException {
		Thread.sleep(5000);
		FormFillPage fm=new FormFillPage(driver);
		fm.fillFormActions();
		fm.selectCountry("Argentina");
		fm.submitBtn();
	}
	
	@Test(dependsOnMethods = "FillForm" )
	public void AddToCart() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));
		int productCount=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<productCount;i++) {
			 String productName= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			 if(productName.equalsIgnoreCase("Jordan 6 Rings")) {
				 driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			 }
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		//String lastPage= driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		
	}

}
