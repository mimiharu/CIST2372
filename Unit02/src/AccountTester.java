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

public class AccountTester {
    
    // main () //
    public static void main(String args[]) {
        
        /** Setting Account */
        /** Account number: 1234, Owner: Boobin, Balance: 200 */
        Account a = new Account(1234, "Boobin", 200);
        System.out.println("Account object created with balance of " +a.getBalance());
        
        /** withdrawing 100 */
        int withdraw100 = 100;
        System.out.println("Withdrawing " +withdraw100);
        try {
            a.withdraw(withdraw100);
        } catch (InsufficientFundsException e) 
        {
            System.out.println(e.getMessage());            
        }
        System.out.println("Balance after withdrawal of " +withdraw100+ " is: " +a.getBalance());
        
        /** depositing 50 */
        int deposit50 = 50;
        a.deposit(deposit50);
        System.out.println("Depositing " +deposit50);
        System.out.println("Balance after deposit of " +deposit50+ " is: " +a.getBalance());
        
        /** withdrawing 50 */
        int withdraw500 = 500;
        System.out.println("Withdrawing " +withdraw500);
        try {
            a.withdraw(withdraw500);
        }catch(InsufficientFundsException e)
        {
            System.out.println(e.getMessage());
            System.out.println("          Balance is: " +a.getBalance());
        }
        
        /** setting Balance -100 */
        int negativeBalance = -100;
        System.out.println("Setting Balance to " +negativeBalance);
        try {
            a.setBalance(negativeBalance);
        }catch(InsufficientFundsException e)
        {
            System.out.println(e.getMessage());
            System.out.println("           Balance is: " +a.getBalance());
        }
    }
}
