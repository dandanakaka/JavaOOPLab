package employee;

// 'AssociateProfessor' inherits from 'Employee'
public class AssociateProfessor extends Employee {

    double bPay; // Basic Pay

    // Constructor for the AssociateProfessor
    public AssociateProfessor(String Emp_name, String Emp_id, String Address, String Mail_id, long Mobile_no, double bPay) {
        // Calling the parent Employee constructor
        super(Emp_name, Emp_id, Address, Mail_id, Mobile_no);
        this.bPay = bPay;
    }

    // Overridden method with calculations specific to an Associate Professor.
    @Override
    public void paySlip() {
        // Allowances are higher than an Assistant Professor
        double DA = 1.05 * bPay; // 105% of Basic Pay
        double HRA = 0.18 * bPay; // 18% of Basic Pay
        double PF = 0.14 * bPay;
        double staffClubFund = 0.002 * bPay;
        double academicAllowance = 0.25 * bPay; // 25% allowance

        // Calculations
        double grossSalary = bPay + DA + HRA + academicAllowance;
        double netSalary = grossSalary - PF - staffClubFund;

        System.out.println("Designation: Associate Professor");
        System.out.println("Gross Salary: ₹" + grossSalary);
        System.out.println("Net Salary: ₹" + netSalary);
        System.out.println("-----------------------------------------");
    }
}

