import java.util.Scanner;

class ElectricityBill {
    private int consumerNo;
    private String consumerName;
    private int previousReading;
    private int currentReading;
    private String connectionType;
    private double billAmount;

    public ElectricityBill(int consumerNo, String consumerName, int previousReading, int currentReading, String connectionType) {
        this.consumerNo = consumerNo;
        this.consumerName = consumerName;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
        this.connectionType = connectionType.toLowerCase();
    }

    public void calculateBill() {
        int unitsConsumed = currentReading - previousReading;
        if (unitsConsumed < 0) {
            System.out.println("Error: Current month reading is less than previous month reading.");
            billAmount = 0;
            return;
        }

        if (connectionType.equals("domestic")) {
            billAmount = calculateDomesticBill(unitsConsumed);
        } else if (connectionType.equals("commercial")) {
            billAmount = calculateCommercialBill(unitsConsumed);
        } else {
            System.out.println("Invalid connection type! Must be 'domestic' or 'commercial'.");
            billAmount = 0;
        }
    }

    private double calculateDomesticBill(int units) {
        double amount = 0;
        if (units <= 100) {
            amount = units * 1.0;
        } else if (units <= 200) {
            amount = 100 * 1.0 + (units - 100) * 2.5;
        } else if (units <= 500) {
            amount = 100 * 1.0 + 100 * 2.5 + (units - 200) * 4.0;
        } else {
            amount = 100 * 1.0 + 100 * 2.5 + 300 * 4.0 + (units - 500) * 6.0;
        }
        return amount;
    }

    private double calculateCommercialBill(int units) {
        double amount = 0;
        if (units <= 100) {
            amount = units * 2.0;
        } else if (units <= 200) {
            amount = 100 * 2.0 + (units - 100) * 4.5;
        } else if (units <= 500) {
            amount = 100 * 2.0 + 100 * 4.5 + (units - 200) * 6.0;
        } else {
            amount = 100 * 2.0 + 100 * 4.5 + 300 * 6.0 + (units - 500) * 7.0;
        }
        return amount;
    }

    public void displayBill() {
        System.out.println("\n----- Electricity Bill -----");
        System.out.println("Consumer No: " + consumerNo);
        System.out.println("Consumer Name: " + consumerName);
        System.out.println("Previous Reading: " + previousReading);
        System.out.println("Current Reading: " + currentReading);
        System.out.println("Connection Type: " + connectionType);
        System.out.println("Units Consumed: " + (currentReading - previousReading));
        System.out.printf("Bill Amount: Rs. %.2f\n", billAmount);
        System.out.println("----------------------------");
    }
}

public class ElectricityBillGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Consumer No: ");
        int consumerNo = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Consumer Name: ");
        String consumerName = sc.nextLine();

        System.out.print("Enter Previous Month Reading: ");
        int prevReading = sc.nextInt();

        System.out.print("Enter Current Month Reading: ");
        int currReading = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Type of EB Connection (domestic/commercial): ");
        String connectionType = sc.nextLine();

        ElectricityBill bill = new ElectricityBill(consumerNo, consumerName, prevReading, currReading, connectionType);
        bill.calculateBill();
        bill.displayBill();

        sc.close();
    }
}
