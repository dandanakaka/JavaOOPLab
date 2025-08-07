package employee;

// 'AssistantProfessor' inherits from 'Employee'
public class AssistantProfessor extends Employee {

    double bPay; // Basic Pay

    // Constructor for the AssistantProfessor
    public AssistantProfessor(String Emp_name, String Emp_id, String Address, String Mail_id, long Mobile_no, double bPay) {
        // Calling the parent Employee constructor
        super(Emp_name, Emp_id, Address, Mail_id, Mobile_no);
        this.bPay = bPay;
    }

    // Overridden method with calculations specific to an Assistant Professor.
    @Override
    public void paySlip() {
        // Salary components are slightly different from a full Professor
        double DA = 1.00 * bPay; // 100% of Basic Pay
        double HRA = 0.15 * bPay; // 15% of Basic Pay
        double PF = 0.13 * bPay;
        double staffClubFund = 0.002 * bPay;
        double academicAllowance = 0.20 * bPay; // 20% allowance

        // Calculations
        double grossSalary = bPay + DA + HRA + academicAllowance;
        double netSalary = grossSalary - PF - staffClubFund;

        System.out.println("Designation: Assistant Professor");
        System.out.println("Gross Salary: ₹" + grossSalary);
        System.out.println("Net Salary: ₹" + netSalary);
        System.out.println("-----------------------------------------");
    }
}

