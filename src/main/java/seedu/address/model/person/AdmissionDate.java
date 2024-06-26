package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;

import seedu.address.commons.util.DateUtil;

/**
 * Represents a patient's admission date in the address book.
 */
public class AdmissionDate extends DateUtil {
    public static final String DATE_TYPE = "Admission date";
    public static final String MESSAGE_CONSTRAINTS_FORMAT = String
            .format(DateUtil.MESSAGE_CONSTRAINTS_FORMAT, DATE_TYPE);
    public static final String MESSAGE_CONSTRAINTS_OCCURRENCE = String
            .format("%1$s should not be earlier than date of birth or later than current date", DATE_TYPE);

    private final LocalDate admissionDate;
    private final String value;

    /**
     * Constructs a {@code AdmissionDate}.
     *
     * @param value A valid admission date.
     */
    public AdmissionDate(String value) {
        requireNonNull(value);
        checkArgument(isValidDate(value), MESSAGE_CONSTRAINTS_FORMAT);
        checkArgument(!isFutureDate(value), MESSAGE_CONSTRAINTS_OCCURRENCE);
        this.admissionDate = LocalDate.parse(value, getFormatter());
        this.value = value;
    }

    /**
     * Returns the date of birth
     */
    public LocalDate getDate() {
        return admissionDate;
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
        if (!(other instanceof AdmissionDate)) {
            return false;
        }

        AdmissionDate otherAdmissionDate = (AdmissionDate) other;
        return admissionDate.equals(otherAdmissionDate.admissionDate);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
