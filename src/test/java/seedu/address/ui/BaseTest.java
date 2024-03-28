package seedu.address.ui;

import org.junit.jupiter.api.BeforeAll;
import org.testfx.api.FxToolkit;

import javafx.application.Application;
import javafx.stage.Stage;

public class BaseTest {
    @BeforeAll
    public static void initToolkit() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(() -> new ApplicationStub());
    }

    private static class ApplicationStub extends Application {
        @Override
        public void start(Stage stage) {
            // Add any necessary initialization code here
        }
    }
}
