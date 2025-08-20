import java.util.ArrayList;

public class TaskList {
    private ArrayList <String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public String listTasks() {
        if (tasks.isEmpty()) {
            return "No tasks found";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("   Tasks: \n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append("   " + (i + 1) + ". " + tasks.get(i) + "\n");
        }
        return sb.toString();
    }
}
