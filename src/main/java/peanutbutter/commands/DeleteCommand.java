package peanutbutter.commands;

import peanutbutter.exceptions.JuinException;
import peanutbutter.tasks.Task;
import peanutbutter.tasks.TaskList;
import peanutbutter.ui.Ui;

public class DeleteCommand extends Command {
    private final String args;

    public DeleteCommand(String args) {
        this.args = args;
    }

    @Override
    public boolean run(TaskList taskList, Ui ui) throws JuinException {
        if (args.isEmpty()) {
            throw new JuinException("   State an index to delete.");
        }

        try {
            int index = Integer.parseInt(args) - 1;
            Task removedTask = taskList.deleteTask(index);
            ui.deleteTaskMessage(taskList, removedTask);
        } catch (NumberFormatException e) {
            throw new JuinException("   Invalid task number!");
        }
        return false;
    }
}
