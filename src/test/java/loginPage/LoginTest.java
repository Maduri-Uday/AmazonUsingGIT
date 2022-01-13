package loginPage;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.ProductPage;
import pageObjects.SigninPage;
import utilities.Base;

public class LoginTest extends Base {
	
	
	public WebDriver driver;
	Homepage hp;
	SigninPage sp;
	ProductPage pp;
	
	@BeforeTest
	public void i() throws IOException
	{
		driver=driverInitilization();
		driver.get(p.getProperty("URL"));
		//Implicit();
	}
	
	@Test
	public void login()
	{
		
		hp=new Homepage(driver);
		Actions a = new Actions(driver);
		a.moveToElement(hp.signon());
		hp.signin();
		sp=new SigninPage(driver);
		sp.emailbox(p.getProperty("Username"));
		sp.continueButton();
		sp.passwordBox(p.getProperty("Password"));
		sp.SigninButton();
		Assert.assertEquals(hp.userNameValidation(),"Hello, uday");
	}

	@Test (dependsOnMethods= {"login"})
	public void buyingOneplus() throws InterruptedException
	{
		
		hp.searchbox("OnePlus");
		hp.searchButton();
		scroll(0,500);
		pp=new ProductPage(driver);
		pp.oneplus();
		scroll(0,500);
		pp.size();
		pp.product();
		//Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(),"Hello, uday");
		
	}
	
	@AfterTest
	public void close()
	{
		driver.quit();
	}
}
