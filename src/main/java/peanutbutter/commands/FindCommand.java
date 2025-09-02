package peanutbutter.commands;

import java.util.ArrayList;

import peanutbutter.exceptions.JuinException;
import peanutbutter.tasks.Task;
import peanutbutter.tasks.TaskList;
import peanutbutter.ui.Ui;

public class FindCommand extends Command {
    private String args;

    public FindCommand(String args) {
        this.args = args;
    }

    @Override
    public boolean run(TaskList taskList, Ui ui) throws JuinException {
        if (args == null || args.isBlank()) {
            throw new JuinException("   Search keyword cannot be empty.");
        }

        TaskList keyList = new TaskList(new ArrayList<>());
        for (Task task : taskList.getTasks()) {
            if (task.getDescription().contains(args)) {
                keyList.addTask(task);
            }
        }
        ui.showKeyListMessage(keyList, args);

        return false;
    }
}
