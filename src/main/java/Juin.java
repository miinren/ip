import java.sql.SQLOutput;
import java.util.Scanner;
import java.io.File;
import java.util.List;

public class Juin {
    private TaskList taskList;
    private Storage storage;

    private static final String DATA_FOLDER = "data";
    private static final String DATA_FILE = "juin.txt";

    public Juin() {
        File folder = new File(DATA_FOLDER);
        if (!folder.exists()) {
            folder.mkdir();
        }

        File file = new File(folder, DATA_FILE);
        this.storage = new Storage(file.getPath());
        System.out.println("saved at" + file.getAbsolutePath());

        List<Task> loadedTasks = storage.read();
        this.taskList = new TaskList();
        this.taskList.getTasks().addAll(loadedTasks);
    }

    public static void main(String[] args) {
        Juin juin = new Juin();

        System.out.println(
                "   ____________________________________________________________\n"
                + "   Hello! I'm JUIN\n"
                + "   What can I do for you?\n"
                + "   ____________________________________________________________");

        Scanner sc = new Scanner(System.in);
        String echo = "";

        while (true) {
            echo = sc.nextLine();
            if (echo.equals("bye")) {
                break;
            }

            else if (echo.equals("list")) {
                System.out.println("   ____________________________________________________________");
                System.out.println(juin.taskList.listTasks());
                System.out.println("   ____________________________________________________________\n");
            }

            else if (echo.startsWith("mark")) {
                String[] parts = echo.split(" ", 2);
                int number = Integer.parseInt(parts[1]);
                try {
                    System.out.println("   ____________________________________________________________");
                    System.out.println(juin.taskList.markTaskDone(number));
                    System.out.println("   ____________________________________________________________");
                } catch (JuinException e) {
                    System.out.println(e.getMessage());
                    System.out.println("   ____________________________________________________________");
                }
            }

            else if (echo.startsWith("unmark")) {
                String[] parts = echo.split(" ", 2);
                int number = Integer.parseInt(parts[1]);
                try {
                    System.out.println("   ____________________________________________________________");
                    System.out.println(juin.taskList.unmarkTaskDone(number));
                    System.out.println("   ____________________________________________________________");
                } catch (JuinException e) {
                    System.out.println(e.getMessage());
                    System.out.println("   ____________________________________________________________");
                }
            }

            else if (echo.startsWith("delete")) {
                String[] parts = echo.split(" ",2 );
                int number = Integer.parseInt(parts[1]);
                try {
                    System.out.println("   ____________________________________________________________");
                    System.out.println(juin.taskList.deleteTask(number));
                    System.out.println("   ____________________________________________________________");
                } catch (JuinException e) {
                    System.out.println(e.getMessage());
                    System.out.println("   ____________________________________________________________");
                }
            }

            else {
                try {
                    System.out.println("   ____________________________________________________________");
                    System.out.println(juin.taskList.addTask(echo));
                    System.out.println("   ____________________________________________________________\n");
                } catch (JuinException e) {
                    System.out.println(e.getMessage());
                    System.out.println("   ____________________________________________________________\n");
                }
            }
        }

        juin.storage.write(juin.taskList);
        System.out.println(
                "   ____________________________________________________________\n"
                + "   Bye. Hope to see you again soon!\n"
                + "   ____________________________________________________________\n   "
            );
        sc.close();
    }
}
