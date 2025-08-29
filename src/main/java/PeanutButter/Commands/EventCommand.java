package PeanutButter.Commands;

import PeanutButter.Exceptions.JuinException;
import PeanutButter.Juin;
import PeanutButter.Tasks.Event;
import PeanutButter.Tasks.Task;
import PeanutButter.Tasks.TaskList;
import PeanutButter.Ui.Ui;
import PeanutButter.Tasks.Deadline;

public class EventCommand extends Command {
    private final String args;

    public EventCommand(String args) {
        this.args = args;
    }

    @Override
    public boolean run(TaskList taskList, Ui ui) throws JuinException {
        if (args.isEmpty()) {
            throw new JuinException("   The description or time of event cannot be empty!");
        }

        if (!args.contains(" /from") || !args.contains(" /to")) {
            throw new JuinException("   Event requires /from and /to times!");
        }

        String[] parts = args.split(" /from | /to");
        if (parts.length < 3) {
            throw new JuinException("   Invalid event format!");
        }
        try {
            Task event = new Event(parts[0].trim(), parts[1].trim(), parts[2].trim());
            taskList.addTask(event);
            ui.addTaskMessage(taskList, event);
        } catch (IllegalArgumentException e) {
            throw new JuinException("   Invalid date/time format. Use yyyy-MM-dd or yyyy-MM-dd HHmm");
        }

        return false;
    }
}
