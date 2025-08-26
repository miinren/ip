import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private ArrayList <Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public String addTask(String input) throws JuinException {
        Task task;
        if (input.isBlank()) {
            throw new JuinException("   Input cannot be empty!");
        }

        String[] words = input.split(" ", 2);
        String type = words[0].toLowerCase();
        String description;
        if (words.length > 1) {
            description = words[1].trim();
        } else {
            throw new JuinException("   Sorry I don't understand.");
        }

        switch(type) {
            case "todo":
                if (description.isEmpty()) {
                    throw new JuinException("   The description of todo cannot be empty!");
                }
                task = new Todo(description);
                break;

            case "deadline":
                String[] deadlineParts = description.split(" /by", 2);
                if (deadlineParts[0].isBlank() || deadlineParts[1].isBlank()) {
                    throw new JuinException("   The description or time of deadline cannot be empty!");
                }
                try {
                    task = new Deadline(deadlineParts[0].trim(), deadlineParts[1].trim());
                } catch (IllegalArgumentException e) {
                    throw new JuinException("   Invalid date/time format. Use yyyy-MM-dd or yyyy-MM-dd HHmm");
                }
                break;

            case "event":
                String[] eventParts = description.split(" /from | /to");
                if (!input.contains(" /from") || !input.contains(" /to")) {
                    throw new JuinException("   Make sure theres a from and to!");
                }
                try {
                    task = new Event(eventParts[0].trim(), eventParts[1].trim(), eventParts[2].trim());
                } catch (IllegalArgumentException e) {
                    throw new JuinException("   Invalid date/time format. Use yyyy-MM-dd or yyyy-MM-dd HHmm");
                }
                break;

            default:
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
