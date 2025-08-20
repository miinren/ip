import java.sql.SQLOutput;
import java.util.Scanner;

public class Juin {
    public static void main(String[] args) {
        String logo =
            "░░░░░██╗██╗░░░██╗██╗███╗░░██╗\n"
        + "   ░░░░░██║██║░░░██║██║████╗░██║\n"
        + "   ░░░░░██║██║░░░██║██║██╔██╗██║\n"
        + "   ██╗░░██║██║░░░██║██║██║╚████║\n"
        + "   ╚█████╔╝╚██████╔╝██║██║░╚███║\n"
        + "   ░╚════╝░░╚═════╝░╚═╝╚═╝░░╚══╝\n";
        System.out.println(
                "   ____________________________________________________________\n"
                + "   Hello! I'm JUIN\n"
                + "   What can I do for you?\n"
                + "   ____________________________________________________________");

        Scanner sc = new Scanner(System.in);
        String echo = "";
        TaskList tasklist = new TaskList();

        while (true) {
            echo = sc.nextLine();
            if (echo.equals("bye")) {
                break;
            }

            else if (echo.equals("list")) {
                System.out.println("   ____________________________________________________________");
                System.out.println(tasklist.listTasks());
                System.out.println("   ____________________________________________________________\n");
            }

            else if (echo.startsWith("mark")) {
                String[] parts = echo.split(" ", 2);
                int number = Integer.parseInt(parts[1]);
                System.out.println("   ____________________________________________________________");
                System.out.println(tasklist.markTaskDone(number));
                System.out.println("   ____________________________________________________________");
            }

            else if (echo.startsWith("unmark")) {
                String[] parts = echo.split(" ", 2);
                int number = Integer.parseInt(parts[1]);
                System.out.println("   ____________________________________________________________");
                System.out.println(tasklist.unmarkTaskDone(number));
                System.out.println("   ____________________________________________________________");
            }

            else {
                System.out.println("   ____________________________________________________________");
                System.out.println(tasklist.addTask(echo));
                System.out.println("   ____________________________________________________________\n");
            }
        }

        System.out.println(
                "   ____________________________________________________________\n"
                + "   Bye. Hope to see you again soon!\n"
                + "   ____________________________________________________________\n   "
                + logo
            );
        sc.close();
    }
}
