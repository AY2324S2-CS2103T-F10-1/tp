package seedu.address.ui;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.Logic;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Person;

public class MainWindowTest extends BaseTest {

    @Test
    public void handleHelp_success() {
        // Setup
        Stage stage = new Stage();
        Logic logic = new DummyLogic();
        TestableMainWindow mainWindow = new TestableMainWindow(stage, logic);
        ResultDisplay resultDisplay = mock(ResultDisplay.class);
        mainWindow.setResultDisplay(resultDisplay);

        // Call the handleHelp() method
        mainWindow.handleHelp();

        // Verify that the correct feedback is set in the ResultDisplay
        String expectedFeedback = HelpCommand.SHOWING_HELP_MESSAGE;
        verify(resultDisplay).setFeedbackToUser(expectedFeedback);
    }

    /**
     * A subclass of MainWindow for testing purposes.
     */
    private static class TestableMainWindow extends MainWindow {
        private ResultDisplay resultDisplay;

        public TestableMainWindow(Stage primaryStage, Logic logic) {
            super(primaryStage, logic);
        }

        public void setResultDisplay(ResultDisplay resultDisplay) {
            this.resultDisplay = resultDisplay;
        }

        public ResultDisplay getResultDisplay() {
            return resultDisplay;
        }
    }

    /**
     * A dummy implementation of the Logic interface for testing purposes.
     */
    private static class DummyLogic implements Logic {
        private final ReadOnlyAddressBook addressBook;
        private final GuiSettings guiSettings;

        public DummyLogic() {
            addressBook = new AddressBook();
            guiSettings = new GuiSettings(0, 0, 0, 0);
        }

        @Override
        public CommandResult execute(String commandText) {
            return new CommandResult("Dummy command executed");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return addressBook;
        }

        @Override
        public ObservableList<Person> getFilteredPersonList() {
            return FXCollections.observableArrayList(addressBook.getPersonList());
        }

        @Override
        public Path getAddressBookFilePath() {
            return null; // or return a dummy file path if needed
        }

        @Override
        public GuiSettings getGuiSettings() {
            return guiSettings;
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            // Do nothing
        }
    }
}
