package peanutbutter.commands;

import peanutbutter.Juin;
import peanutbutter.exceptions.JuinException;
import peanutbutter.tasks.Deadline;
import peanutbutter.tasks.Event;
import peanutbutter.tasks.Task;
import peanutbutter.tasks.TaskList;
import peanutbutter.ui.Ui;

import java.time.LocalDateTime;
import java.util.List;

public class ReminderCommand extends Command {
    @Override
    public boolean run(TaskList taskList, Ui ui) throws JuinException {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tmr = now.plusDays(1);

        List<Task> upcomingTasks = taskList.getTasks().stream()
                .filter(task -> {
                    if (task instanceof Deadline d) {
                        LocalDateTime due = d.getDueDateTime();
                        return due != null && !due.isBefore(now) && !due.isAfter(tmr);
                    } else if (task instanceof Event e) {
                        LocalDateTime start = e.getStartTime();
                        return start != null && !start.isBefore(now) && !start.isAfter(tmr);
                    } else {
                        return false;
                    }
                }).toList();
        TaskList dueList = new TaskList(upcomingTasks);
        ui.showDueListMessage(dueList);

        return false;
    }
}
