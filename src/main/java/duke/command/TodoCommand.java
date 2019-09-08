package duke.command;

import duke.DukeException;
import duke.TaskList;
import duke.task.Todo;

public class TodoCommand extends Command {

    public static final String name = "todo";

    public TodoCommand(String fullCommand) {
        super(fullCommand);
    }

    @Override
    public String execute(TaskList tasks) throws DukeException {
        String todoDescription;
        try {
            todoDescription = fullCommand.substring(5);
        } catch (StringIndexOutOfBoundsException e) {
            throw new DukeException(" ☹ OOPS!!! The description of a todo cannot be empty.");
        }
        Todo todo = new Todo(todoDescription);
        tasks.addTask(todo);
        String output = "Got it. I've added this task: \n"
                + todo.toString()
                + String.format("\nNow you have %d tasks in the list.", tasks.getNumberOfTasks());
        return output;
    }
}
