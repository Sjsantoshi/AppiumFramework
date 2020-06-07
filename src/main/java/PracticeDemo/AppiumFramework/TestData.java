package PracticeDemo.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name = "InputData")
	public Object[][] getInputData()
	
	{
		Object[][] obj= new Object[][]
		{
		{"Springrole"}, {"QB Test Company"}
	    };
	    
	    return obj;
	}	
}
