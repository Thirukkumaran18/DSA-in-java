import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main{
    public static void main(String[] args){
        int n = 4 ;
        System.out.println(solveNQueens(n));
    }
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        List<List<String>> mainList = new ArrayList<>();
        helper(0, board, n, mainList);
        return mainList;
    }

    public static void helper(int rowIndex, char[][] board, int n, List<List<String>> mainList) {
        if (rowIndex == n) {
            List<String> list = new ArrayList<>();
            for (char[] r : board) {
                list.add(new String(r));
            }
            mainList.add(list);
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (isSafe(board, rowIndex, colIndex, n)) {
                board[rowIndex][colIndex] = 'Q';           
                helper(rowIndex + 1, board, n, mainList);  
                board[rowIndex][colIndex] = '.';           
            }
        }

        /* 
        Another approach : 
        note : function paramter also check once , here passing both rowIndex and colIndex
        if (isSafe(board, rowIndex, colIndex, n)) {
            board[rowIndex][colIndex] = 'Q';
            helper(rowIndex + 1, 0, board, n, mainList); // move to next row
            board[rowIndex][colIndex] = '.'; // backtrack
        }
        helper(rowIndex, colIndex + 1, board, n, mainList);
        */
    }

    public static boolean isSafe(char[][] board, int rowIndex, int colIndex, int n) {
        // Check column
        for (int i = 0; i < rowIndex; i++) {
            if (board[i][colIndex] == 'Q') return false;
        }

        // Upper left diagonal
        for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Upper right diagonal
        for (int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}