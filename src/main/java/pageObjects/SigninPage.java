package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
	
	public WebDriver driver;

	@FindBy(id="ap_email")
	WebElement emailbox;
	
	@FindBy(id="continue")
	WebElement continuebutton;
	
	@FindBy(id="ap_password")
	WebElement passwordbox;

	@FindBy(id="signInSubmit")
	WebElement SigninButton;

	public SigninPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void emailbox(String userName)
	{
		emailbox.sendKeys(userName);
	}
	
	public void continueButton()
	{
		continuebutton.click();
	}
	
	public void passwordBox(String password)
	{
		passwordbox.sendKeys(password);
	}
	
	public void SigninButton()
	{
		SigninButton.click();
	}

	
}
