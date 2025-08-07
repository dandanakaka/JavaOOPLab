package LogUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {
    private static PrintWriter writer;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


    public static void init() {
        try {
            .
            writer = new PrintWriter(new FileWriter("converter_log.txt", true), true);
        } catch (IOException e) {
            System.out.println("An error occurred while opening the log file.");
            e.printStackTrace();
        }
    }

  
    public static void log(String message) {
        if (writer != null) {
            writer.println(dtf.format(LocalDateTime.now()) + " - " + message);
        }
    }

  
    public static void close() {
        if (writer != null) {
            writer.close();
        }
    }
}

