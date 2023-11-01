package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;

/**
 * Clears the address book.
 */
public class ClearVenuesCommand extends Command {

    public static final String COMMAND_WORD = "clearVenues";
    public static final String MESSAGE_SUCCESS = "Venues in address book has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.resetVenues();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}