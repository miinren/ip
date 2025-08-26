import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private LocalDateTime byDT;
    private LocalDate byD;

    private static final DateTimeFormatter inputDT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter outputDT = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
    private static final DateTimeFormatter inputD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter outputD = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Deadline(String description, String by) {
        super(description, TaskType.DEADLINE);

        try {
            byDT = LocalDateTime.parse(by, inputDT);
        } catch (DateTimeParseException e) {
            try {
                byDT = null;
                byD = LocalDate.parse(by, inputD);
            } catch (DateTimeParseException e2) {
                throw new IllegalArgumentException("Invalid date/time format. Use yyyy-MM-dd or yyyy-MM-dd HHmm");
            }
        }
    }

    @Override
    public String toString() {
        String byStr = byDT == null ? byD.format(outputD) : byDT.format(outputDT);
        return "[D] " + super.toString() + " (by: " + byStr + ")";
    }

    @Override
    public String makePretty() {
        String byStr = byDT == null ? byD.format(outputD) : byDT.format(outputDT);
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + byStr;
    }
}
