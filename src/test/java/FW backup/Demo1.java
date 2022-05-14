package script;

import org.testng.Reporter;
import org.testng.annotations.Test;


import generic.BaseTest1;

public class Demo1 extends BaseTest1 {
	@Test
	public void test1()
	{
		String title = driver.getTitle();
		
		Reporter.log(title,true);
	}

	

}
