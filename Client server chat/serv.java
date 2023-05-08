import java.io.*;
import java.net.*;
import java.util.Scanner;

public class serv {
    public static void main(String[] args) {
        try {

                ServerSocket ss = new ServerSocket(5000);            // localhost:5000 Server address, used to connect to a port no.

                System.out.println(InetAddress.getLocalHost());
                System.out.println(InetAddress.getLocalHost().getHostName());

                while(true) {
                Scanner sc = new Scanner(System.in);                            // to read data from console

                Socket s = ss.accept();                                         // socket class object
                System.out.println("\nConnection Reset Successfully!\n");

                Scanner read = new Scanner(s.getInputStream());                 // to read data from socket class from client
                PrintStream write = new PrintStream(s.getOutputStream());       // to write(transmit) data from server to socket(client)

                    while (true) {
                        // System.out.println("C: ");
                        String msgread = read.nextLine();
                        System.out.println(msgread);

                        if (msgread.contains("STOP")) {
                            System.out.println("Connection Terminated !\n");
                            break;
                        }

                        //System.out.println("S: ");
                        String sendmsg = sc.nextLine();
                        sendmsg = "Server: " + sendmsg;
                        write.println(sendmsg);
                    }
                    write.flush();
                    s.close();
                }

        } catch (Exception e) {
        }
    }
}