package AutomationTestingByM.Appium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationTestingByM.Appium.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;

public class FormFillPage extends AndroidActions {

	 protected AndroidDriver driver;

	public FormFillPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@FindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement genderRadioF;

	@FindBy(id = "android:id/text1")
	private WebElement countrySeclection;

	@FindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement genderRadioM;
	
	@FindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopbtn;

	public void fillFormActions() {
		nameField.sendKeys("Mohit Kumar");
		driver.hideKeyboard();
		genderRadioF.click();
	}

	public void selectCountry(String text) {
		countrySeclection.click();
		scrollToText(text);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + text + "']")).click();
	}
	
	public void submitBtn() {
		shopbtn.click();
	}

}
