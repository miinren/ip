package PeanutButter.Commands;

import PeanutButter.Exceptions.JuinException;
import PeanutButter.Tasks.Task;
import PeanutButter.Tasks.TaskList;
import PeanutButter.Ui.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {
    private String args;

    public FindCommand(String args) {
        this.args = args;
    }

    @Override
    public boolean run(TaskList taskList, Ui ui) throws JuinException {
        if (args == null || args.isBlank()) {
            throw new JuinException("Search keyword cannot be empty.");
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
