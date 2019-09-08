package duke;

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
        case "list":
            return new ListCommand(fullCommand);
        case "done":
            return new DoneCommand(fullCommand);
        case "delete":
            return new DeleteCommand(fullCommand);
        case "deadline":
            return new DeadlineCommand(fullCommand);
        case "event":
            return new EventCommand(fullCommand);
        case "todo":
            return new TodoCommand(fullCommand);
        case "find":
            return new FindCommand(fullCommand);
        default:
            return new ErrorCommand(fullCommand);
        }
    }
}
