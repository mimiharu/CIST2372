/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2017
 * Instructor: Dave Busse
 * Description: Unit 01 Lab
 * Date: 09/01/2017
 * @author Boobin Choi
 * @version 1.0
 *
 * By turning in this code, I Pledge:
 *  1. That I have completed the programming assignment independently.
 *  2. I have not copied the code from a student or any source.
 *  3. I have not given my code to any student.
 *
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Unit01_Prog {        
    
    public static void main(String[] args) {
        
        Scanner inputs = new Scanner(System.in);
        ArrayList <Integer> nums = new ArrayList<Integer>();
        
        System.out.println("Enter a number(-1 to end): ");
        
        Integer input = inputs.nextInt();
        while (input != -1) {
            nums.add(input);
            input = inputs.nextInt();
        }
        Collections.sort (nums);
        System.out.println("Here is the list of numbers ");
        for (Integer n : nums) {
            System.out.println(n); 
        }
        System.out.println("Here is the minimum value :" + (Collections.min(nums)));
        System.out.println("Here is the maximum value :" + (Collections.max(nums)));               
    }
}
