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


public class NameLookupServer {
    
    ServerSocket serverSocket;
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    
    int[] studentID = {7000123, 7000453, 7000677, 7000799, 7000388};
    String[] studentNames = {"John Doe","Mary Smith","G.Washington","B.Franklin","B.Ford"};
    
    private void Server() {
        
        try {
            serverSocket = new ServerSocket(8080);
            socket = serverSocket.accept();
            
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(0);
        }
        
        try {
            while(true) {
                String names = "";
                
                int id = dataInputStream.readInt();
                System.out.println(id);
                for (int i=0; i<studentID.length; i++) {
                    if(studentID[i] == id) {
                        names = studentNames[i];
                        dataOutputStream.writeUTF(names);
                        System.out.println("Names sent: ");
                        break;
                    }
                }
                if (names.equals("")) {
                    dataOutputStream.writeUTF("Not Found");
                    System.out.println("Sent: Not Found");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        NameLookupServer server = new NameLookupServer();
        server.Server();
    }
    
}
