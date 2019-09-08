package duke.task;

public abstract class Task {
    String description;
    boolean isDone;
    static final String TASK_NOT_DONE = "0";
    static final String TASK_DONE = "1";
    static final String DELIMITER = "|";
    public static final char SYMBOL = 'I'; // MUST BE OVERRIDDEN

    Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    private String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    /**
     * Gets string formatted to be saved.
     * @return String to be written into save file.
     */
    public abstract String getSaveString();

    public String getDescription() {
        return description;
    }
}