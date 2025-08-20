import java.util.ArrayList;

public class TaskList {
    private ArrayList <Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public Task getTask(int number) {
        if (number > 0 && number <= tasks.size()) {
            return tasks.get(number - 1);
        }
        return null;
    }

    public String addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        return "   Added: " + description;
    }

    public String listTasks() {
        if (tasks.isEmpty()) {
            return "   No tasks found";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("   Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append("\n   " + (i + 1) + ". " + tasks.get(i));
        }
        return sb.toString();
    }

    public String markTaskDone(int number) {
        if (number > 0 && number <= tasks.size()) {
            Task task = tasks.get(number - 1);
            task.markDone();
            return "   Nice! I've marked this task as done: \n" + "      " + task;
        } else {
            return "   Invalid task!";
        }
    }

    public String unmarkTaskDone(int number) {
        if (number > 0 && number <= tasks.size()) {
            Task task = tasks.get(number - 1);
            task.unmarkDone();
            return "   Shucks! I've marked this task as not done yet: \n" + "      " + task;
        } else {
            return "   Invalid task!";
        }
    }
}
