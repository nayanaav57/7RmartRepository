package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {

	public static final ExtentReports extentReports = new ExtentReports();// created a object for extent report class

	public synchronized static ExtentReports createExtentReports()// created a method named create extent reports
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");// created an object for extent spark report class and path of generated report is provided																								
		reporter.config().setReportName("7RMart  Project");
		extentReports.attachReporter(reporter);// passing path
		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", "AA");// giving team members name
		return extentReports;// since method will return the generated report, 'Extent reports' is mentioned in the method declaration stage
								
	}

}
