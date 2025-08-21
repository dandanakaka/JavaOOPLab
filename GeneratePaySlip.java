import employee.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.logging.*;

public class GeneratePaySlip {

    // Set up a logger that writes to a file
    private static final Logger logger = Logger.getLogger(GeneratePaySlip.class.getName());

    static {
        try {
            // Remove the default console handler to avoid duplicate console output
            Logger rootLogger = Logger.getLogger("");
            Handler[] handlers = rootLogger.getHandlers();
            if (handlers.length > 0 && handlers[0] instanceof ConsoleHandler) {
                rootLogger.removeHandler(handlers[0]);
            }

            // Add our custom console handler and file handler
            logger.setLevel(Level.INFO);
            
            // Handler for Console
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new SimpleFormatter() {
                 @Override
                 public synchronized String format(LogRecord lr) {
                     return lr.getMessage() + "\n";
                 }
            });
            logger.addHandler(consoleHandler);

            // Handler for File
            FileHandler fileHandler = new FileHandler("user_session.log", false); // false to overwrite
            fileHandler.setFormatter(new SimpleFormatter() {
                 private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";
                 @Override
                 public synchronized String format(LogRecord lr) {
                     return String.format(format,
                             new java.util.Date(lr.getMillis()),
                             lr.getLevel().getLocalizedName(),
                             lr.getMessage()
                     );
                 }
            });
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            logger.severe("Error setting up logger: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        logger.info("--- Employee Pay Slip Generation System ---");

        while (true) {
            logger.info("\nChoose Employee Type to Add:");
            logger.info("1. Programmer");
            logger.info("2. Assistant Professor");
            logger.info("3. Associate Professor");
            logger.info("4. Professor");
            logger.info("5. Finish and Generate Pay Slips");
            logger.info("Enter your choice: ");

            int choice = readInt(scanner);

            if (choice == 5) {
                logger.info("USER INPUT: 5 (Finish)");
                break;
            }

            Employee emp = createEmployee(scanner, choice);
            if (emp != null) {
                employees.add(emp);
                logger.info("-> Employee '" + emp.getEmp_name() + "' added successfully.");
            }
        }

        // Generate and display pay slips for all entered employees
        if (employees.isEmpty()) {
            logger.info("\nNo employees were entered. Exiting.");
        } else {
            logger.info("\n--- Generating Pay Slips for All Employees ---");
            for (Employee emp : employees) {
                logEmployeeDetails(emp);
            }
            logger.info("\n--- Process Complete. Full transcript saved to user_session.log ---");
        }

        scanner.close();
    }

    private static Employee createEmployee(Scanner scanner, int type) {
        String empTypeStr = "";
        switch(type) {
            case 1: empTypeStr = "Programmer"; break;
            case 2: empTypeStr = "Assistant Professor"; break;
            case 3: empTypeStr = "Associate Professor"; break;
            case 4: empTypeStr = "Professor"; break;
            default:
                logger.warning("Invalid choice. Please try again.");
                return null;
        }
        logger.info("USER INPUT: " + type + " (" + empTypeStr + ")");
        logger.info("\nEnter details for the " + empTypeStr + ":");
        
        logger.info("Enter Name: ");
        String name = scanner.next() + scanner.nextLine(); // Consume newline
        logger.info("USER INPUT: " + name);

        logger.info("Enter Employee ID: ");
        int id = readInt(scanner);
        logger.info("USER INPUT: " + id);

        logger.info("Enter Address: ");
        String address = scanner.next() + scanner.nextLine();
        logger.info("USER INPUT: " + address);
        
        logger.info("Enter Mail ID: ");
        String mail = scanner.next();
        logger.info("USER INPUT: " + mail);
        
        logger.info("Enter Mobile No: ");
        long mobile = readLong(scanner);
        logger.info("USER INPUT: " + mobile);
        
        logger.info("Enter Basic Pay (e.g., 60000): ");
        double basicPay = readDouble(scanner);
        logger.info("USER INPUT: " + basicPay);

        switch (type) {
            case 1: return new Programmer(name, id, address, mail, mobile, basicPay);
            case 2: return new AssistantProfessor(name, id, address, mail, mobile, basicPay);
            case 3: return new AssociateProfessor(name, id, address, mail, mobile, basicPay);
            case 4: return new Professor(name, id, address, mail, mobile, basicPay);
        }
        return null;
    }

    private static void logEmployeeDetails(Employee emp) {
        logger.info("\n-----------------------------------------");
        logger.info("Employee Name: " + emp.getEmp_name());
        logger.info("Employee ID: " + emp.getEmp_id());
        logger.info("Address: " + emp.getAddress());
        logger.info("Mail ID: " + emp.getMail_id());
        logger.info("Mobile No: " + emp.getMobile_no());
        // Get the pay slip details as a string and log it
        logger.info(emp.getPaySlip());
        logger.info("-----------------------------------------");
    }
    
    // Helper methods for robust numeric input
    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                logger.warning("Invalid input. Please enter a whole number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
    private static long readLong(Scanner scanner) {
         while (true) {
            try {
                return scanner.nextLong();
            } catch (InputMismatchException e) {
                logger.warning("Invalid input. Please enter a valid mobile number.");
                scanner.next();
            }
        }
    }
    private static double readDouble(Scanner scanner) {
         while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                logger.warning("Invalid input. Please enter a number (e.g., 60000.0).");
                scanner.next();
            }
        }
    }
}