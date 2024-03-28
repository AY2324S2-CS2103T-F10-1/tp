package seedu.address.ui;

import static java.util.Objects.requireNonNull;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;

/**
 * A UI component for displaying feedback messages.
 */
public class ResultDisplay extends UiPart<Region> {

    private static final String FXML = "ResultDisplay.fxml";

    @FXML
    private TextArea resultDisplayArea;

    public ResultDisplay() {
        super(FXML);
    }

    public TextArea getResultDisplayArea() {
        return resultDisplayArea;
    }

    public void setFeedbackToUser(String feedbackToUser) {
        requireNonNull(feedbackToUser);
        resultDisplayArea.setText(feedbackToUser);
    }
}
