import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import proj.DriverManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AllureExtension implements TestWatcher, AfterAllCallback {
    private List<TestResultStatus> testResultStatus = new ArrayList<>();

    @Attachment (type = "image/png", value = "Screenshot")
    public static byte [] takeScreenshot() {
        return ((TakesScreenshot) DriverManager.getWebdriver()).getScreenshotAs(OutputType.BYTES);
    }
    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {

    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testFailed(context, cause);
        takeScreenshot();
        testResultStatus.add(TestResultStatus.FAILED);
    }

    private enum TestResultStatus {
        SUCCESSFUL, ABORTED , FAILED , DISABLED
    }
}


