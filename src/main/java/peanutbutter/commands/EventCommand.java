package peanutbutter.commands;

import peanutbutter.exceptions.JuinException;
import peanutbutter.tasks.Event;
import peanutbutter.tasks.Task;
import peanutbutter.tasks.TaskList;
import peanutbutter.ui.Ui;

/**
 * Represents a command to create and add an Event task.
 */
public class EventCommand extends Command {
    private final String args;

    /**
     * Creates a new EventCommand with the given arguments.
     *
     * @param args the arguments containing description, start, and end times
     */
    public EventCommand(String args) {
        this.args = args;
    }

    /**
     * Executes the EventCommand.
     *
     * @param taskList the list of tasks to add the event into
     * @param ui the user interface for displaying messages
     * @throws JuinException if the arguments are invalid or the event cannot be created
     */
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
