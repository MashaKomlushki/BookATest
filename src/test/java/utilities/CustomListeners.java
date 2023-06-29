package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import rs.booka.BaseTest;

public class CustomListeners extends BaseTest implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        Reporter.log("Capture screenshot");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        Reporter.log("Test passed");
    }
}
