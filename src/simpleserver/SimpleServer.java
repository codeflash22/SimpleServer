package simpleserver;

/**
 *
 * @author Faisal
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class SimpleServer {

    public static void main(String[] args) throws IOException {
        ServerSocket sS = new ServerSocket(1000);
        Socket sock = sS.accept();
        
        DataInputStream dis = new DataInputStream(sock.getInputStream());
        DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
        
        Scanner input = new Scanner(System.in);
        
        while(!input.nextLine().equals("bye")){
            dos.writeUTF(input.nextLine());
            String msg = new String(dis.readUTF());
            System.out.println(msg);            
        }
        
        dis.close();
        dos.close();
        sock.close();
    }
    
}
