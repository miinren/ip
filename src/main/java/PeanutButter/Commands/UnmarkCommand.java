package PeanutButter.Commands;

import PeanutButter.Exceptions.JuinException;
import PeanutButter.Tasks.TaskList;
import PeanutButter.Ui.Ui;

public class UnmarkCommand extends Command {
    private final String args;

    public UnmarkCommand(String args) {
        this.args = args;
    }

    @Override
    public boolean run(TaskList taskList, Ui ui) throws JuinException {
        if (args.isEmpty()) {
            throw new JuinException("   State an index to mark.");
        }

        try {
            int index = Integer.parseInt(args) - 1;
            taskList.unmarkTaskDone(index);
            ui.unmarkTaskMessage(taskList.get(index));
        } catch (NumberFormatException e) {
            throw new JuinException("   Invalid task number!");
        }

        return false;
    }
}
