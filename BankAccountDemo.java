class BankAccount {
    private int balance = 1000;
    
    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " depositing: " + amount);
        balance += amount;
        System.out.println("Balance after deposit: " + balance);
        notify();
    }
    
    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw: " + amount);
        while (balance < amount) {
            System.out.println("Insufficient balance. Waiting for deposit...");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Balance after withdrawal: " + balance);
    }
}

class DepositThread extends Thread {
    private BankAccount account;
    
    public DepositThread(BankAccount account) {
        this.account = account;
    }
    
    public void run() {
        for (int i = 1; i <= 3; i++) {
            account.deposit(500);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class WithdrawThread extends Thread {
    private BankAccount account;
    
    public WithdrawThread(BankAccount account) {
        this.account = account;
    }
    
    public void run() {
        for (int i = 1; i <= 3; i++) {
            account.withdraw(800);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        
        DepositThread depositThread = new DepositThread(account);
        WithdrawThread withdrawThread = new WithdrawThread(account);
        
        depositThread.setName("Deposit-Thread");
        withdrawThread.setName("Withdraw-Thread");
        
        depositThread.start();
        withdrawThread.start();
    }
}
