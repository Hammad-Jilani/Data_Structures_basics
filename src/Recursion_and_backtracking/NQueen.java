package Recursion_and_backtracking;
public class NQueen {
    private static int queenPlacement(boolean[][] board,int row){
        if (row==board.length){
            printDisplay(board);
            System.out.println();
            return 1;
        }
        int count=0;
        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board,row,col)){
                board[row][col]=true;
                count+=queenPlacement(board,row+1);
                board[row][col]=false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]){
                return false;
            }
        }
        int minLeft=Math.min(row,col);
        for (int i = 0; i <= minLeft; i++) {
            if (board[row-i][col-i]){
                return false;
            }
        }
        int minRight=Math.min(row,board.length-1-col);
        for (int i = 0; i <= minRight; i++) {
            if (board[row-i][col+i])
                return false;
        }
        return true;
    }

    private static void printDisplay(boolean[][] board) {
        for (boolean[] row: board) {
            for (boolean element:row) {
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
        queenPlacement(board,0);
    }
}
