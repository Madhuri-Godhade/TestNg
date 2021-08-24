package testcasesbigin_demo1;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerTestCase1 {

	@BeforeMethod
	public void clearCheckBoxes()
	{
		System.out.println("Clearing all check boxes Customer functionality..........");
	}
	
	@Test
	public void checkErrorMsgCustomer1()
	{
		System.out.println("checkErrorMsgCostomer 1 ..............");
		Assert.assertEquals(3, 3);
	}
	
	@Test
	public void checkErrorMsgCostomer2()
	{
		System.out.println("checkErrorMsgCostomer 2..............");
		Assert.assertEquals(3, 3);
	}

}
