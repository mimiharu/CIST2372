/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2017
 * Instructor: Dave Busse
 * Description: Unit 07 Lab
 * Date: 12/01/2017
 * @author Boobin Choi
 * @version 1.0
 *
 * By turning in this code, I Pledge:
 *  1. That I have completed the programming assignment independently.
 *  2. I have not copied the code from a student or any source.
 *  3. I have not given my code to any student.
 *
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class NameLookupClient {
    
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    
    private void Client() {
        
        try {
            socket = new Socket("localhost", 8080);
            
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }        

        try {
            while (true) {
                System.out.println("Enter a student ID number: ");
                Scanner scanner = new Scanner(System.in);               
                int id = scanner.nextInt();
                dataOutputStream.writeInt(id);
                               
                String names = dataInputStream.readUTF();
                System.out.println("Student's name of ID " +id+ " is : " +names);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        NameLookupClient client = new NameLookupClient();
        client.Client();
    }
}
