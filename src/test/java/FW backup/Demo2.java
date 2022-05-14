package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;

public class Demo2 extends BaseTest {

	@Test
	public void test1() {
		String title = driver.getTitle();
		Reporter.log(title,true);
	}
}
