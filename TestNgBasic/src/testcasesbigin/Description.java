package annotationpractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Description {

	@Test(description="Error checking...")
	public void checkErrormsg()
	{
		Assert.assertEquals(3, 3);
		System.out.println(1);
		Assert.assertEquals(2, 2);
		System.out.println(2);
		Assert.assertEquals(2, 3);
		System.out.println(3);
		Assert.assertEquals(2, 2);
		System.out.println(4);
		Assert.assertEquals(5, 5);
		System.out.println(5);
	}
	
	@Test(description="Error checking part 1...")
	public void checkErrormsg_1()
	{
		Assert.assertEquals(3, 3);
		System.out.println(111);
		Assert.assertEquals(2, 2);
		System.out.println(222);
		Assert.assertEquals(3, 3);
		System.out.println(333);
		Assert.assertEquals(2, 2);
		System.out.println(444);
		Assert.assertEquals(5, 5);
		System.out.println(555);
	}
	

}

