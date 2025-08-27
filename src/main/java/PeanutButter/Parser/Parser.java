package PeanutButter.Parser;

import PeanutButter.Exceptions.JuinException;
import PeanutButter.Commands.*;

public class Parser {
    public static Command parse(String input) throws JuinException {
        input = input.trim();
        if (input.isEmpty()) {
            throw new JuinException("   Input cannot be empty");
        }

        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();
        String args = parts.length > 1 ? parts[1].trim() : "";

        switch (command) {
        case "bye": return new ExitCommand();
        case "list": return new ListCommand();
        case "mark": return new MarkCommand(args);
        case "unmark": return new UnmarkCommand(args);
        case "delete": return new DeleteCommand(args);
        case "todo": return new TodoCommand(args);
        case "deadline": return new DeadlineCommand(args);
        case "event": return new EventCommand(args);
        default: throw new JuinException("   Sorry, I don't understand that command.");
        }
    }
}
