package PracticeDemo.AppiumFramework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ToroAndroidAppTest extends ToroBaseTest
{

	@Test
	public void Tutorial() throws InterruptedException, IOException
	{
		service = startAppiumServer();
		//startEmulator();
		Thread.sleep(6000);
		AndroidDriver<AndroidElement> driver = capabilities("appApk");
		ToroPageClassTest tp = new ToroPageClassTest(driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//Clicks on English language and continues with Tutorial screens
		tp.getLanguageScreen().click();
		Thread.sleep(8000);
		tp.Tutorial1.click();
		tp.Tutorial2.click();
		tp.Tutorial3.click();
		Thread.sleep(3000);

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
