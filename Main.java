package employee;


public class AssistantProfessor extends Employee {

    double bPay; 

   
    public AssistantProfessor(String Emp_name, String Emp_id, String Address, String Mail_id, long Mobile_no, double bPay) {
        
        super(Emp_name, Emp_id, Address, Mail_id, Mobile_no);
        this.bPay = bPay;
    }

   
    @Override
    public void paySlip() {
        
        double DA = 1.00 * bPay; 
        double HRA = 0.15 * bPay; 
        double PF = 0.13 * bPay;
        double staffClubFund = 0.002 * bPay;
        double academicAllowance = 0.20 * bPay; 

        // Calculations
        double grossSalary = bPay + DA + HRA + academicAllowance;
        double netSalary = grossSalary - PF - staffClubFund;

        System.out.println("Designation: Assistant Professor");
        System.out.println("Gross Salary: ₹" + grossSalary);
        System.out.println("Net Salary: ₹" + netSalary);
        System.out.println("-----------------------------------------");
    }
}

