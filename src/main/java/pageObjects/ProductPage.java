package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText="OnePlus")
	WebElement onePlus;
	
	@FindBy(linkText="256 GB & above")
	WebElement size;

	@FindBy(partialLinkText="Winter Mist")
	WebElement product;
	
	
	public void oneplus()
	{
		onePlus.click();
	}
	public void size()
	{
		size.click();
	}
	public void product()
	{
		product.click();
	}
}
