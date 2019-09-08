package duke;

import duke.command.Command;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Duke {
    private static TaskList tasks = new TaskList();
    private Storage storage;

    /**
     * Entry class to program.
     */
    public Duke() {
        System.out.println(System.getProperty("user.dir"));
        String filePath = "./data/duke.txt";
        Ui ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = storage.load();
        } catch (FileNotFoundException ignore) {
            // Make use of default created empty TaskList if no save file is found
            ui.showSaveFileNotFoundError();
        } catch (DukeException | IOException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Duke's logic entry point.
     */
    public String getResponse(String input) {
        String output = "";
        if (!input.equals("bye")) {
            try {
                Command c = Parser.parse(input);
                output = c.execute(tasks);
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
            try {
                storage.save(tasks);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return output;
    }
}
