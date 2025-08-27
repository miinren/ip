package PeanutButter.Commands;

import PeanutButter.Exceptions.JuinException;
import PeanutButter.Tasks.Task;
import PeanutButter.Tasks.TaskList;
import PeanutButter.Ui.Ui;
import PeanutButter.Tasks.Todo;

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
