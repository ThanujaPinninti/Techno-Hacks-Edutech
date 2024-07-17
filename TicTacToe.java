/*Task 5 : Tic Tac Toe Game
Develop a program that allows two players to play a game of tic tac toe.*/
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    // Define constants for board dimensions and players
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    // Main method to start the game
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            char[][] board = new char[ROWS][COLS];
            initializeBoard(board);
            char currentPlayer = PLAYER_X;
            boolean gameEnded = false;

            // Game loop
            while (!gameEnded) {
                printBoard(board);

                if (currentPlayer == PLAYER_X) {
                    playerMove(board, currentPlayer, scanner);
                } else {
                    computerMove(board, currentPlayer);
                }

                if (hasWinner(board, currentPlayer)) {
                    printBoard(board);
                    if (currentPlayer == PLAYER_X) {
                        System.out.println("*~* Congratulations! You win!");
                    } else {
                        System.out.println("*o* Oh! Computer wins!");
                    }
                    gameEnded = true;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("^_^ The game is a tie!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
                }
            }

            // Ask if the player wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes") || playAgainInput.equals("y");
        } while (playAgain);

        scanner.close();
        System.out.println("Thanks for playing Tic-Tac-Toe!");
    }

    // Method to initialize the board with empty spaces
    private static void initializeBoard(char[][] board) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = EMPTY;
            }
        }
    }

    // Method to print the current state of the board
    private static void printBoard(char[][] board) {
        System.out.println("  0 1 2");
        for (int row = 0; row < ROWS; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < COLS; col++) {
                System.out.print(board[row][col]);
                if (col < COLS - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < ROWS - 1) {
                System.out.println("  -----");
            }
        }
        System.out.println();
    }

    // Method for player's move
    private static void playerMove(char[][] board, char currentPlayer, Scanner scanner) {
        boolean validMove = false;
        while (!validMove) {
            System.out.print("Enter row (0 - 2) and column (0 - 2) separated by space: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == EMPTY) {
                board[row][col] = currentPlayer;
                validMove = true;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    // Method for computer's move (random for now)
    private static void computerMove(char[][] board, char currentPlayer) {
        Random random = new Random();

        // Try to find an empty space adjacent to the player's last move
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == currentPlayer) {
                    // Check adjacent cells for empty spaces
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ni = i + di;
                            int nj = j + dj;
                            if (ni >= 0 && ni < ROWS && nj >= 0 && nj < COLS && board[ni][nj] == EMPTY) {
                                board[ni][nj] = PLAYER_O;
                                System.out.println("Computer chooses row " + ni + " and column \n" + nj);
                                return;
                            }
                        }
                    }
                }
            }
        }

        // If no adjacent space is found, make a random move
        int row, col;
        do {
            row = random.nextInt(ROWS);
            col = random.nextInt(COLS);
        } while (board[row][col] != EMPTY);

        board[row][col] = PLAYER_O;
        System.out.println("Computer chooses row " + row + " and column \n" + col);
    }

    // Method to check if there's a winner
    private static boolean hasWinner(char[][] board, char currentPlayer) {
        // Check rows and columns
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true; // Row win
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true; // Column win
            }
        }

        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true; // Top-left to bottom-right diagonal win
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true; // Top-right to bottom-left diagonal win
        }

        return false;
    }

    // Method to check if the board is full
    private static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == EMPTY) {
                    return false; // Found an empty space
                }
            }
        }
        return true; // Board is full
    }
}
