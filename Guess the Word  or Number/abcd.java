import java.util.*;
public class abcd {

    static  String []Movies = {"race","don","gabbar","special 26"};

    static String gen_word(){
        Random random =  new Random();
        int index = random.nextInt(5);
        return Movies[index];
    }

    static boolean check = false;
    static void guessWord(){
        Scanner sc = new Scanner(System.in);
        String movie = gen_word();
        System.out.println("Guess the movie :");
        System.out.println("It contains " + movie.length() + " words \n\n");

        String guess = sc.nextLine();

        if(guess.equalsIgnoreCase(movie)){
            System.out.println("Correct !!! You Won ....");
        }
        else {
            System.out.println("You Lost !!! \nDo you want to play again ? (Y or y for yes   other to exit)\n");
            String ch ;
            ch = sc.next();

            int i = 0;
            if (ch.equalsIgnoreCase("Y"))
                check = true;
            else {
                check = false;
                System.out.println("Game Over ...");
            }
            if (check == true)
            {
                guessWord();
            }
        }
    }

}
