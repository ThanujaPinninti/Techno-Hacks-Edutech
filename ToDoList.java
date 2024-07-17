/*Task 4 : Simple To-Do List
Build a program that allows users to add,remove, and view items on a to-do list.*/
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks; // List to store tasks

    // Constructor to initialize the tasks list
    public ToDoList() {
        tasks = new ArrayList<>();
    }

    // Method to add a task to the list
    public void addTask(String task) {
        tasks.add(task); // Add the task to the list
        System.out.println("Task '" + task + "' added to the list.");
    }

    // Method to remove a task from the list by its number
    public void removeTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) { // Check if the task number is valid
            String removedTask = tasks.remove(taskNumber - 1); // Remove the task from the list
            System.out.println("Task '" + removedTask + "' removed from the list.");
        } else {
            System.out.println("Task number " + taskNumber + " not found in the list.");
        }
    }

    // Method to view all tasks in the list
    public void viewTasks() {
        if (tasks.isEmpty()) { // Check if the list is empty
            System.out.println("The to-do list is empty.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < tasks.size(); i++) { // Iterate through the list and print each task
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Main method to interact with the to-do list
    public static void main(String[] args) {
        ToDoList todoList = new ToDoList(); // Create an instance of ToDoList
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        
        while (true) {
            // Display the menu options
            System.out.println("\nOptions:");
            System.out.println("1. Add a task");
            System.out.println("2. Remove a task");
            System.out.println("3. View tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine(); // Read the user's choice

            switch (choice) {
                case "1":
                    // Add a task
                    System.out.print("Enter the task to add: ");
                    String addTask = scanner.nextLine(); // Read the task to add
                    todoList.addTask(addTask); // Add the task to the list
                    break;
                case "2":
                    // Remove a task
                    System.out.print("Enter the task number to remove: ");
                    int taskNumber = scanner.nextInt(); // Read the task number to remove
                    scanner.nextLine(); // Consume the newline character
                    todoList.removeTask(taskNumber); // Remove the task from the list
                    break;
                case "3":
                    // View all tasks
                    todoList.viewTasks(); // Display the tasks in the list
                    break;
                case "4":
                    // Exit the program
                    System.out.println("Exiting the program.");
                    scanner.close(); // Close the scanner
                    return; // Exit the main method
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}


