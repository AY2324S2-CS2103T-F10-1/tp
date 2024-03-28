package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

public class ResultDisplayTest extends BaseTest {

    @Test
    public void setFeedbackToUser_success() {
        // Given
        String expectedFeedback = "This is a test feedback.";
        ResultDisplay resultDisplay = new ResultDisplay();

        // When
        resultDisplay.setFeedbackToUser(expectedFeedback);

        // Then
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ResultDisplay.fxml"));
        loader.setRoot(resultDisplay);
        loader.setController(resultDisplay);

        try {
            loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Region mainNode = loader.getRoot();
        assertEquals(expectedFeedback, resultDisplay.getResultDisplay().getText());
    }
}
