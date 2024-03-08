package Recursion_and_backtracking;

public class Nqueenproblem {
    public static int Queen(boolean[][] board,int row){
        if (row==board.length){
            printBoard(board);
            System.out.println();
            return 1;
        }
        int count=0;
        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board,row,col)){
                board[row][col]=true;
                count+=Queen(board,row+1);
                board[row][col]=false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i <row ; i++) {
            if (board[i][col]){
                return false;
            }
        }
        int maxLeft = Math.min(row,col);
        for (int i = 1; i <=maxLeft ; i++) {
            if (board[row-i][col-i])
                return false;
        }
        int maxRight = Math.min(row, board.length-1-col);
        for (int i = 1; i <= maxRight ; i++) {
            if (board[row-i][col+i])
                return false;
        }
        return true;
    }

    private static void printBoard(boolean[][] board) {
        for (boolean[] row : board){
            for(boolean element : row){
                if (element){
                    System.out.print("Q ");
                }
                else
                    System.out.printf("X ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        System.out.println(Queen(board,0));
    }
}
