package duke;

import duke.task.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {
    private List<Task> tasks;

    TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    TaskList() {
        this.tasks = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Task getTaskAtIndex(int index) {
        return tasks.get(index);
    }

    /**
     * Returns number of tasks.
     * @return Number of tasks.
     */
    public int getNumberOfTasks() {
        return this.tasks.size();
    }

    /**
     * Delete task at index.
     * @param index Task index to be deleted, zero-indexed.
     */
    public void deleteTaskAt(int index) {
        this.tasks.remove(index);
    }

    /**
     * Add task.
     * @param task Task to be added.
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * Returns list of tasks that fulfill search string.
     * @param str Search string.
     * @return TaskList containing tasks that contains search string.
     */
    public TaskList search(String str) {
        return new TaskList(this.tasks.stream()
                .filter(t -> t.getDescription().contains(str))
                .collect(Collectors.toList()));
    }
}
