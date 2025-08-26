import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String path;

    public Storage(String path) {
        this.path = path;
    }

    public void write(TaskList taskList) {
        File folder = new File("data");
        if (!folder.exists()) {
            folder.mkdir();
        }

        try (FileWriter fw = new FileWriter(this.path)) {
            for (Task task : taskList.getTasks()) {
                fw.write(task.makePretty() + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Task> read() {
        File file = new File(path);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        List<Task> tasks = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    Task task = parseFile(line);
                    tasks.add(task);
                }
            }
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }

        return tasks;
    }

    public Task parseFile(String line) {
        String[] parts = line.split("\\s*\\|\\s*");
        String taskType = parts[0];
        Boolean isDone = "1".equals(parts[1]);
        String description = parts[2];
        Task task = null;

        switch (taskType) {
        case "T":
            task = new Todo(description);
            break;

        case "D":
            task = new Deadline(description, parts[3]);
            break;

        case "E":
            task = new Event(description, parts[3], parts[4]);
            break;

        default:
            throw new IllegalArgumentException();
        }

        if (isDone) {
            task.markDone();
        }

        return task;
    }
}
