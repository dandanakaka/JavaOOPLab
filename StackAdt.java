// File: StackOverflowException.java
class StackOverflowException extends Exception {
    public StackOverflowException(String message) {
        super(message);
    }
}

// File: StackUnderflowException.java
class StackUnderflowException extends Exception {
    public StackUnderflowException(String message) {
        super(message);
    }
}

// File: MyStack.java
interface MyStack<T> {
    void push(T item) throws StackOverflowException;
    T pop() throws StackUnderflowException;
    void display();
    boolean isEmpty();
    boolean isFull();
    int size();
    String toString();
}

// File: StackArray.java
import java.util.Arrays;

class StackArray<T> implements MyStack<T> {
    private Object[] array;
    private int top;
    private int capacity;
    private static final int MAX_CAPACITY = 100;

    public StackArray(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive.");
        }
        this.capacity = Math.min(initialCapacity, MAX_CAPACITY);
        this.array = new Object[this.capacity];
        this.top = -1;
    }

    @Override
    public void push(T item) throws StackOverflowException {
        if (top == MAX_CAPACITY - 1) {
            throw new StackOverflowException("Cannot push. Stack has reached maximum capacity of " + MAX_CAPACITY);
        }
        if (isFull()) {
            resize();
        }
        array[++top] = item;
    }

    private void resize() {
        int newCapacity = Math.min(capacity * 2, MAX_CAPACITY);
        // This message will be logged by the main application's logger
        System.out.println("Stack resized to capacity: " + newCapacity);
        array = Arrays.copyOf(array, newCapacity);
        capacity = newCapacity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("Cannot pop from empty stack.");
        }
        T item = (T) array[top];
        array[top--] = null;
        return item;
    }

    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack elements (top to bottom): " + this.toString());
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = top; i >= 0; i--) {
            sb.append(array[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
}

// File: LoggerSetup.java
import java.io.IOException;
import java.util.logging.*;

/**
 * A utility class to configure the logger.
 * This follows the pattern from the provided GeneratePaySlip example.
 */
class LoggerSetup {
    public static Logger setupLogger() {
        Logger logger = Logger.getLogger(StackAdt.class.getName());
        try {
            // Remove default console handler to avoid duplicate output
            Logger rootLogger = Logger.getLogger("");
            Handler[] handlers = rootLogger.getHandlers();
            if (handlers.length > 0 && handlers[0] instanceof ConsoleHandler) {
                rootLogger.removeHandler(handlers[0]);
            }

            logger.setLevel(Level.INFO);

            // Console Handler with simple formatting
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new SimpleFormatter() {
                @Override
                public synchronized String format(LogRecord lr) {
                    // Print only the message to the console
                    return lr.getMessage() + "\n";
                }
            });
            logger.addHandler(consoleHandler);

            // File Handler with detailed formatting
            FileHandler fileHandler = new FileHandler("stack_session.log", false); // Overwrite log
            fileHandler.setFormatter(new SimpleFormatter() {
                private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s";
                @Override
                public synchronized String format(LogRecord lr) {
                    return String.format(format,
                            new java.util.Date(lr.getMillis()),
                            lr.getLevel().getLocalizedName(),
                            lr.getMessage()
                    ) + "\n";
                }
            });
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            logger.severe("Error setting up logger: " + e.getMessage());
        }
        return logger;
    }
}


// File: StackAdt.java
import java.util.Scanner;
import java.util.logging.Logger;

public class StackAdt {

    // Get the configured logger from our setup class
    private static final Logger logger = LoggerSetup.setupLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyStack<String> stack;

        try {
            logger.info("--- Stack ADT Program ---");
            System.out.print("Enter initial stack size: ");
            String input = scanner.nextLine();
            logger.info("USER INPUT: " + input);
            int initialSize = Integer.parseInt(input);
            stack = new StackArray<>(initialSize);
        } catch (NumberFormatException e) {
            logger.severe("Invalid number for initial size. Program will exit.");
            return;
        } catch (IllegalArgumentException e) {
            logger.severe("ERROR: " + e.getMessage() + ". Program will exit.");
            return;
        }

        int choice = 0;
        while (choice != 4) {
            logger.info("\n--- Stack Menu ---\n1. Push\n2. Pop\n3. Display\n4. Exit");
            System.out.print("Choice: ");
            
            try {
                String input = scanner.nextLine();
                logger.info("USER INPUT: " + input);

                if (input.trim().isEmpty()) {
                    logger.warning("Invalid input. Please enter a number.");
                    continue;
                }
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        System.out.print("Enter value to push: ");
                        String valueToPush = scanner.nextLine();
                        logger.info("USER INPUT: " + valueToPush);
                        
                        stack.push(valueToPush);
                        logger.info(valueToPush + " pushed to stack.");
                        break;

                    case 2:
                        String poppedValue = stack.pop();
                        logger.info(poppedValue + " popped from stack.");
                        break;

                    case 3:
                        // The display method uses System.out, which our logger doesn't capture.
                        // So, we log the state separately for the file.
                        if (stack.isEmpty()) {
                            logger.info("Stack is empty.");
                        } else {
                            logger.info("Stack elements (top to bottom): " + stack.toString());
                        }
                        break;

                    case 4:
                        logger.info("Program exiting...");
                        break;

                    default:
                        logger.warning("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                logger.warning("Invalid input. Please enter a number.");
            } catch (StackOverflowException | StackUnderflowException e) {
                logger.severe("Exception: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
