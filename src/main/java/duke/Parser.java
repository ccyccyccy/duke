package duke;

import duke.command.Command;
import duke.command.DeadlineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.ErrorCommand;
import duke.command.EventCommand;
import duke.command.FindCommand;
import duke.command.ListCommand;
import duke.command.TodoCommand;

public class Parser {

    /**
     * Returns specific Command from given user input.
     * @param fullCommand User input string.
     * @return Command to be executed.
     */
    public static Command parse(String fullCommand) {
        String[] splitInput = fullCommand.split(" ");
        String command = splitInput[0];
        switch (command) {
        case ListCommand.name:
            return new ListCommand(fullCommand);
        case DoneCommand.name:
            return new DoneCommand(fullCommand);
        case DeleteCommand.name:
            return new DeleteCommand(fullCommand);
        case DeadlineCommand.name:
            return new DeadlineCommand(fullCommand);
        case EventCommand.name:
            return new EventCommand(fullCommand);
        case TodoCommand.name:
            return new TodoCommand(fullCommand);
        case FindCommand.name:
            return new FindCommand(fullCommand);
        default:
            return new ErrorCommand(fullCommand);
        }
    }
}
