package testcasesbigin_demo1;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminTestCase1 {
	
	@BeforeMethod
	public void clearCheckBoxes()
	{
		System.out.println("Clearing all check boxes Admin functionality..........");
	}
	
	@Test
	public void checkErrorMsgAdmin1()
	{
		System.out.println("checkErrorMsgAdmin1..............");
		Assert.assertEquals(3, 3);
	}

	@Test
	public void checkErrorMsgAdmin2()
	{
		System.out.println("checkErrorMsgAdmin 2..............");
		Assert.assertEquals(3, 3);
	}
}
