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

public class ToroBaseClass {

	public static AndroidDriver<AndroidElement> capabilities(String appApk) throws IOException
	{
		File f = new File("src");
		
		FileInputStream fs = new FileInputStream("C:\\Users\\Springworks\\eclipse-workspace1\\AppiumFramework\\src\\main\\java\\PracticeDemo\\AppiumFramework\\global.properties");
		Properties prop = new Properties();
		prop.load(fs);
		File app = new File(f, (String)prop.get(appApk));

		DesiredCapabilities dc = new DesiredCapabilities();
		String realDevice = (String)prop.get("realDevice");
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
