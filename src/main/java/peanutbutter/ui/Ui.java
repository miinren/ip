package peanutbutter.ui;

import java.util.Scanner;

import peanutbutter.tasks.Task;
import peanutbutter.tasks.TaskList;

public class Ui {
    private Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    public void welcomeMessage() {
        System.out.println(
                "   ____________________________________________________________\n"
                + "   Hello! I'm JUIN\n"
                + "   What can I do for you?\n"
                + "   ____________________________________________________________");
    }

    public void byeMessage() {
        System.out.println(
                "   ____________________________________________________________\n"
                + "   Bye. Hope to see you again soon!\n"
                + "   ____________________________________________________________\n"
        );
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void addTaskMessage(TaskList taskList, Task task) {
        System.out.println("   ____________________________________________________________");
        System.out.println("   Added: " + task.toString());
        System.out.println("   Now you have " + taskList.size() + " tasks in the list!");
        System.out.println("   ____________________________________________________________\n");
    }

    public void deleteTaskMessage(TaskList taskList, Task task) {
        System.out.println("   ____________________________________________________________");
        System.out.println("   Noted. I have removed this task: \n" + "      " + task);
        System.out.println("   Now you have " + taskList.size() + " tasks in the list!");
        System.out.println("   ____________________________________________________________\n");
    }

    public void markTaskMessage(Task task) {
        System.out.println("   ____________________________________________________________");
        System.out.println("   Nice! I've marked this task as done: \n" + "      " + task);
        System.out.println("   ____________________________________________________________\n");
    }

    public void unmarkTaskMessage(Task task) {
        System.out.println("   ____________________________________________________________");
        System.out.println("   Shucks! I've marked this task as not done: \n" + "      " + task);
        System.out.println("   ____________________________________________________________");
    }

    public void showListMessage(TaskList taskList) {
        System.out.println("   ____________________________________________________________");
        if (taskList.size() < 1) {
            System.out.println("   No tasks found.");
        } else {
            System.out.println("   Here are the tasks in your list:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println("   " + (i + 1) + ". " + taskList.getTasks().get(i));
            }
        }

        System.out.println("   ____________________________________________________________");
    }

    public void showKeyListMessage(TaskList taskList, String key) {
        System.out.println("   ____________________________________________________________");
        if (taskList.size() < 1) {
            System.out.println("   No tasks found.");
        } else {
            System.out.println("   Here are the tasks in your list containing " + "\"" + key + "\":");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println("   " + (i + 1) + ". " + taskList.getTasks().get(i));
            }
        }
        System.out.println("   ____________________________________________________________");
    }

    public void errorMessage(String msg) {
        System.out.println("   ____________________________________________________________");
        System.out.println("   " + msg);
        System.out.println("   ____________________________________________________________");
    }



}
