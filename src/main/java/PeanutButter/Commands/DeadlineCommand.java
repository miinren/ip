package PeanutButter.Commands;

import PeanutButter.Exceptions.JuinException;
import PeanutButter.Tasks.Task;
import PeanutButter.Tasks.TaskList;
import PeanutButter.Ui.Ui;
import PeanutButter.Tasks.Deadline;

public class DeadlineCommand extends Command {
    private final String args;

    public DeadlineCommand(String args) {
        this.args = args;
    }

    @Override
    public boolean run(TaskList taskList, Ui ui) throws JuinException {
        if (args.isEmpty()) {
            throw new JuinException("   The description or time of deadline cannot be empty!");
        }

        if (!args.contains(" /by ")) {
            throw new JuinException("Deadline must have a /by date!");
        }

        String[] parts = args.split(" /by", 2);
        if (parts[0].isBlank() || parts[1].isBlank() || parts.length < 2) {
            throw new JuinException("   Deadline requires a description and /by date!");
        }

        Task deadline = new Deadline(parts[0].trim(), parts[1].trim());
        taskList.addTask(deadline);
        ui.addTaskMessage(taskList, deadline);

        return false;
    }
}
