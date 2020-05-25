package PracticeDemo.AppiumFramework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ToroPageClass {
	
	public ToroPageClass(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
	public WebElement languageContinue;
	
	@AndroidFindBy(id = "com.toro.horizon360:id/continue_btn")
	public WebElement Tutorial1;
	
	@AndroidFindBy(id = "com.toro.horizon360:id/continue_btn")
	public WebElement Tutorial2;
	
	@AndroidFindBy(id = "com.toro.horizon360:id/continue_btn")
	public WebElement Tutorial3;
	
	@AndroidFindBy(id = "com.toro.horizon360:id/email_edit_text")
	public WebElement email;
	
	@AndroidFindBy(id = "com.toro.horizon360:id/password_edit_text")
	public WebElement password;
	
	@AndroidFindBy(id = "com.toro.horizon360:id/sign_up_btn")
	public WebElement signin;
	
	@AndroidFindBy(id="com.toro.horizon360:id/search")
	public WebElement search;
	
	@AndroidFindBy(id = "com.toro.horizon360:id/next_icon")
	public WebElement tapCompany;

    public WebElement getLanguageScreen()
    {
    	System.out.println("Clicks on English in the language selection screen");
    	return languageContinue;
    }

	

}
