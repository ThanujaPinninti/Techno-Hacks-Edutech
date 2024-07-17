/*Task 1 : Calculator
Create a basic calculator that can perform basic arithmetic operations such as addition, subtraction, multiplication, and division. */
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Basic Calculator");
        System.out.println("Enter two numbers:");

        // Input first number
        System.out.print("Number 1: ");
        double num1 = scanner.nextDouble();

        // Input second number
        System.out.print("Number 2: ");
        double num2 = scanner.nextDouble();

        // Choose operation
        System.out.println("Choose operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.print("Enter your choice (+, -, *, /): ");
        String operation = scanner.next();

        // Perform operation based on operation
        double result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                System.out.println("Sum: " + result);
                break;
            case "-":
                result = num1 - num2;
                System.out.println("Difference: " + result);
                break;
            case "*":
                result = num1 * num2;
                System.out.println("Product: " + result);
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("Quotient: " + result);
                } else {
                    System.out.println("Division by zero is not possible.");
                }
                break;
            default:
                System.out.println("Invalid operation!");
        }

        scanner.close();
    }
}
