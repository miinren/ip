package PeanutButter.Commands;

import PeanutButter.Exceptions.JuinException;
import PeanutButter.Tasks.TaskList;
import PeanutButter.Ui.Ui;

public class ExitCommand extends Command {
    @Override
    public boolean run(TaskList taskList, Ui ui) throws JuinException {
        ui.byeMessage();
        return true;
    }
}
