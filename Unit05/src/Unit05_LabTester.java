/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2017
 * Instructor: Dave Busse
 * Description: Unit 05 Lab
 * Date: 10/24/2017
 * @author Boobin Choi
 * @version 1.0
 *
 * By turning in this code, I Pledge:
 *  1. That I have completed the programming assignment independently.
 *  2. I have not copied the code from a student or any source.
 *  3. I have not given my code to any student.
 *
 */

public class Unit05_LabTester {
    
    public static void main(String[] args) {
        
        LoopRunner loopRunner1 = new LoopRunner(5, "A");
        LoopRunner loopRunner2 = new LoopRunner(5, "B");
        LoopRunner loopRunner3 = new LoopRunner(5, "C");
        LoopRunner loopRunner4 = new LoopRunner(5, "D");
        
        Thread thread1 = new Thread(loopRunner1);
        Thread thread2 = new Thread(loopRunner2);
        Thread thread3 = new Thread(loopRunner3);
        Thread thread4 = new Thread(loopRunner4);
        
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        
        System.out.println("Main Thread here");
    }
}
