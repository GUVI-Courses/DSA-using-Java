package guvidsa;

public class Nqueens {

	 // Function to check if a queen can be placed on board[row][col]
    private static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check this row on the left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Recursive utility function to solve N-Queens problem
    private static boolean solveNQueensUtil(int[][] board, int col, int n) {
        // If all queens are placed, return true
        if (col >= n) {
            return true;
        }

        // Try placing a queen in all rows one by one
        for (int i = 0; i < n; i++) {
            // Check if the queen can be placed on board[i][col]
            if (isSafe(board, i, col, n)) {
                // Place the queen
                board[i][col] = 1;

                // Recur to place the rest of the queens
                if (solveNQueensUtil(board, col + 1, n)) {
                    return true;
                }

                // If placing the queen in board[i][col] doesn't lead to a solution,
                // then backtrack and remove the queen from board[i][col]
                board[i][col] = 0;
            }
        }

        // If the queen cannot be placed in any row in this column, return false
        return false;
    }

    // Function to solve the N-Queens problem
    public static boolean solveNQueens(int n) {
        int[][] board = new int[n][n];

        // Initialize the board with 0s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }

        // Start solving the N-Queens problem from the first column
        if (!solveNQueensUtil(board, 0, n)) {
            System.out.println("Solution does not exist");
            return false;
        }

        // Print the solution
        printSolution(board, n);
        return true;
    }

    // Function to print the board
    private static void printSolution(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int n = 8; // You can change this to the desired number of queens
	     solveNQueens(n);

	}

}
