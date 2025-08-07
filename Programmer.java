package employee;


public class Programmer extends Employee {
    
    double bPay; // Basic Pay, specific to Programmer

    
    public Programmer(String Emp_name, String Emp_id, String Address, String Mail_id, long Mobile_no, double bPay) {
     
        super(Emp_name, Emp_id, Address, Mail_id, Mobile_no);
        this.bPay = bPay;
    }

  
    @Override
    public void paySlip() {
  
        double DA = 0.97 * bPay; // Dearness Allowance
        double HRA = 0.10 * bPay; // House Rent Allowance
        double PF = 0.12 * bPay;  // Provident Fund
        double staffClubFund = 0.001 * bPay;


        double grossSalary = bPay + DA + HRA;
        double netSalary = grossSalary - PF - staffClubFund;

        System.out.println("Designation: Programmer");
        System.out.println("Gross Salary: ₹" + grossSalary);
        System.out.println("Net Salary: ₹" + netSalary);
        System.out.println("-----------------------------------------");
    }
}
