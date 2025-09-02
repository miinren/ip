package peanutbutter.commands;

import peanutbutter.exceptions.JuinException;
import peanutbutter.tasks.TaskList;
import peanutbutter.ui.Ui;

public class ExitCommand extends Command {
    @Override
    public boolean run(TaskList taskList, Ui ui) throws JuinException {
        ui.byeMessage();
        return true;
    }
}
