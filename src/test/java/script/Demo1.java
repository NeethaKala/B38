package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;

public class Demo1 extends BaseTest {

	@Test(priority = 1,groups= {"smoke"})
	public void test1() {
		String title = driver.getTitle();
		Reporter.log(title,true);
	}
}
