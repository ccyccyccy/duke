import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    private static TaskList tasks = new TaskList();
    private Ui ui;
    private Storage storage;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = storage.load();
        } catch (FileNotFoundException ignore) {
        } catch (DukeException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        Ui ui = new Ui();
        ui.showWelcome();

        String input;
        while (!(input = ui.readCommand()).equals("bye")) {
            try {
                Command c = Parser.parse(input);
                c.execute(tasks, ui, storage);
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
            try {
                storage.save(tasks);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ui.showBye();
    }

    public static void main(String[] args) {
        new Duke("/home/yuan/cs2103t/duke/data/duke.txt").run();
    }
}
