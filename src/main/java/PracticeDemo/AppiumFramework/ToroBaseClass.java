package PracticeDemo.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class ToroBaseClass {
	
	public static AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startAppiumServer()
	{
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		return service;
	}
	
	public static void startEmulator() throws IOException, InterruptedException
	{
		//C:\Users\Springworks\eclipse-workspace1\AppiumFramework\src\main\java\resources\startEmulator.bat
		Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(10000);
	}

	public static AndroidDriver<AndroidElement> capabilities(String appApk) throws IOException, InterruptedException
	{
		File f = new File("src");
	//	System.getProperty("user.dir");
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\PracticeDemo\\AppiumFramework\\global.properties");
		Properties prop = new Properties();
		prop.load(fs);
		File app = new File(f, (String)prop.get(appApk));

		DesiredCapabilities dc = new DesiredCapabilities();
		String realDevice = (String)prop.get("realDevice");
		if(realDevice.contains("Pixel"))
		{
			startEmulator();
		}
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, realDevice);
		
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		String appPackage = (String)prop.get("appPackage");
		dc.setCapability("appPackage", appPackage);
		
		String appActivity = (String)prop.get("appActivity");
		dc.setCapability("appActivity", appActivity);
		
	//	dc.setCapability(MobileCapabilityType.APP ,fs.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		return driver;
		
		
		
		
	}
}
