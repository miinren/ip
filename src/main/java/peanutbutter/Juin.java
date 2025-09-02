package peanutbutter;

import peanutbutter.commands.Command;
import peanutbutter.exceptions.JuinException;
import peanutbutter.parser.Parser;
import peanutbutter.storage.Storage;
import peanutbutter.tasks.TaskList;
import peanutbutter.ui.Ui;

public class Juin {
    private static final String DATA_FOLDER = "data";
    private static final String DATA_FILE = "juin.txt";
    private TaskList taskList;
    private Storage storage;
    private Ui ui;
    private Parser parser;

    public Juin(String path) {
        this.storage = new Storage(path);
        this.taskList = new TaskList(storage.read());
        this.parser = new Parser();
        this.ui = new Ui();
    }

    public void run() {
        ui.welcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            String userInput = ui.readCommand();
            try {
                Command cmd = parser.parse(userInput);
                isExit = cmd.run(taskList, ui);
                storage.write(taskList);
            } catch (JuinException e) {
                ui.errorMessage(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String path = DATA_FOLDER + "/" + DATA_FILE;
        new Juin(path).run();
    }
}
