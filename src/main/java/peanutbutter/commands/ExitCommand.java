package peanutbutter.commands;

import peanutbutter.exceptions.JuinException;
import peanutbutter.tasks.TaskList;
import peanutbutter.ui.Ui;

/**
 * Represents a command to exit the application.
 */
public class ExitCommand extends Command {

    /**
     * Executes the ExitCommand.
     *
     * @param taskList the list of tasks
     * @param ui the user interface for displaying messages
     */
    @Override
    public boolean run(TaskList taskList, Ui ui) throws JuinException {
        ui.byeMessage();
        return true;
    }
}
