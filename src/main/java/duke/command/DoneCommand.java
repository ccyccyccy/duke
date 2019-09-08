package duke.command;

import duke.DukeException;
import duke.task.Task;
import duke.TaskList;

public class DoneCommand extends Command {

    public static final String name = "done";

    public DoneCommand(String fullCommand) {
        super(fullCommand);
    }

    @Override
    public String execute(TaskList tasks) throws DukeException {
        Task taskToMarkAsDone;
        int selectedIndex;
        try {
            selectedIndex = Integer.parseInt(splitInput[1]) - 1;
        } catch (NumberFormatException e) {
            throw new DukeException("Argument passed to done must be a valid integer");
        }
        try {
            taskToMarkAsDone = tasks.getTaskAtIndex(selectedIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Selected task number does not exist.");
        }
        taskToMarkAsDone.markAsDone();
        String output = "Nice! I've marked this task as done: \n"
                + taskToMarkAsDone.toString();
        return output;
    }
}
