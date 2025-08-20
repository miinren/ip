public class Task {
    private String description;
    private Boolean done;

    public Task(String description) {
        this.description = description;
        this.done = false;
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
