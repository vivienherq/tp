package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.model.Model;

/**
 * Clears the address book.
 */
public class ClearGuestsCommand extends Command {

    public static final String COMMAND_WORD = "clearGuests";
    public static final String MESSAGE_SUCCESS = "Guests in address book has been cleared!";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.resetGuests();
        model.resetRsvps();
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
