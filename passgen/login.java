package passgen;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class login {
    login(){
        check_login();
    }
    boolean check_login(){
            boolean login = false;
            Scanner sc = new Scanner(System.in);

            System.out.println("\tLOGIN\nEnter userID: ");
            String uid = sc.nextLine();
            System.out.println("Enter pass: ");
            String pass = sc.nextLine();

            try{
                FileReader read = new FileReader("src/passgen/db.txt");
                Scanner s = new Scanner(read);
                while (s.hasNext())
                {
                    if(uid.equals(s.next()) && pass.equals(s.next())) {
                        System.out.println("login successfully..");
                        login = true;
                        break;
                    }
                }
                if(login == false)
                {
                    System.out.println("Invalid !!");
                }
            }
            catch (Exception e){
                System.out.println("login error");
                e.printStackTrace();
            }
        return login;
    }
}

