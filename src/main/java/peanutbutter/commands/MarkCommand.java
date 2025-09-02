package peanutbutter.commands;

import peanutbutter.exceptions.JuinException;
import peanutbutter.tasks.TaskList;
import peanutbutter.ui.Ui;

public class MarkCommand extends Command {
    private final String args;

    public MarkCommand(String args) {
        this.args = args;
    }

    @Override
    public boolean run(TaskList taskList, Ui ui) throws JuinException {
        if (args.isEmpty()) {
            throw new JuinException("   State an index to mark.");
        }

        try {
            int index = Integer.parseInt(args) - 1;
            taskList.markTaskDone(index);
            ui.markTaskMessage(taskList.get(index));
        } catch (NumberFormatException e) {
            throw new JuinException("   Invalid task number!");
        }

        return false;
    }
}
