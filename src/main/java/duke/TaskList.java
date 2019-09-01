package duke;

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
     * @param index Duke.Duke.Task index to be deleted, zero-indexed.
     */
    public void deleteTaskAt(int index) {
        this.tasks.remove(index);
    }

    /**
     * Add task.
     * @param task Duke.Duke.Task to be added.
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public TaskList search(String str) {
        return new TaskList(this.tasks.stream().filter(t -> t.description.contains(str)).collect(Collectors.toList()));
    }
}
