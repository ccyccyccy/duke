package duke.command;

import duke.DukeException;
import duke.TaskList;

public class ErrorCommand extends Command {

    public static final String name = "error";

    public ErrorCommand(String fullCommand) {
        super(fullCommand);
    }

    @Override
    public String execute(TaskList tasks) throws DukeException {
        String output = " ☹ OOPS!!! I'm sorry, but I don't know what that means :-(";
        return output;
    }
}
