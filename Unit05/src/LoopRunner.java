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

public class LoopRunner implements Runnable {
    
    private int numOfTimes;
    private String charToPrint;
    
    public LoopRunner(int numberOfTimes, String charToPrint) {
        this.numOfTimes = numberOfTimes;
        this.charToPrint = charToPrint;
    }
    
    @Override
    public void run() {
        for (int n=0; n<numOfTimes; n++) {
            System.out.println(charToPrint);
        }
    }
}
