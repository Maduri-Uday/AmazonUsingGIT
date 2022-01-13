package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage  {

	public WebDriver driver;
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement signon;
	
	@FindBy(linkText="Sign in")
	WebElement sigin;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchbox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchbutton;
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement userName;
	
	public WebElement signon()
	{
		return signon;
	}
	
	public void signin()
	{
		sigin.click();
	}
	
	public void searchbox(String productName)
	{
		searchbox.sendKeys(productName);
	}
	public void searchButton()
	{
		searchbutton.click();
	}
	
	public String userNameValidation()
	{
		return userName.getText();
	}
}
