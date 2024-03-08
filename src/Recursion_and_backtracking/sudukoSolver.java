package Recursion_and_backtracking;
public class sudukoSolver {
    public static void main(String[] args) {
        int[][] board = {
                {3,0,6,5,0,8,4,0,0},
                {5,2,0,0,0,0,0,0,0},
                {0,8,7,0,0,0,0,3,1},
                {0,0,3,0,1,0,0,8,0},
                {9,0,0,8,6,3,0,0,5},
                {0,5,0,0,9,0,6,0,0},
                {1,3,0,0,0,0,2,5,0},
                {0,0,0,0,0,0,0,7,4},
                {0,0,5,2,0,6,3,0,0},
        };
        if (solve(board)){
            display(board);
        }else System.out.printf("Cannot be solved");
    }
    private static void display(int[][] board) {
        for (int[] row:board){
            for (int number: row){
                System.out.printf(number+" ");
            }
            System.out.println();
        }
    }

    private static boolean solve(int[][] board){
        int row=-1;
        int col = -1;
        boolean emptyLeft=true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j]==0){
                    row=i;
                    col=j;
                    emptyLeft=false;
                    break;
                }
            }
            if (emptyLeft==false)
                break;
        }
        if (emptyLeft==true){
            return true;
        }
        for (int number = 1; number <=9; number++) {
            if (isSafe(board,row,col,number)){
                board[row][col]=number;
                if (solve(board)){
                    return true;
                }
                else
                    board[row][col]=0;
            }
        }
        return false;
    }
    private static boolean isSafe(int[][] board,int row,int col,int num){
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i]==num)
                return false;
        }
        for(int number[] : board ){
            if (number[col]==num)
                return false;
        }
        int sqrt = (int)Math.sqrt(board.length);
        int start = row-row%sqrt;
        int endCol = col - col%sqrt;
        for (int r = start; r <start+sqrt ; r++) {
            for (int c = endCol; c < endCol+sqrt; c++) {
                if (board[r][c]==num)
                    return false;
            }
        }
        return true;
    }
}
