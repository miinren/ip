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

    public String addTask(String input) throws JuinException {
        Task task;
        if (input.startsWith("todo ")) {
            String description = input.substring(5);
            if (description.isEmpty()) {
                throw new JuinException("   The description of todo cannot be empty!");
            }
            task = new Todo(description);
        } else if (input.startsWith("deadline ")) {
            String description = input.substring(9).trim();
            if (!description.contains("/by")) {
                throw new JuinException("   There is no deadline!");
            }
            String[] parts = input.substring(9).split("/by", 2);
            if (parts[0].isBlank() || parts[1].isBlank()) {
                throw new JuinException("   The description or time of deadline cannot be empty!");
            }
            task = new Deadline(parts[0], parts[1]);
        } else if (input.startsWith("event ")) {
            if (!input.contains(" /from") || !input.contains(" /to")) {
                throw new JuinException("   Make sure theres a from and to!");
            }
            String[] parts = input.substring(6  ).split(" /from | /to");
            if (parts.length < 3 || parts[0].isBlank() || parts[1].isBlank() || parts[2].isBlank()) {
                throw new JuinException("   The description, from and to cannot be empty!");
            }

            task = new Event(parts[0], parts[1], parts[2]);
        } else {
            throw new JuinException("   Sorry I don't understand.");
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

    public String markTaskDone(int number) throws JuinException {
        if (number > 0 && number <= tasks.size()) {
            Task task = tasks.get(number - 1);
            task.markDone();
            return "   Nice! I've marked this task as done: \n" + "      " + task;
        } else {
            throw new JuinException("   Invalid task number!");
        }
    }

    public String unmarkTaskDone(int number) throws JuinException {
        if (number > 0 && number <= tasks.size()) {
            Task task = tasks.get(number - 1);
            task.unmarkDone();
            return "   Shucks! I've marked this task as not done yet: \n" + "      " + task;
        } else {
            throw new JuinException("   Invalid task number!");
        }
    }

    public String deleteTask(int number) throws JuinException {
        if (number > 0 && number <= tasks.size()) {
            Task task = tasks.get(number - 1);
            tasks.remove(number - 1);
            return "   Noted. I have removed this task: \n" + "      " + task + "\n" + "   Now you have " + tasks.size() + " in the list!";
        } else {
            throw new JuinException("   Invalid task number!");
        }
    }
}
