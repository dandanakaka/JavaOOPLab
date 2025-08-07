package LogUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// A utility class to handle logging operations to a file.
public class LogWriter {
    private static PrintWriter writer;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    // Initializes the PrintWriter to write to "converter_log.txt".
    // The 'true' argument enables auto-flushing.
    public static void init() {
        try {
            // FileWriter in append mode, so we don't erase the log on each run.
            writer = new PrintWriter(new FileWriter("converter_log.txt", true), true);
        } catch (IOException e) {
            System.out.println("An error occurred while opening the log file.");
            e.printStackTrace();
        }
    }

    // Writes a message to the log file with a timestamp.
    public static void log(String message) {
        if (writer != null) {
            writer.println(dtf.format(LocalDateTime.now()) + " - " + message);
        }
    }

    // Closes the writer to ensure all data is saved to the file.
    public static void close() {
        if (writer != null) {
            writer.close();
        }
    }
}

