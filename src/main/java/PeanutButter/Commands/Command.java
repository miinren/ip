package PeanutButter.Commands;

import PeanutButter.Exceptions.JuinException;
import PeanutButter.Ui.Ui;
import PeanutButter.Tasks.TaskList;


public abstract class Command {
    public abstract boolean run(TaskList taskList, Ui ui) throws JuinException;
}
