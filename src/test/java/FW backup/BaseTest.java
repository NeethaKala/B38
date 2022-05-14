package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements IAutoConst {

	public WebDriver driver;
	public WebDriverWait wait;
	
	
	@BeforeMethod
	public void openApp() {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		String sITO = Utility.getProperty(CONFIG_PATH,"ITO");
		long ITO = Long.parseLong(sITO);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ITO));
		
		String sETO = Utility.getProperty(CONFIG_PATH,"ETO");
		long ETO = Long.parseLong(sETO);
		wait=new WebDriverWait(driver, Duration.ofSeconds(ETO));
		
		String APP_URL = Utility.getProperty(CONFIG_PATH,"APP_URL");
		driver.get(APP_URL);
	}
	
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
}
