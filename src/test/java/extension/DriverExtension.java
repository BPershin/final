package extension;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static proj.DriverManager.closeDriver;
import static proj.DriverManager.getWebdriver;

public class DriverExtension implements BeforeAllCallback, AfterAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        getWebdriver();
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
         closeDriver();
    }
}
