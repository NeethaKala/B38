package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements IAutoConst {

	public WebDriver driver;
	public WebDriverWait wait;
	
	@Parameters({"config"})
	@BeforeMethod(alwaysRun = true)
	public void openApp(String config) throws MalformedURLException {

		String browser=Utility.getProperty(config,"BROWSER");
		String grid=Utility.getProperty(config, "GRID");
		if(grid.equalsIgnoreCase("Yes"))
		{
			String remote = Utility.getProperty(config, "REMOTE_URL");
			URL url=new URL(remote);
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setBrowserName(browser);
			driver=new RemoteWebDriver(url,cap);
		}
		else
		{
			if(browser.equalsIgnoreCase("edge"))//switch case
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
		}
		
		
		driver.manage().window().maximize();
		
		String sITO = Utility.getProperty(config,"ITO");
		long ITO = Long.parseLong(sITO);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ITO));
		
		String sETO = Utility.getProperty(config,"ETO");
		long ETO = Long.parseLong(sETO);
		wait=new WebDriverWait(driver, Duration.ofSeconds(ETO));
		
		String APP_URL = Utility.getProperty(config,"APP_URL");
		driver.get(APP_URL);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeApp() {
		driver.quit();
	}
}
