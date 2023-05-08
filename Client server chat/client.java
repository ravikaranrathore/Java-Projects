import java.net.*;
import java.io.*;
import java.util.Scanner;
public class client {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);                // to read data from console

            System.out.print("input 'START' and 'STOP' Commands: ");
            String a = sc.nextLine();

            if(a.equalsIgnoreCase("START")) {
                Socket s = new Socket("localhost", 5000);
                System.out.println("\nSend message to the Server --- ");
                Scanner read = new Scanner(s.getInputStream());     // to read data from serversocket
                PrintStream write = new PrintStream(s.getOutputStream());       // to send data to server

                while (true) {
                    //System.out.println(" \n\nStart Messaging - \n");
                    String sendmsg = sc.nextLine();
                    sendmsg = "Client 1: " + sendmsg;
                    write.println(sendmsg);

                    if(sendmsg.contains("STOP")) {
                        System.out.println("\nConnection Terminated !\n");
                        break;
                    }

                    String msgread = read.nextLine();
                    //System.out.println("S: ");
                    System.out.println(msgread);
                    write.flush();
                }
            }
            else if (a.equalsIgnoreCase("STOP")) {
                System.out.println("\nConnection Terminated !\n");
            }
        }catch (Exception e){
        }
    }
}
