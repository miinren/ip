package peanutbutter.commands;

import peanutbutter.exceptions.JuinException;
import peanutbutter.tasks.Task;
import peanutbutter.tasks.TaskList;
import peanutbutter.tasks.Todo;
import peanutbutter.ui.Ui;

public class TodoCommand extends Command {
    private final String args;

    public TodoCommand(String args) {
        this.args = args;
    }

    @Override
    public boolean run(TaskList taskList, Ui ui) throws JuinException {
        if (args.isEmpty()) {
            throw new JuinException("   The description of todo cannot be empty!");
        }

        Task todo = new Todo(args);
        taskList.addTask(todo);
        ui.addTaskMessage(taskList, todo);

        return false;
    }
}
