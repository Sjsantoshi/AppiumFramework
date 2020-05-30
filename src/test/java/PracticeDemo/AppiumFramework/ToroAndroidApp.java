package PracticeDemo.AppiumFramework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ToroAndroidApp extends ToroBaseClass
{
	@Test
	public void Login() throws InterruptedException, IOException
	{
		//Test
		service = startAppiumServer();
		startEmulator();
		Thread.sleep(6000);
		AndroidDriver<AndroidElement> driver = capabilities("appApk");
		ToroPageClass tp = new ToroPageClass(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Clicks on English language and continues with Tutorial screens
		tp.getLanguageScreen().click();
		Thread.sleep(2000);
		tp.Tutorial1.click();
		tp.Tutorial2.click();
		tp.Tutorial3.click();
		
		//Sign in to Toro Admin
		tp.email.sendKeys("admin@toro.com");
		tp.password.sendKeys("password@123");
		tp.signin.click();
		
		Thread.sleep(5000);
		
		//Search for springrole and login there
		tp.search.sendKeys("Springrole");
		tp.tapCompany.click();
		
		service.stop();
	}

}
