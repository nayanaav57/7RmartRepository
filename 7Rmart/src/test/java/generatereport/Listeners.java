package generatereport;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtendReportUtility;

public class Listeners implements ITestListener {

	ExtentTest test; // Extent test is a class provided by avenstack dependency, test is a reference  variable
	ExtentReports extent = ExtendReportUtility.createExtentReports(); // calling create extent report method, extent is a reference variable,ExtentReports is the class provided by avenstack														
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result)// result is the object of interface ITestResult
	{

		ITestListener.super.onTestStart(result);// to call the method inside ITestListener interface
		test = extent.createTest(result.getMethod().getMethodName()); // get the method name and add with the report generated																
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {

		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed"); // adding status if test case is passed

	}

	public void onTestFailure(ITestResult result) {

		ITestListener.super.onTestFailure(result);
		extentTest.get().log(Status.FAIL, "Test Failed");// adding status if test case is failed
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		}

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
		}
	}

	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "Test Skipped");
		String testMethodName = result.getMethod().getMethodName();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)// to get graph will report is generated
	{

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) // to get graph will report is generated
	{

		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {

		ITestListener.super.onFinish(context);
		extent.flush(); // report is generated when this method is called
	}

}
