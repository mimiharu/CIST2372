/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2017
 * Instructor: Dave Busse
 * Description: Unit 02 Lab
 * Date: 09/13/2017
 * @author Boobin Choi
 * @version 1.0
 *
 * By turning in this code, I Pledge:
 *  1. That I have completed the programming assignment independently.
 *  2. I have not copied the code from a student or any source.
 *  3. I have not given my code to any student.
 *
 */

public class Account {
    
    /** Properties */
    private int acctNo;
    private String owner;
    private int balance;
    
    /** default constructor */
    public Account() {
        acctNo = 0;
        owner = "";
        balance = 0;
    }
    
    // Constructor with 3 properties //
    public Account(int no, String own, int bal) {
        this.acctNo = no;
        this.owner = own;
        this.balance = bal;
    }
    
    // AcctNo get method() //
    public int getAcctNo() {
        return acctNo;
    }

    // AcctNo set method() //
    public void setAcctNo(int no) {
        this.acctNo = no;
    }

    // Owner get method() //
    public String getOwner() {
        return owner;
    }

    //Owner set method() //
    public void setOwner(String own) {
        this.owner = own;
    }
    
    // Balance get method() //
    public int getBalance() {
        return balance;
    }

    // Balance set method() //
    public void setBalance(int amt) throws InsufficientFundsException {
        if (amt < 0) {
            throw new InsufficientFundsException("Error : Overdrawn");
        }
        {
            this.balance = amt;
        }
    }
    
    // Deposit method() //
    public void deposit(int amt) {
        this.balance += amt;
    }
    
    // Withdraw method() //
    public void withdraw(int amt) throws InsufficientFundsException {
        if (this.balance < amt) {
            throw new InsufficientFundsException("Error : Overdrawn");
        }
        {
            this.balance -= amt;
        }
    }

}
