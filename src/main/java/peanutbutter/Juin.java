package peanutbutter;

import peanutbutter.commands.Command;
import peanutbutter.exceptions.JuinException;
import peanutbutter.parser.Parser;
import peanutbutter.storage.Storage;
import peanutbutter.tasks.TaskList;
import peanutbutter.ui.Ui;

public class Juin {
    private TaskList taskList;
    private Storage storage;
    private Ui ui;
    private Parser parser;
    private String commandType;

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
                commandType = cmd.getClass().getSimpleName();
                isExit = cmd.run(taskList, ui);
                storage.write(taskList);
            } catch (JuinException e) {
                commandType = "Error";
                ui.errorMessage(e.getMessage());
            }
        }
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        try {
            Command cmd = Parser.parse(input);
            commandType = cmd.getClass().getSimpleName();
            cmd.run(taskList, ui);
            commandType = cmd.getClass().getSimpleName();
            return ui.getLastMessage();
        } catch (JuinException e) {
            return "Error: " + e.getMessage();
        }
    }
    public String getCommandType() {
        return commandType;
    }
}
