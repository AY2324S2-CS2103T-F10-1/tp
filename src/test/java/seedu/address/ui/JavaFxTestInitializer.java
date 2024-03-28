package seedu.address.ui;

import org.junit.jupiter.api.BeforeAll;
import org.testfx.api.FxToolkit;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Utility class for initializing the JavaFX toolkit before running tests.
 */
public class JavaFxTestInitializer {

    /**
     * Initializes the JavaFX toolkit before running tests.
     * This method should be called before any JavaFX components are created or tested.
     *
     * @throws Exception If an error occurs during the initialization.
     */
    @BeforeAll
    public static void initToolkit() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(() -> new ApplicationStub());
    }

    private static class ApplicationStub extends Application {
        @Override
        public void start(Stage stage) {
            // No initialization code needed
        }
    }
}
