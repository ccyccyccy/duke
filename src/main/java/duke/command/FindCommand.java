package duke.command;

import duke.DukeException;
import duke.TaskList;

import java.util.StringJoiner;

public class FindCommand extends Command {

    public static final String name = "find";

    public FindCommand(String fullCommand) {
        super(fullCommand);
    }

    @Override
    public String execute(TaskList tasks) throws DukeException {
        String searchString;
        try {
            searchString = fullCommand.substring(5);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Find command needs an argument");
        }
        TaskList filteredTasks = tasks.search(searchString);

        StringJoiner sj = new StringJoiner("\n");
        sj.add("Here are the matching tasks in your list:");
        for (int i = 0; i < filteredTasks.getTasks().size(); i++) {
            sj.add((i + 1) + ". " + filteredTasks.getTasks().get(i));
        }
        return sj.toString();
    }
}
