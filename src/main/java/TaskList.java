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

    public String addTask(String input) {
        Task task;
        if (input.startsWith("todo ")) {
            task = new Todo(input.substring(5));
        } else if (input.startsWith("deadline ")) {
            String[] parts = input.substring(9).split(" /by", 2);
            task = new Deadline(parts[0], parts[1]);
        } else if (input.startsWith("event ")) {
            String[] parts = input.substring(6  ).split(" /from | /to");
            task = new Event(parts[0], parts[1], parts[2]);
        } else {
            task = new Task(input);
        }
        tasks.add(task);
        return "   Added: " + task.toString() + "\n" + "      Now you have " + tasks.size() + " in the list!";
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
