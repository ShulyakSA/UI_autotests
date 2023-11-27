package helpers;

import config.TestConfigFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer, ITestNGListener {
    protected static TestConfigFactory config = TestConfigFactory.getInstance();
    private int count = 0;
    private static int maxTry = config.getWebConfig().getRetryCount();

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < maxTry) {
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
