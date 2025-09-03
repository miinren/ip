package peanutbutter.ui;

import java.util.Scanner;
import peanutbutter.tasks.Task;
import peanutbutter.tasks.TaskList;

public class Ui {
    private Scanner sc;
    private String lastMessage;

    public Ui() {
        sc = new Scanner(System.in);
        lastMessage = "";
    }

    public String welcomeMessage() {
        String msg = "Hello! I'm JUIN. What can I do for you?";
        setLastMessage(msg);
        System.out.println(msg);
        return msg;
    }

    public void byeMessage() {
        String msg = "Bye. Hope to see you again soon!";
        setLastMessage(msg);
        System.out.println(msg);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void addTaskMessage(TaskList taskList, Task... tasks) {
        StringBuilder sb = new StringBuilder();
        for (Task task : tasks) {
            sb.append("Added: ").append(task).append("\n");
        }
        sb.append("Now you have ").append(taskList.size()).append(" tasks in the list!");
        String msg = sb.toString().trim();
        setLastMessage(msg);
        System.out.println(msg);
    }

    public void deleteTaskMessage(TaskList taskList, Task task) {
        String msg = "Removed: " + task.toString() + "\n"
                + "Now you have " + taskList.size() + " tasks in the list!";
        setLastMessage(msg);
        System.out.println(msg);
    }

    public void markTaskMessage(Task task) {
        String msg = "Marked as done: " + task.toString();
        setLastMessage(msg);
        System.out.println(msg);
    }

    public void unmarkTaskMessage(Task task) {
        String msg = "Marked as not done: " + task.toString();
        setLastMessage(msg);
        System.out.println(msg);
    }

    public void showListMessage(TaskList taskList) {
        StringBuilder sb = new StringBuilder();
        if (taskList.size() < 1) {
            sb.append("No tasks found.");
        } else {
            sb.append("Tasks in your list:\n");
            for (int i = 0; i < taskList.size(); i++) {
                sb.append(i + 1).append(". ").append(taskList.getTasks().get(i)).append("\n");
            }
        }
        String msg = sb.toString().trim();
        setLastMessage(msg);
        System.out.println(msg);
    }

    public void showKeyListMessage(TaskList taskList, String key) {
        StringBuilder sb = new StringBuilder();
        if (taskList.size() < 1) {
            sb.append("No tasks found.");
        } else {
            sb.append("Tasks containing \"").append(key).append("\":\n");
            for (int i = 0; i < taskList.size(); i++) {
                sb.append(i + 1).append(". ").append(taskList.getTasks().get(i)).append("\n");
            }
        }
        String msg = sb.toString().trim();
        setLastMessage(msg);
        System.out.println(msg);
    }

    public void errorMessage(String msg) {
        setLastMessage(msg);
        System.out.println(msg);
    }

    public String getLastMessage() {
        return lastMessage;
    }

    private void setLastMessage(String msg) {
        lastMessage = msg;
    }
}
