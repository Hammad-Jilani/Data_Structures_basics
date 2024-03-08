package Practice;

import java.util.Arrays;

public class backtracking {
    public static void printMaze(int i,int j,int n,int m,int[][] maze,int[][] path,int step,String String){
        if (i == n-1 && j ==  m-1){
            path[i][j] = step;
            for (int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(String);
            System.out.println();
            return;
        }
        if (maze[i][j] == 0){
            return;
        }
        maze[i][j] = 0;
        path[i][j] = step;
        if (i<n-1){
            printMaze(i+1,j,n,m,maze,path,step+1,String+"down ");
        }
        if (i>0){
            printMaze(i-1,j,n,m,maze,path,step+1,String+"up ");
        }
        if (j>0){
            printMaze(i,j-1,n,m,maze,path,step+1,String+"left ");
        }
        if (j<m-1){
            printMaze(i,j+1,n,m,maze,path,step+1,String+"right ");
        }
        maze[i][j] = 1;
        path[i][j] = 0;
    }
    public static int nQueen(boolean[][] board,int row){
        if (row==board.length){
            printBoard(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board,row,col)){
                board[row][col] = true;
                count+=nQueen(board,row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row,int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]){
                return false;
            }
        }
        int maxLeft =Math.min(row,col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row-i][col-i]){
                return false;
            }
        }
        int maxRight = Math.min(row,board.length-1-col);
        for (int i = 1; i <=maxRight; i++) {
            if (board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    public static void printBoard(boolean[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
    public static boolean solve(int[][] board){
        int row = -1;
        int col = -1;
        boolean empty = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j]==0){
                    row = i;
                    col = j;
                    empty=false;
                    break;
                }
            }
            if (empty==false){
                break;
            }
        }
        if (empty==true){
            return true;
        }
        for (int number = 1; number <=9 ; number++) {
            if (isSafeSuduko(board,row,col,number)){
                board[row][col] = number;
                if (solve(board)){
                    return true;
                }
                board[row][col] =0;
            }
        }
        return false;
    }

    private static boolean isSafeSuduko(int[][] board, int row, int col, int number) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i]==number){
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][col]==number)
                return false;
        }
        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = row - row%sqrt;
        int colStart = col - col % sqrt;
        for (int i = rowStart; i < rowStart+sqrt; i++) {
            for (int j = colStart; j < colStart+sqrt; j++) {
                if (board[i][j] == number){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] maze = {{1,1,0},{1,1,1},{1,1,1}};
        int[][] path = {{0,0,0},{0,0,0},{0,0,0}};

        printMaze(0,0,3,3,maze,path,1,"");
//        System.out.println(nQueen(new boolean[4][4],0));
//        int[][] board = {
//                {3,0,6,5,0,8,4,0,0},
//                {5,2,0,0,0,0,0,0,0},
//                {0,8,7,0,0,0,0,3,1},
//                {0,0,3,0,1,0,0,8,0},
//                {9,0,0,8,6,3,0,0,5},
//                {0,5,0,0,9,0,6,0,0},
//                {1,3,0,0,0,0,2,5,0},
//                {0,0,0,0,0,0,0,7,4},
//                {0,0,5,2,0,6,3,0,0},
//        };
//        if (solve(board)){
//            display(board);
//        }else System.out.printf("Cannot be solved");
    }
    private static void display(int[][] board) {
        for (int[] row:board){
            for (int number: row){
                System.out.printf(number+" ");
            }
            System.out.println();
        }
    }
}
