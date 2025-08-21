public class Task {
    protected String description;
    protected Boolean done;
    protected TaskType type;

    public Task(String description, TaskType type) {
        this.description = description;
        this.done = false;
        this.type = type;
    }

    public void markDone() {
        this.done = true;
    }

    public void unmarkDone() {
        this.done = false;
    }

    public String getDescription() {
        return this.description;
    }

    public Boolean getDone() {
        return this.done;
    }

    @Override
    public String toString() {
        return (done ? "[X] " : "[ ] ") + description;
    }
}
