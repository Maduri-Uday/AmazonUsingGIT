package windowHandles;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.Base;

public class WindowHandles extends Base{
	
	public WebDriver driver;
	
	@BeforeTest
	public void init() throws IOException
		{
		driver=driverInitilization();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		}
	
	@Test
	public void handles() throws InterruptedException
	{
		
		WebElement link=driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]"));
		List<WebElement> links= link.findElements(By.tagName("a"));
		
		for(int i=0;i<links.size();i++)
		{
			System.out.println(links.get(i).getAttribute("href"));
			Thread.sleep(2000);
		//	link.sendKeys(Keys.CONTROL);
		String control=	Keys.chord(Keys.CONTROL,Keys.ENTER);
			//links.get(i).sendKeys(control);
			links.get(i).sendKeys(Keys.CONTROL,Keys.ENTER);
			
		}
		Set<String> handles=driver.getWindowHandles();
			Iterator<String> it=handles.iterator();
		
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				if(driver.getTitle().equalsIgnoreCase("REST API Tutorial"))
				{
					driver.findElement(By.linkText("What Is REST?")).click();
					break;
				}
				
				
			}
	}
	
}
