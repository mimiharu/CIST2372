
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

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




public class Unit04Prog02 {
    
    public static void main(String[] args) {
        
        int i;
        
        Random r = new Random();
        
        try {
            FileOutputStream output = new FileOutputStream("CreateData.dat");
            
            for (i=1; i<=100; i++) {
                output.write(r.nextInt());
            }
            
            output.flush();
            output.close();
            
            System.out.println("written random integers to file are : ");
            
            FileInputStream input = new FileInputStream("CreateData.dat");
            
            while((i = input.read())!=-1) {
                System.out.println(i);
            }
            
            input.close();
            
        } catch(IOException e) {
            e.printStackTrace();
        }       
    }    
}
