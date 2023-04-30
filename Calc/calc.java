package JavaClasses.src;

import java.util.Scanner;

public class calc{
    public static void main(String[] args) {

        int operation;
        Double result;

        Scanner input = new Scanner(System.in);

        System.out.println("What to you need:\n1. Sin θ \n2. Cos θ \n3. Tan θ ");
        operation = input.nextInt();

        double number = 0;

        if(operation >= 1 && operation <= 3) {
            System.out.println("Enter θ  angle in degrees: \n");

            number = input.nextDouble();
            number = Math.toRadians(number);
        }


        switch (operation) {
            case '1' -> {
                result = Math.sin(number);
                System.out.println("Sin θ : " + result);
                break;
            }
            case '2' -> {
                result = Math.cos(number);
                System.out.println("Cos θ : " + result);
                break;
            }
            case '3' -> {
                result = Math.tan(number);
                System.out.println("Tan θ : " + result);
                break;
            }
            default ->
            { System.out.println("Invalid !!!");}
        }

    }
}
