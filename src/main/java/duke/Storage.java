package duke;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public final class Storage {
    String filePath;

    Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Save data to filePath specified.
     * @param taskList Tasks to be saved.
     * @throws IOException When cannot save task data.
     */
    public void save(TaskList taskList) throws IOException {
        String directoryName = new File(filePath).getParent();
        File directory = new File(directoryName);
        directory.mkdir();
        FileWriter writer = new FileWriter(filePath);
        StringJoiner sj = new StringJoiner("\n");
        for (Task task : taskList.getTasks()) {
            sj.add(task.getSaveString());
        }
        writer.write(sj.toString());
        writer.close();
    }

    /**
     * Load data from filePath specified.
     * @return TaskList as loaded from file.
     * @throws DukeException When file format is wrong.
     * @throws IOException When unable to read file.
     */
    public TaskList load() throws DukeException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<Task> tasks = new ArrayList<>();
        String line = null;
        while ((line = reader.readLine()) != null) {
            switch (line.charAt(0)) {
            case 'T':
                Todo todo = Todo.parseSaveString(line);
                tasks.add(todo);
                break;
            case 'D':
                Deadline deadline = Deadline.parseSaveString(line);
                tasks.add(deadline);
                break;
            case 'E':
                Event event = Event.parseSaveString(line);
                tasks.add(event);
                break;
            default:
                throw new DukeException("Unknown save file format");
            }
        }
        return new TaskList(tasks);
    }
}
