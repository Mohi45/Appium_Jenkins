package AutomationTestingByM.Appium;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import AutomationTestingByM.Appium.utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest extends AppiumUtils {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws IOException {
		Properties prop =new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//data.properties");
		prop.load(fis);
		String ipAddress=prop.getProperty("ipAddress");
		int port = Integer.parseInt(prop.getProperty("port"));
		
		service = startService(ipAddress, port);

		// this config things for appium
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixcel_6");
		options.setApp("C:\\Users\\Jyoti Singh\\Desktop\\Appium\\src\\test\\java\\resources\\General-Store.apk");
		
		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
