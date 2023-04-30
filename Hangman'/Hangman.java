import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String guesses[] = {
                "instagram", "facebook", "twitter", "youtube",
                "reddit", "snapchat", "tiktok", "google", "whatsapp", "netflix"};

        boolean check = true;
        while(check){
            System.out.println("Lets Start Playing Hangman ver 0.1");
            int randomNumber = random.nextInt(guesses.length);
            char randomWordToGuess[] = guesses[randomNumber].toCharArray();
            int ammountOfGuesses = randomWordToGuess.length;
            char playerGuess[] = new char[ammountOfGuesses];

            for(int i=0; i<playerGuess.length; i++){
                playerGuess[i] =  '_';
            }

            boolean wordIsGuessed = false;
            int tries = 0;

            while(!wordIsGuessed && tries != ammountOfGuesses){
                System.out.println("Current Guesses: ");
                print(playerGuess);
                System.out.printf("You have %d ammount of tries left.\n", ammountOfGuesses-tries);
                System.out.println("Enter a single character: ");
                char input = scanner.nextLine().charAt(0);
                tries++;

                if(input == '-'){
                    wordIsGuessed = true;
                    check = false;
                } else{
                    for(int i=0; i<randomWordToGuess.length; i++){
                        if(randomWordToGuess[i] == input){
                            playerGuess[i] = input;
                        }
                    }

                    if(isTheWordGuessed(playerGuess)){
                        wordIsGuessed = true;
                        System.out.println("Congratulations");
                    }
                }
            }
            if(!wordIsGuessed){
                System.out.println("You ran out of guesses.");
            }

            System.out.println("Would you like to play again? (yes/no) ");
            String choice = scanner.nextLine();
            if(choice.equals("no")){
                check = false;
            }

        }

        System.out.println("Game Over!");
    }

    public static void print(char array[]){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean isTheWordGuessed(char[] array){
        boolean condition = true;
        for(int i=0; i<array.length; i++){
            if(array[i] == '_'){
                condition = false;
            }
        }
        return condition;
    }
}
