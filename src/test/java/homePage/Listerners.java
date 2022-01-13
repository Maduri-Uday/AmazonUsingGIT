package homePage;



import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.*;
import utilities.Screenshot;



public class Listerners extends Base implements ITestListener {

	ExtentTest test;
	com.aventstack.extentreports.ExtentReports rep=	utilities.ExtentReports.htmlReport();
	ThreadLocal<ExtentTest> local= new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart(ITestResult result) {
	test=rep.createTest(result.getMethod().getMethodName());
	local.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		local.get().log(Status.PASS,"Test is passed");
		
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		String name=result.getMethod().getMethodName();
		local.get().fail(result.getThrowable());
		
		try {
		driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
		}
		Screenshot s= new Screenshot();
		try {
			local.get().addScreenCaptureFromPath(s.takingScreenShot(name,driver), name);
			
		} catch(Exception e) {
			
		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		
		rep.flush();

	}

}
