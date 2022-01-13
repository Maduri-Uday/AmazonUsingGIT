package utilities;

import java.io.FileInputStream;
import java.time.Duration;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Base {
	
	public WebDriver driver;
	public Properties p;

	public WebDriver driverInitilization() throws IOException
	{
		
		String chromeDriverPath = System.getProperty("user.dir")+"//src//main//java//drivers//chromedriver.exe";
		String edgeDriverPath = System.getProperty("user.dir")+"//src//main//java//drivers//msedgedriver.exe";
		String firefoxDriverPath = System.getProperty("user.dir")+"//src//main//java//drivers//geckodriver.exe";
		String propFilePath = System.getProperty("user.dir")+"//src//main//java//utilities//Config.properties";
		FileInputStream fs = new FileInputStream(propFilePath);
		p = new Properties();
		p.load(fs);
		String browserName=	p.getProperty("Browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",chromeDriverPath);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver",edgeDriverPath);
			driver=new EdgeDriver();
			driver.manage().window().maximize();			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",edgeDriverPath);
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			
		}
		
		return driver;
		
		
	}
	
	public void implict()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void scroll(int a,int b)
	{
		JavascriptExecutor js=  (JavascriptExecutor)driver;
		js.executeScript("window.scroll("+a+","+b+")");
	}
}
