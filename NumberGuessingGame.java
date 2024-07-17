/*Task 2 : Number Guessing game
Create a program that asks the user to guess a number between 1 and 100. The program should then give hints to the user until they guess the correct number.*/
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game *.*");
        System.out.println("Guess a number between 1 and 100:");

        do {
            System.out.print("Enter your guess number : ");
            guess = scanner.nextInt();
            attempts++;

            if (guess == secretNumber) {
                System.out.println("  ^--^");
                System.out.println(" (*.*)");
                System.out.println("  === ");
                System.out.println("#Congratulations! You guessed the correct number in " + attempts + " attempts.");
            } else if (guess < secretNumber) {
                System.out.println("Try a higher number!.");
            } else {
                System.out.println("Try a lower number!.");
            }
        } while (guess != secretNumber);

        scanner.close();
    }
}
