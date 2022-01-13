package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot extends Base {

	public String takingScreenShot(String name,WebDriver driver) throws IOException
	{
		String screenShotPath=System.getProperty("user.dir")+"//reports//"+name+".jpg";
		TakesScreenshot ts=	(TakesScreenshot)driver;
		File fs=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fs, new File(screenShotPath));
		return screenShotPath;
	}
}
