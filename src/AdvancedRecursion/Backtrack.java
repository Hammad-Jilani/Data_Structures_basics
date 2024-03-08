package AdvancedRecursion;

import java.util.Arrays;

public class Backtrack {
    public static void paths(int i,int j,int n,int m,int maze[][]){
        if (i==n-1 && j==m-1){
            return;
        }
        if (i==n || j==m){
            return;
        }
        if (maze[i][j]==0){
            return ;
        }
        maze[i][j] = 0;
    }
    public static void findWord(char[][] board,String string,int index,int row,int col){
        if (row == board.length-1 && col == board[0].length-1) {
            System.out.println("Not found");
            return;
        }
        if (index == string.length()-1 ){
            System.out.println("Word found");
            return;
        }
        if (row == board.length || col == board[0].length){
            return;
        }
        if (board[row][col] == '.'){
            return;
        }
        if (isPresent(board,string,index,row,col)){
            board[row][col] = '.';
            if (row > 0) {
                findWord(board, string, index + 1, row - 1, col);
//                index=0;
            }
            if (col > 0) {
                findWord(board, string, index + 1, row, col - 1);
//                index=0;
            }
            if (row < board.length - 1) {
                findWord(board, string, index + 1, row + 1, col);
//                index=0;
            }
            if (col < board[0].length - 1) {
                findWord(board, string, index + 1, row, col + 1);
//                index=0;
            }
            board[row][col] = string.charAt(index);
            index = 0;
        }
        else{
            if (row > 0) {
                findWord(board, string, 0, row - 1, col);
            }
            if (col > 0) {
                findWord(board, string, 0 , row, col - 1);
            }
            if (row < board.length - 1) {
                findWord(board, string, 0, row + 1, col);
            }
            if (col < board[0].length - 1) {
                findWord(board, string, 0, row, col + 1);
            }
        }
    }
    public static boolean isPresent(char[][] board,String string,int index,int row,int col){
        if (board[row][col]==string.charAt(index)){
            return true;
        }
        else
            return false;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'s','c','d','f','o','o','t','e','b','f'},
                {'a','f','h','j','n','a','v','d','n','w'},
                {'d','h','q','u','e','e','n','r','y','k'},
                {'f','r','h','b','n','a','c','t','p','f'},
                {'k','w','t','d','g','x','f','x','l','p'},
                {'z','a','x','v','f','o','o','d','a','e'},
                {'e','u','s','a','j','g','c','u','y','i'},
                {'q','i','x','p','c','y','b','u','q','i'},
                {'r','n','g','o','o','g','l','e','q','y'},
        };
        findWord(board,"foot",0,0,0);
    }
}
