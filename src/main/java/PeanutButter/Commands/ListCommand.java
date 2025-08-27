package PeanutButter.Commands;

import PeanutButter.Exceptions.JuinException;
import PeanutButter.Tasks.TaskList;
import PeanutButter.Ui.Ui;

public class ListCommand extends Command {
    @Override
    public boolean run(TaskList taskList, Ui ui) throws JuinException {
        ui.showListMessage(taskList);
        return false;
    }
}
