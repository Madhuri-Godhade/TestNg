package testcasesbigin;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestCases {
	@Test
	public void checkTestOne()
	{
		Assert.assertEquals(2, 5);
	}

	@Test
	public void checkTestTwo()
	{
		Assert.assertEquals(5, 5);
	}

	@Test
	public void checkTestThree()
	{
		Assert.assertEquals(7, 7);
	}

	@Test
	public void checkTestfour()
	{
		Assert.assertEquals(3, 5);
	}

	@Test
	public void checkTestFive()
	{
		Assert.assertEquals(6, 6);
	}
}
