package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_WARD;

import java.util.List;
import java.util.stream.Stream;

import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.ListKeywordsPredicate;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class ListCommandParser implements Parser<ListCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ListCommand
     * and returns a ListCommand object for execution.
     *
     * @param args the arguments to parse.
     * @return a ListCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ListCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();

        // If there are no arguments, list all patients
        if (trimmedArgs.isEmpty()) {
            return new ListCommand();
        }

        // If there are arguments, filter patients based on the arguments
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_TAG, PREFIX_WARD);
        if (!argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListCommand.MESSAGE_USAGE));
        }
        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_WARD);

        List<String> tagList = List.of();
        if (arePrefixesPresent(argMultimap, PREFIX_TAG)) {
            tagList = ParserUtil.parseTagsKeywords(argMultimap.getAllValues(PREFIX_TAG));
            assert !tagList.isEmpty() : "tagList should not be empty";
        }

        String ward = "";
        if (arePrefixesPresent(argMultimap, PREFIX_WARD)) {
            ward = ParserUtil.parseWard(argMultimap.getValue(PREFIX_WARD).orElse(null)).toString();
            assert !ward.isEmpty() : "ward should not be empty";
        }

        if (ward.isEmpty() && tagList.isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListCommand.MESSAGE_USAGE));
        }

        assert !tagList.isEmpty() || !ward.isEmpty() : "at least either tagList or ward must be supplied";

        return new ListCommand(new ListKeywordsPredicate(tagList, ward));
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     *
     * @param argumentMultimap the {@code ArgumentMultimap} to check for the presence of prefixes.
     * @param prefixes the prefixes to check for.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
