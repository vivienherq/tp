package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.event.Event;

/**
 * Adds a person to the address book.
 */
public class CreateEventCommand extends Command {

    public static final String COMMAND_WORD = "event";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an event to EventWise. "
            + "Parameters: "
            + PREFIX_EVENT_NAME + "NAME "
            + PREFIX_EVENT_DESC + "DESCRIPTION "
            + PREFIX_EVENT_DATE + "DATE "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_EVENT_NAME + "FSC 2023 "
            + PREFIX_EVENT_DESC + "Freshman Social Camp 2023 "
            + PREFIX_EVENT_DATE + "01-01-2000";

    public static final String MESSAGE_SUCCESS = "New Event added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This event already exists in EventWise";

    private final Event toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public CreateEventCommand(Event event) {
        requireNonNull(event);
        toAdd = event;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasEvent(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.hasEvent(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

//    @Override
//    public boolean equals(Object other) {
//        if (other == this) {
//            return true;
//        }
//
//        // instanceof handles nulls
//        if (!(other instanceof AddCommand)) {
//            return false;
//        }
//
//        AddCommand otherAddCommand = (AddCommand) other;
//        return toAdd.equals(otherAddCommand.toAdd);
//    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this)
//                .add("toAdd", toAdd)
//                .toString();
//    }
}