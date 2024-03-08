package Recursion_and_backtracking;

import java.util.ArrayList;

public class recursion1 {
    public  static int CountPaths(int i,int j,int n,int m){
        if (i==n || j==m){
            return 0;
        }
        if (i==n-1 && j==m-1){
            return 1;
        }
        return CountPaths(i+1,j,n,m)+CountPaths(i,j+1,n,m)+CountPaths(i+1,j+1,n,m);
    }
    public static ArrayList<String> List = new ArrayList<>();
    public  static ArrayList<String> FindPaths(int i,int j,int n,int m,String path){
        if (i==n-1 && j==m-1){
            List.add(path);
            return List;
        }
        if (i<n){
            FindPaths(i+1,j,n,m,path+"down ");
        }
        if (j<m){
            FindPaths(i,j+1,n,m,path+"right ");
        }
        if (i<n-1 && j<m-1){
            FindPaths(i+1,j+1,n,m,path+"Diagonal ");
        }
        return List;
    }
    public static void  paths(int i,int j,int n,int m,String path){
        if (i==n-1 && j==m-1){
            System.out.println(path);
            return;
        }
        if (i==n || j==m){
            return;
        }
        if (i<n){
            paths(i+1,j,n,m,path+"down ");
        }
        if (j<m){
            paths(i,j+1,n,m,path+"right ");
        }
    }
    public  static void FindRestrictedPaths(int i,int j,int n,int m,int[][] maze,String path){
        if (i==n-1 && j== m-1){
            System.out.println(path);
            return;
        }
        if (maze[i][j]==0){
            return;
        }
        if (i<n-1){
            FindRestrictedPaths(i+1,j,n,m,maze,path+"down ");
        }
        if (j<m-1){
            FindRestrictedPaths(i,j+1,n,m,maze,path+"right ");
        }
    }
    public static String[] keypad = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void Combination(String str,int index,String combination){
        if (index==str.length()){
            System.out.println(combination);
            return;
        }
        char curr = str.charAt(index);
        String mapping = keypad[curr-'0'];
        for (int i = 0; i < mapping.length(); i++) {
            Combination(str,index+1,combination+ mapping.charAt(i));
        }
    }
    public static void main(String[] args) {
//        printComb("23",0,"");
//        System.out.println(CountPaths(0,0,3,3));
//        System.out.println(FindPaths(0,0,3,3,"").toString());
//        paths(0,0,3,3,"");
        int[][] maze = {{1,1,1},{1,0,1},{1,1,1}};
        FindRestrictedPaths(0,0,3,3,maze,"");
        Combination("23",0,"");
    }
}
