
import CurrencyConverter.CurrencyConverter;
import DistanceConverter.DistanceConverter;
import TimeConverter.TimeConverter;
import LogUtil.LogWriter;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        LogWriter.init();
        LogWriter.log("Application started.");

        Scanner scanner = new Scanner(System.in);
        int mainChoice;

        try {
            do {
                System.out.println("\n===== UNIVERSAL CONVERTER =====");
                System.out.println("1. Currency Converter");
                System.out.println("2. Distance Converter");
                System.out.println("3. Time Converter");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                mainChoice = scanner.nextInt();
                LogWriter.log("User selected main menu option: " + mainChoice);

                switch (mainChoice) {
                    case 1:
                        handleCurrencyConversion(scanner);
                        break;
                    case 2:
                        handleDistanceConversion(scanner);
                        break;
                    case 3:
                        handleTimeConversion(scanner);
                        break;
                    case 4:
                        System.out.println("Thank you for using the converter!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        LogWriter.log("Invalid main menu option entered.");
                        break;
                }
            } while (mainChoice != 4);

        } finally {
            // This block ensures the log file is closed and scanner is closed
            // even if an error occurs.
            LogWriter.log("Application closing.");
            LogWriter.close();
            scanner.close();
        }
    }

    public static void handleCurrencyConversion(Scanner scanner) {
        CurrencyConverter converter = new CurrencyConverter();
        System.out.println("\n--- Currency Converter ---");
        System.out.println("1. Dollar to INR");
        System.out.println("2. INR to Dollar");
        System.out.println("3. Euro to INR");
        System.out.println("4. INR to Euro");
        System.out.println("5. Yen to INR");
        System.out.println("6. INR to Yen");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        LogWriter.log("User selected currency conversion: " + choice);

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        LogWriter.log("Amount entered: " + amount);
        
        double result = 0;
        String logMessage = "";

        switch (choice) {
            case 1:
                result = converter.dollortoinr(amount);
                logMessage = String.format("%.2f USD is %.2f INR", amount, result);
                break;
            case 2:
                result = converter.inrtodollor(amount);
                logMessage = String.format("%.2f INR is %.2f USD", amount, result);
                break;
            // ... add other cases similarly
            default:
                System.out.println("Invalid currency choice.");
                LogWriter.log("Invalid currency choice entered.");
                return;
        }
        System.out.println("Result: " + logMessage);
        LogWriter.log("Conversion Result: " + logMessage);
    }

    public static void handleDistanceConversion(Scanner scanner) {
        DistanceConverter converter = new DistanceConverter();
        System.out.println("\n--- Distance Converter ---");
        System.out.println("1. Meter to KM");
        System.out.println("2. KM to Meter");
        System.out.println("3. Miles to KM");
        System.out.println("4. KM to Miles");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        LogWriter.log("User selected distance conversion: " + choice);

        System.out.print("Enter the distance: ");
        double distance = scanner.nextDouble();
        LogWriter.log("Distance entered: " + distance);

        double result = 0;
        String logMessage = "";

        switch (choice) {
            case 1:
                result = converter.metertokm(distance);
                logMessage = String.format("%.3f meters is %.3f kilometers", distance, result);
                break;
            case 2:
                result = converter.kmtometer(distance);
                logMessage = String.format("%.3f kilometers is %.3f meters", distance, result);
                break;
            // ... add other cases
            default:
                System.out.println("Invalid distance choice.");
                LogWriter.log("Invalid distance choice entered.");
                return;
        }
        System.out.println("Result: " + logMessage);
        LogWriter.log("Conversion Result: " + logMessage);
    }
    
    public static void handleTimeConversion(Scanner scanner) {
        TimeConverter converter = new TimeConverter();
        System.out.println("\n--- Time Converter ---");
        System.out.println("1. Hours to Minutes");
        System.out.println("2. Minutes to Hours");
        System.out.println("3. Hours to Seconds");
        System.out.println("4. Seconds to Hours");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        LogWriter.log("User selected time conversion: " + choice);

        System.out.print("Enter the time value: ");
        int time = scanner.nextInt();
        LogWriter.log("Time value entered: " + time);

        double result = 0;
        String logMessage = "";

        switch(choice) {
            case 1:
                result = converter.hourstominutes(time);
                logMessage = String.format("%d hours is %.0f minutes", time, result);
                break;
            case 2:
                result = converter.minutestohours(time);
                logMessage = String.format("%d minutes is %.2f hours", time, result);
                break;
            // ... add other cases
            default:
                System.out.println("Invalid time choice.");
                LogWriter.log("Invalid time choice entered.");
                return;
        }
        System.out.println("Result: " + logMessage);
        LogWriter.log("Conversion Result: " + logMessage);
    }
}
