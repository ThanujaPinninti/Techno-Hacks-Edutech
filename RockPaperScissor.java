/*Task 3 : Rock, paper, scissors game
Create a program that allows the user to play the classic game of rock, paper, scissors against the computer. */
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissor {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        // Create a Random object to generate random numbers
        Random random = new Random();

        // Array to store the possible choices
        String[] options = {"Rock", "Paper", "Scissors"};
        // Variables to store the player's choice and the computer's choice
        String playerChoice, computerChoice;
        // Variable to store the index of the computer's choice in the options array
        int computerChoiceIndex;

        // Print welcome message and instructions
        System.out.println("Welcome to Rock, Paper, Scissors Game!");
        System.out.println("Enter Rock, Paper, or Scissors to play. Type 'Exit' to quit the game.");

        // Infinite loop to keep the game running until the player decides to quit
        while (true) {
            // Prompt the player to enter their choice
            System.out.print("Your choice: ");
            playerChoice = scanner.nextLine().trim();

            // Check if the player wants to exit the game
            if (playerChoice.equalsIgnoreCase("Exit")) {
                System.out.println("Thanks for playing! Goodbye.");
                break; // Exit the loop and end the game
            }

            // Generate a random index to choose the computer's move
            computerChoiceIndex = random.nextInt(3);
            computerChoice = options[computerChoiceIndex];

            // Print the computer's choice
            System.out.println("Computer choice: " + computerChoice);

            // Check if it's a tie
            if (playerChoice.equalsIgnoreCase(computerChoice)) {
                System.out.println("It's a tie!");
            } 
            // Check if the player choose Rock
            else if (playerChoice.equalsIgnoreCase("Rock")) {
                // Determine the outcome when player chose Rock
                if (computerChoice.equals("Scissors")) {
                    System.out.println("You win! Rock crushes Scissors.");
                } else {
                    System.out.println("You lose! Paper covers Rock.");
                }
            } 
            // Check if the player choose Paper
            else if (playerChoice.equalsIgnoreCase("Paper")) {
                // Determine the outcome when player chose Paper
                if (computerChoice.equals("Rock")) {
                    System.out.println("You win! Paper covers Rock.");
                } else {
                    System.out.println("You lose! Scissors cut Paper.");
                }
            } 
            // Check if the player choose Scissors
            else if (playerChoice.equalsIgnoreCase("Scissors")) {
                // Determine the outcome when player choose Scissors
                if (computerChoice.equals("Paper")) {
                    System.out.println("You win! Scissors cut Paper.");
                } else {
                    System.out.println("You lose! Rock crushes Scissors.");
                }
            } 
            // Handle invalid input
            else {
                System.out.println("Invalid choice. Please enter Rock, Paper, or Scissors.");
            }

            // Print a blank line for better readability
            System.out.println();
        }

        // Close the scanner to free up resources
        scanner.close();
    }
}