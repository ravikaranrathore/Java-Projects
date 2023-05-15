package passgen;
import java.util.Scanner;

import static java.lang.System.exit;

public class passmain {
    public static void main(String[] args) {

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n\tWELCOME TO LOGIN PAGE\n\n1. Login\n2. Register\n3. Exit\n");
            int input = sc.nextInt();

            switch (input) {
                case 1: {
                    new login();
                    break;
                }
                case 2: {
                    new signup();
                    break;
                }
                case 3: {
                    System.out.println("\n\n\tPROGRAM TERMINATED !!!");
                    exit(0);
                }
                default: {
                    System.out.println("\n\nInvalid Selection\n Try again !!!");
                }
            }
        }
    }
}