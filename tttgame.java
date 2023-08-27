import java.util.Scanner;
public class tttgame {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    public static void main(String[] args) {
        initializeBoard();
        boolean gameFinished = false;
        while (!gameFinished) {
            printBoard();
            int row, col;
            do {
                System.out.println("Player " + currentPlayer + ", enter your move (row [0-2] and column [0-2]):");
                Scanner scanner = new Scanner(System.in);
                row = scanner.nextInt();
                col = scanner.nextInt();
            } while (!isValidMove(row, col));
            
            makeMove(row, col);
            gameFinished = checkWin() || isBoardFull();
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        printBoard();
        if (checkWin()) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    private static void printBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid move. Row and column must be between 0 and 2.");
            return false;
        }
        if (board[row][col] != '-') {
            System.out.println("Invalid move. Cell is already occupied.");
            return false;
        }
        return true;
    }
    private static void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }
    private static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true; 
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true; 
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true; 
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true; 
        }
        return false;
    }
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}

