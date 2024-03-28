package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ResultDisplayTest {

    private static ResultDisplay resultDisplay;

    @BeforeAll
    public static void setUp() throws Exception {
        JavaFxTestInitializer.initToolkit();
        resultDisplay = new ResultDisplay();
    }

    @Test
    public void setFeedbackToUser_success() {
        // Given
        String expectedFeedback = "This is a test feedback.";

        // When
        resultDisplay.setFeedbackToUser(expectedFeedback);

        // Then
        assertEquals(expectedFeedback, resultDisplay.getResultDisplayArea().getText());
    }
}
