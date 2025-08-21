package employee;

public abstract class Employee {
    String Emp_name;
    int Emp_id;
    String Address;
    String Mail_id;
    long Mobile_no;

    public Employee(String name, int id, String addr, String mail, long mobile) {
        this.Emp_name = name;
        this.Emp_id = id;
        this.Address = addr;
        this.Mail_id = mail;
        this.Mobile_no = mobile;
    }

    // Getter methods to access private data
    public String getEmp_name() { return Emp_name; }
    public int getEmp_id() { return Emp_id; }
    public String getAddress() { return Address; }
    public String getMail_id() { return Mail_id; }
    public long getMobile_no() { return Mobile_no; }

    // This method will now return the payslip details as a string
    public abstract String getPaySlip();
}