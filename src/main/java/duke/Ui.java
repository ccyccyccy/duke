package duke;

import duke.task.Task;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Ui {
    private final String indent = "    ";
    private Scanner sc = new Scanner(System.in);

    /**
     * Prints welcome message.
     */
    public void showWelcome() {
        String intro = "Hello! I'm Duke\n"
                + "What can I do for you?";
        System.out.println(indent(wrapWithHorizontalLines(intro)));
    }

    /**
     * Prints goodbye message.
     */
    public void showBye() {
        String endMessage = "Bye. Hope to see you again soon!";
        System.out.println(indent(wrapWithHorizontalLines(endMessage)));
    }

    /**
     * Prints list of tasks.
     * @param taskList List of tasks.
     */
    public void showTasks(TaskList taskList) {
        StringJoiner sj = new StringJoiner("\n");
        for (int i = 0; i < taskList.getTasks().size(); i++) {
            sj.add((i + 1) + ". " + taskList.getTasks().get(i));
        }
        System.out.println(indent(wrapWithHorizontalLines(sj.toString())));
    }

    /**
     * Prints message after markAsDone command executed.
     * @param task Task marked as done.
     */
    public void showMarkAsDone(Task task) {
        String output = "Nice! I've marked this task as done: \n"
                + indent(task.toString());
        System.out.println(indent(wrapWithHorizontalLines(output)));
    }

    /**
     * Reads input.
     * @return Input string.
     */
    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Wraps text with horizontal lines.
     * @param str String to be wrapped.
     * @return Wrapped string.
     */
    public String wrapWithHorizontalLines(String str) {
        return "____________________________________________________________\n"
                + str
                + "\n" + "____________________________________________________________";
    }

    /**
     * Prints message after add task command executed.
     * @param task Task added.
     * @param numberOfTasksLeft Number of tasks left.
     */
    public void showAddTask(Task task, int numberOfTasksLeft) {
        String output = "Got it. I've added this task: \n"
                + indent(task.toString())
                + String.format("\nNow you have %d tasks in the list.", numberOfTasksLeft);
        System.out.println(indent(wrapWithHorizontalLines(output)));
    }

    /**
     * Prints message after delete task command executed.
     * @param task Task deleted.
     * @param numberOfTasksLeft Number of tasks left.
     */
    public void showDeleteTask(Task task, int numberOfTasksLeft) {
        String output = "Noted. I've removed this task: \n"
                + indent(task.toString())
                + String.format("\nNow you have %d tasks in the list.", numberOfTasksLeft);
        System.out.println(indent(wrapWithHorizontalLines(output)));
    }

    /**
     * Prints message for find result command.
     * @param tasks Filtered tasks from search.
     */
    public void showFindResult(TaskList tasks) {
        StringJoiner sj = new StringJoiner("\n");
        sj.add("Here are the matching tasks in your list:");
        for (int i = 0; i < tasks.getTasks().size(); i++) {
            sj.add((i + 1) + ". " + tasks.getTasks().get(i));
        }
        System.out.println(indent(wrapWithHorizontalLines(sj.toString())));
    }

    /**
     * Prints message after error command executed.
     */
    public void showGenericError() {
        String output = " ☹ OOPS!!! I'm sorry, but I don't know what that means :-(";
        System.out.println(indent(wrapWithHorizontalLines(output)));
    }

    /**
     * Prints message if no save file is detected.
     */
    public void showSaveFileNotFoundError() {
        String output = "Save file not found. Creating new save file...";
        System.out.println(indent(wrapWithHorizontalLines(output)));
    }

    /**
     * Indents given string block.
     * @param str String block to be indented.
     * @return Intended string block.
     */
    public String indent(String str) {
        String[] indentedStrings = Arrays.stream(str.split("\n")).map(s -> indent + s).toArray(String[]::new);
        return String.join("\n", indentedStrings);
    }
}
