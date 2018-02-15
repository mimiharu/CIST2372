/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2017
 * Instructor: Dave Busse
 * Description: Unit 04 Lab
 * Date: 10/05/2017
 * @author Boobin Choi
 * @version 1.0
 *
 * By turning in this code, I Pledge:
 *  1. That I have completed the programming assignment independently.
 *  2. I have not copied the code from a student or any source.
 *  3. I have not given my code to any student.
 *
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Unit04Prog01 {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        java.io.File file = new java.io.File("myscores.txt");
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        
        output.print("200 ");
        output.print("300 ");
        output.print("500 ");
        output.print("100 ");
        output.print("100 ");
        
        output.close();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the name of the scores file: ");
        
        String fileName = sc.nextLine();
        sc.close();
        
        try {
            sc = new Scanner(new FileReader(fileName));
            
            int total = 0;
            while (sc.hasNext()) {
                total += sc.nextInt();
            }
            System.out.println("Total is " +total);
        }
        catch (FileNotFoundException e) {
            System.out.println("Sorry, file " +fileName+ " not found.");
        } finally {
            sc.close();
        }
          
    }
}
