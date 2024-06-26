package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a patient's IC in the address book.
 */
public class Ic {
    public static final String MESSAGE_CONSTRAINTS =
            "ICs starts with a capital letter, followed by a 7 digit number and ends with a capital letter. "
            + "It should not be blank.";

    // Singapore regex for ic
    private static final String VALIDATION_REGEX = "^[A-Z]\\d{7}[A-Z]$";

    private final String value;

    /**
     * Constructs a {@code Ic}.
     *
     * @param value A valid IC.
     */
    public Ic(String value) {
        requireNonNull(value);
        checkArgument(isValidIc(value), MESSAGE_CONSTRAINTS);
        this.value = value;
    }

    /**
     * Returns true if a given string is a valid IC.
     */
    public static boolean isValidIc(String ic) {
        return ic.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Ic)) {
            return false;
        }

        Ic otherIc = (Ic) other;
        return value.equals(otherIc.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
