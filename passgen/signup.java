package passgen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class signup {
    signup() {
        // create account.....
        System.out.println("\n\tCREATE ACCOUNT\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.next();
        System.out.println("Enter username:");
        String username = sc.next();

        // GENERATING RANDOM PASSWORD !!!
        pass p1 = new pass();
        String pass = p1.gen_pass();

        System.out.println("\nYou password is generated ...");
        System.out.println("Password: " + pass);

        try{
            FileOutputStream fout = new FileOutputStream("src/passgen/db.txt",true);
            PrintStream pout = new PrintStream(fout);
            pout.print(username + " ");
            pout.println(pass);
            System.out.println("\nFile successfully wrote\n\n");
            pout.close();
        }
        catch (IOException e) {
            System.out.println("File not Occur..");
            e.printStackTrace();
        }
    }
}
