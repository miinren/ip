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

            if (echo.equals("list")) {
                System.out.println("   ____________________________________________________________");
                System.out.println(tasklist.listTasks());
                System.out.printf("   ____________________________________________________________\n");
            } else {
                tasklist.addTask(echo);
                System.out.println(
                        "   ____________________________________________________________\n"
                                + "   added: " + echo + "\n"
                                + "   ____________________________________________________________"
                );
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
