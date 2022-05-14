package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest1 {
	public WebDriver driver;
@BeforeMethod
public void openApp()
{
WebDriverManager.chromedriver().setup();
 driver=new ChromeDriver();
driver.get("http://www.google.com");

}
@AfterMethod
public void closeApp()
{
	driver.close();
}
	
}
