package peanutbutter.commands;

import peanutbutter.exceptions.JuinException;
import peanutbutter.tasks.Deadline;
import peanutbutter.tasks.Task;
import peanutbutter.tasks.TaskList;
import peanutbutter.ui.Ui;

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
            throw new JuinException("   Deadline must have a /by date!");
        }

        String[] parts = args.split(" /by", 2);
        if (parts[0].isBlank() || parts[1].isBlank() || parts.length < 2) {
            throw new JuinException("   Deadline requires a description and /by date!");
        }
        try {
            Task deadline = new Deadline(parts[0].trim(), parts[1].trim());
            taskList.addTask(deadline);
            ui.addTaskMessage(taskList, deadline);
        } catch (IllegalArgumentException e) {
            throw new JuinException("   Invalid date/time format. Use yyyy-MM-dd or yyyy-MM-dd HHmm");
        }
        return false;
    }
}
