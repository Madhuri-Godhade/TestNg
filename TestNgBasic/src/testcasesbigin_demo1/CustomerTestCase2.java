package testcasesbigin_demo1;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerTestCase2 {

	@BeforeMethod
	public void clearCheckBoxes()
	{
		System.out.println("Clearing all check boxes Customer functionality..........");
	}
	
	@Test
	public void checkErrorMsgCustomer3()
	{
		System.out.println("checkErrorMsgCostomer 3 ..............");
		Assert.assertEquals(3, 3);
	}
	
	@Test
	public void checkErrorMsgCustomer4()
	{
		System.out.println("checkErrorMsgCostomer 4 ..............");
		Assert.assertEquals(3, 3);
	}

}
