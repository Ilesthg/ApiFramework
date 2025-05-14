package utilities;

import com.aventstack.extentreports.ExtentTest;

public final class ThreadSafeExtLogger {

    private ThreadSafeExtLogger() {

    }

    private static final ThreadSafeExtLogger threadSafeExtLogger = new ThreadSafeExtLogger();

    public static ThreadSafeExtLogger getInstance() {
        return threadSafeExtLogger;
    }

    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

       ExtentTest getExtTest() { //remove public and create Manager
        return extentTestThreadLocal.get();
    }

    public void setExtTest(ExtentTest extTest) {//remove public and create Manager
        extentTestThreadLocal.set(extTest);
    }

    public void removeExtentObject() {
        extentTestThreadLocal.remove();
    }
}
