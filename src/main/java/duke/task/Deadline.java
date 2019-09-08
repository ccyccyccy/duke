package duke.task;

import java.util.StringJoiner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    public static final char SYMBOL = 'D';
    private LocalDateTime by;
    private DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("d MMMM Y hh:mma");

    /**
     * Deadline Constructor.
     * @param description Description of deadline.
     * @param by Date string formatted in the form "d/M/yyyy HHmm".
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = LocalDateTime.parse(by, inputFormat);
    }

    @Override
    public String toString() {
        return "[" + SYMBOL + "]" + super.toString() + " (by: " + by.format(outputFormat) + ")";
    }

    /**
     * Used in saving of task data for storage.
     * @return Formatted string representation of deadline.
     */
    @Override
    public String getSaveString() {
        StringJoiner sj = new StringJoiner(DELIMITER);
        sj.add(SYMBOL + "");
        sj.add(isDone ? TASK_DONE : TASK_NOT_DONE);
        sj.add(description);
        sj.add(by.format(inputFormat));
        return sj.toString();
    }

    /**
     * Transform string representation of deadline back to object.
     * @param saveString String representation of deadline.
     * @return Deadline object constructed from saved data.
     */
    public static Deadline parseSaveString(String saveString) {
        String[] saveStringArr = saveString.split("\\" + DELIMITER);
        boolean isDone = saveStringArr[1].equals(TASK_DONE);
        String description = saveStringArr[2];
        String by = saveStringArr[3];
        Deadline deadline = new Deadline(description, by);
        if (isDone) {
            deadline.markAsDone();
        }
        return deadline;
    }
}