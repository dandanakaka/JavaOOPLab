package employee;

public class Programmer extends Employee {
    double bPay;

    public Programmer(String name, int id, String addr, String mail, long mobile, double basicPay) {
        super(name, id, addr, mail, mobile);
        this.bPay = basicPay;
    }
    
    // Getter for basic pay
    public double getBPay() {
        return bPay;
    }

    @Override
    public String getPaySlip() {
        double da = 0.97 * this.bPay;
        double hra = 0.10 * this.bPay;
        double pf = 0.12 * this.bPay;
        double clubFund = 0.001 * this.bPay;
        double grossSalary = this.bPay + da + hra;
        double netSalary = grossSalary - pf - clubFund;
        
        // Build the string instead of printing
        String slip = "Designation: Programmer\n";
        slip += "Basic Pay: $" + String.format("%,.2f", this.bPay) + "\n";
        slip += "Gross Salary: $" + String.format("%,.2f", grossSalary) + "\n";
        slip += "Net Salary: $" + String.format("%,.2f", netSalary) + "\n";
        
        return slip;
    }
}