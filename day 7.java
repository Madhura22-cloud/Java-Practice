class BankAccount {
    String accountNumber;
    String accountHolderName;
    double balance;

    
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. New balance: " + balance);
    }

    
    public void withdraw(double amount) {
        System.out.println("Withdrawal not supported directly from BankAccount");
    }

    
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }
}


class SavingsAccount extends BankAccount {
    private static final double MIN_BALANCE = 500.0;  /

    
    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance);
    }

    
    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance! Cannot withdraw beyond the minimum balance of " + MIN_BALANCE);
        }
    }
}


class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    
    public CurrentAccount(String accountNumber, String accountHolderName, double initialBalance, double overdraftLimit) {
        super(accountNumber, accountHolderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    
    @Override
    public void withdraw(double amount) {
        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds! Overdraft limit exceeded.");
        }
    }
}


public class BankAccountManagement {
    public static void main(String[] args) {
        
        SavingsAccount savingsAccount = new SavingsAccount("12345", "Madhura Pawar", 1000.0);

       
        CurrentAccount currentAccount = new CurrentAccount("67890", "Nutan pawar", 2000.0, 500.0);

        
        System.out.println("Savings Account Details:");
        savingsAccount.displayAccountInfo();
        System.out.println("\nCurrent Account Details:");
        currentAccount.displayAccountInfo();

        
        System.out.println("\nTransactions for Savings Account:");
        savingsAccount.deposit(300); 
        savingsAccount.withdraw(600); 
        savingsAccount.withdraw(900); 
        System.out.println("\nTransactions for Current Account:");
        currentAccount.deposit(500);  
        currentAccount.withdraw(2500);
        currentAccount.withdraw(3000); 
}
