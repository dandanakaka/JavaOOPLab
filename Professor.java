package employee;

// 'Professor' also inherits from 'Employee'
public class Professor extends Employee {

    double bPay; // Basic Pay

    // Constructor for the Professor
    public Professor(String Emp_name, String Emp_id, String Address, String Mail_id, long Mobile_no, double bPay) {
        // Calling the parent Employee constructor
        super(Emp_name, Emp_id, Address, Mail_id, Mobile_no);
        this.bPay = bPay;
    }

    // Overridden method with different calculations for a Professor.
    @Override
    public void paySlip() {
        // Different salary components for a Professor
        double DA = 1.10 * bPay; // 110% of Basic Pay
        double HRA = 0.20 * bPay; // 20% of Basic Pay
        double PF = 0.15 * bPay;
        double staffClubFund = 0.002 * bPay;
        double academicAllowance = 0.30 * bPay; // Special allowance

        // Calculations
        double grossSalary = bPay + DA + HRA + academicAllowance;
        double netSalary = grossSalary - PF - staffClubFund;

        System.out.println("Designation: Professor");
        System.out.println("Gross Salary: ₹" + grossSalary);
        System.out.println("Net Salary: ₹" + netSalary);
        System.out.println("-----------------------------------------");
    }
}
