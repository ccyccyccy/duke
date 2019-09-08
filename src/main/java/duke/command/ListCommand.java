package duke.command;

import duke.TaskList;

import java.util.StringJoiner;

public class ListCommand extends Command {

    public static final String name = "list";

    public ListCommand(String fullCommand) {
        super(fullCommand);
    }

    @Override
    public String execute(TaskList tasks) {
        StringJoiner sj = new StringJoiner("\n");
        for (int i = 0; i < tasks.getTasks().size(); i++) {
            sj.add((i + 1) + ". " + tasks.getTasks().get(i));
        }
        return sj.toString();
    }
}
