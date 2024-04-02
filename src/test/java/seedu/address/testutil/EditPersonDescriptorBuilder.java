package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.person.AdmissionDate;
import seedu.address.model.person.Dob;
import seedu.address.model.person.Ic;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Remark;
import seedu.address.model.person.Ward;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditPersonDescriptorBuilder {

    private EditPersonDescriptor descriptor;

    public EditPersonDescriptorBuilder() {
        descriptor = new EditPersonDescriptor();
    }

    public EditPersonDescriptorBuilder(EditPersonDescriptor descriptor) {
        this.descriptor = new EditPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditPersonDescriptorBuilder(Person person) {
        descriptor = new EditPersonDescriptor();
        descriptor.setName(person.getName());
        descriptor.setTags(person.getTags());
        descriptor.setDob(person.getDob());
        descriptor.setIc(person.getIc());
        descriptor.setAdmissionDate(person.getAdmissionDate());
        descriptor.setWard(person.getWard());
        descriptor.setRemark(person.getRemark());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Ic} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withIc(String ic) {
        descriptor.setIc(new Ic(ic));
        return this;
    }

    /**
     * Sets the {@code Ward} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withWard(String ward) {
        descriptor.setWard(new Ward(ward));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }
    /**
     * Sets the {@code Dob} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withDob(String dob) {
        descriptor.setDob(new Dob(dob));
        return this;
    }
    /**
     * Sets the {@code AdmissionDate} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withAdmissionDate(String admissionDate) {
        descriptor.setAdmissionDate(new AdmissionDate(admissionDate));
        return this;
    }

    /**
     * Sets the {@code remark} of the {@code EditPersonDescriptorBuilder} that we are building.
     */
    public EditPersonDescriptorBuilder withRemark(String remark) {
        descriptor.setRemark((new Remark(remark)));
        return this;
    }

    public EditPersonDescriptor build() {
        return descriptor;
    }
}
