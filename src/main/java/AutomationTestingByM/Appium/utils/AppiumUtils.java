package AutomationTestingByM.Appium.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	public AppiumDriverLocalService service;

	public AppiumDriverLocalService startService(String ipAddress,int port) {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Jyoti Singh\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
		service.start();
		return service;
	}
	
	public String getScreenShot(AppiumDriver driver,String testName) throws IOException {
		File source= driver.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"//reports"+testName+".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}

}
