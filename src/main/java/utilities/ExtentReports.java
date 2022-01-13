package utilities;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports {
	
	static ExtentSparkReporter reporter;
	static com.aventstack.extentreports.ExtentReports report;
	static String reportPath=System.getProperty("user.dir")+"//reports//";
	
	public static com.aventstack.extentreports.ExtentReports htmlReport()
	{
		reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setDocumentTitle("Amazon Report");
		reporter.config().setReportName("Uday");
		report = new com.aventstack.extentreports.ExtentReports();
		report.attachReporter(reporter);
		return report;
	}

}
