package PeanutButter.Tasks;

import PeanutButter.TaskType;

public class Task {
    protected String description;
    protected Boolean isDone;
    protected TaskType type;

    public Task(String description, TaskType type) {
        this.description = description;
        this.isDone = false;
        this.type = type;
    }

    public void markDone() {
        this.isDone = true;
    }

    public void unmarkDone() {
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }

    public Boolean getDone() {
        return this.isDone;
    }

    @Override
    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + description;
    }

    public String makePretty() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }

}
