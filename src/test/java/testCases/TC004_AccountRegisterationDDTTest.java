package testCases;

import org.testng.annotations.Test;

import utilities.DataProviderClass;

public class TC004_AccountRegisterationDDTTest {

	@Test(dataProvider ="RegData", dataProviderClass=DataProviderClass.class, groups= {"Datadriven"})
	
	public void TestRegDDT()
	{
		
	}
}
