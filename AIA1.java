import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AIA1 {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);

        
        board[0][0] = 'X';
        board[0][1] = 'O';
        board[1][1] = 'X';
        board[1][2] = 'O';

        System.out.println("Initial board:");
        displayBoard(board);

        List<char[][]> possibleBoards = generatePossibleBoards(board);

        System.out.println("Possible Boards After Each Move:");
        for (int i = 0; i < possibleBoards.size(); i++) {
            System.out.println("Move " + (i + 1) + ":");
            displayBoard(possibleBoards.get(i));
            System.out.println();
        }
    }

    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void displayBoard(char[][] board) {
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n");
        }
    }

    public static List<char[][]> generatePossibleBoards(char[][] board) {
        List<char[][]> possibleBoards = new ArrayList<>();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    char[][] tempBoard = new char[3][3];
                    copyBoard(board, tempBoard);
                    tempBoard[row][col] = 'X'; 
                    possibleBoards.add(tempBoard);
                }
            }
        }

        return possibleBoards;
    }

    public static void copyBoard(char[][] source, char[][] destination) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                destination[i][j] = source[i][j];
            }
        }
    }
}

