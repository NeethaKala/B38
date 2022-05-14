package script;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Demo4_day39 {

	@Test
	public void test_report() {
		//create extent report
		ExtentReports report=new ExtentReports();
		//Create report type and attach it
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
		report.attachReporter(spark);
		//create a test
		ExtentTest test = report.createTest("MyTest1");
		test.info("this is info");
		test.pass("this is pass");
		test.log(Status.PASS, "This is also pass");
		
		ExtentTest test2 = report.createTest("MyTest2");
		test2.warning("this is warning");
		test2.fail("this is fail");
		
		//publish the report
		report.flush();
		
		
	}
}
