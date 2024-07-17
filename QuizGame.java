/*Task 6 : Quiz Game
Build a program that displays a series of multiple-choice questions and lets the user select an answer.*/
import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        // Define questions, choices, and answers
        String[][] questions = {
            {"What is the primary focus of TechnoHacks EduTech?", "A) Financial services", "B) Educational technology", "C) Real estate", "D) Healthcare"},
            {"Which type of courses does TechnoHacks EduTech mainly offer?", "A) Culinary arts", "B) Software development and IT", "C) Automotive engineering", "D) Fashion design"},
            {"What is a key feature of TechnoHacks EduTech's platform?", "A) Live interactive classes", "B) Physical textbooks", "C) In-person tutoring", "D) Sports coaching"},
            {"TechnoHacks EduTech is best known for its training in:", "A) Data Science", "B) Architecture", "C) Civil Engineering", "D) Marine Biology"},
            {"What type of learning does TechnoHacks EduTech promote?", "A) Passive learning", "B) Interactive and hands-on learning", "C) Rote memorization", "D) Unstructured learning"}
        };

        char[] answers = {'B', 'B', 'A', 'A', 'B'}; // Correct answers

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        // Loop through each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i][0]);
            for (int j = 1; j <= 4; j++) {
                System.out.println(questions[i][j]);
            }

            System.out.print("Your answer (A, B, C, or D): ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);

            if (userAnswer == answers[i]) {
                score++;
                System.out.println("*~* Correct! \n");
            } else {
                System.out.println("*o* Wrong! The correct answer is " + answers[i] + "\n");
            }
        }

        // Display the final score
        System.out.println("*_* You got " + score + " out of " + questions.length + " questions correct.");

        scanner.close();
    }
}
