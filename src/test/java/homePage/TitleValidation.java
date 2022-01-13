package homePage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.Base;

public class TitleValidation extends Base {
	
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(TitleValidation.class.getName());
	
	@BeforeTest
	public void open() throws IOException
	{
		driver=driverInitilization();
		driver.get(p.getProperty("URL"));
		log.info("opening the URL");
	}
	
	@Test
	public void validatingTitle()
	{
		Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		log.info("Validating the Title");
		
	}
	

	@AfterTest
	public void close()
	{
		driver.close();
	}

}
