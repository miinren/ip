package peanutbutter.parser;

import peanutbutter.commands.*;
import peanutbutter.exceptions.JuinException;

public class Parser {
    public static Command parse(String input) throws JuinException {
        input = input.trim();
        if (input.isEmpty()) {
            throw new JuinException("Input cannot be empty");
        }

        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();
        String args = parts.length > 1 ? parts[1].trim() : "";

        switch (command) {
        case "bye": return new ExitCommand();
        case "list": return new ListCommand();
        case "mark": assert !args.isEmpty() : "command must have arguments";
            return new MarkCommand(args);
        case "unmark": assert !args.isEmpty() : "command must have arguments";
            return new UnmarkCommand(args);
        case "delete": assert !args.isEmpty() : "command must have arguments";
            return new DeleteCommand(args);
        case "todo": assert !args.isEmpty() : "command must have arguments";
            return new TodoCommand(args);
        case "deadline": assert !args.isEmpty() : "command must have arguments";
            return new DeadlineCommand(args);
        case "event": assert !args.isEmpty() : "command must have arguments";
            return new EventCommand(args);
        case "find": assert !args.isEmpty() : "command must have arguments";
            return new FindCommand(args);
        default: throw new JuinException("Sorry, I don't understand that command.");
        }
    }
}
