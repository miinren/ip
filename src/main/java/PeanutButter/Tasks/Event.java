package PeanutButter.Tasks;

import PeanutButter.TaskType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    private LocalDateTime fromDT;
    private LocalDateTime toDT;
    private LocalDate fromD;
    private LocalDate toD;

    private static final DateTimeFormatter inputDT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter outputDT = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
    private static final DateTimeFormatter inputD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter outputD = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Event(String description, String from, String to) {
        super(description, TaskType.EVENT);

        try {
            fromDT = LocalDateTime.parse(from, inputDT);
        } catch (DateTimeParseException e) {
            try {
                fromDT = null;
                fromD = LocalDate.parse(from, inputD);
            } catch (DateTimeParseException e2) {
                throw new IllegalArgumentException("Invalid date/time format. Use yyyy-MM-dd or yyyy-MM-dd HHmm");
            }
        }

        try {
            toDT = LocalDateTime.parse(to, inputDT);
        } catch (DateTimeParseException e) {
            toDT = null;
            toD = LocalDate.parse(to, inputD);
        }
    }

    @Override
    public String toString() {
        String fromStr = fromDT == null ? fromD.format(outputD) : fromDT.format(outputDT);
        String toStr = toDT == null ? toD.format(outputD) : toDT.format(outputDT);

        return "[E] " + super.toString() + " (from: " + fromStr + " to: " + toStr + ")";
    }

    @Override
    public String makePretty() {
        String fromStr = fromDT == null ? fromD.format(outputD) : fromDT.format(outputDT);
        String toStr = toDT == null ? toD.format(outputD) : toDT.format(outputDT);

        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + fromStr + " | " + toStr;
    }
}
