package PeanutButter.Tasks;

import PeanutButter.Exceptions.JuinException;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private ArrayList <Task> taskList;

    public TaskList(List<Task> read) {
        this.taskList = new ArrayList<>(read);
    }

    public List<Task> getTasks() {
        return this.taskList;
    }

    public void addTask(Task task) throws JuinException {
        taskList.add(task);
    }

    public Task deleteTask(int index) throws JuinException {
        checkIndex(index);
        return taskList.remove(index);
    }

    public void markTaskDone(int index) throws JuinException {
        checkIndex(index);
        taskList.get(index).markDone();
    }

    public void unmarkTaskDone(int index) throws JuinException {
        checkIndex(index);
        taskList.get(index).unmarkDone();
    }

    public int size() {
        return taskList.size();
    }

    public Task get(int index) throws JuinException {
       checkIndex(index);
        return taskList.get(index);
    }

    private void checkIndex(int index) throws JuinException {
        if (index < 0 || index >= taskList.size()) {
            throw new JuinException("   INVALID TASK");
        }
    }
}
