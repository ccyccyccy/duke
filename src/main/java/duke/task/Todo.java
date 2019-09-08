package duke.task;

import java.util.StringJoiner;

public class Todo extends Task {

    public static final char SYMBOL = 'T';

    /**
     * Todo Constructor.
     * @param description Description of todo.
     */
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[" + SYMBOL + "]" + super.toString();
    }

    @Override
    public String getSaveString() {
        StringJoiner sj = new StringJoiner(DELIMITER);
        sj.add(SYMBOL + "");
        sj.add(isDone ? TASK_DONE : TASK_NOT_DONE);
        sj.add(description);
        return sj.toString();
    }

    /**
     * Transform string representation of todo back to object.
     * @param saveString String representation of todo.
     * @return Todo object constructed from saved data.
     */
    public static Todo parseSaveString(String saveString) {
        String[] saveStringArr = saveString.split("\\" + DELIMITER);
        boolean isDone = saveStringArr[1].equals(TASK_DONE);
        String description = saveStringArr[2];
        Todo todo = new Todo(description);
        if (isDone) {
            todo.markAsDone();
        }
        return todo;
    }
}