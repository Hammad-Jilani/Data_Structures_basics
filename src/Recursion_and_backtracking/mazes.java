package Recursion_and_backtracking;
import java.util.ArrayList;
import java.util.Arrays;
public class mazes {
    public static void Subsequences(String string,String newStr,int index){
        if (index==string.length()){
            System.out.println(newStr);
            return;
        }
        Subsequences(string,newStr+string.charAt(index),index+1);
        Subsequences(string,newStr,index+1);
    }

    public static ArrayList<String> list= new ArrayList<>();
    public static ArrayList<String> printPaths(int i,int j,int n,int m,String path){
        if (i==n-1 && j==m-1){
            list.add(path);
            return list;
        }

        if (i<n){
            printPaths(i+1,j,n,m,path+"down ");
        }
        if (j<m){
            printPaths(i,j+1,n,m,path+"right ");
        }
        return list;
    }
    public  static void AllPaths(int i,int j,int n,int m,int[][] maze,String path){
        if (i==n-1 && j== m-1){
            System.out.println(path);
            return;
        }
        if (maze[i][j]==0){
            return;
        }
        maze[i][j]=0;
        if (i<n-1){
            AllPaths(i+1,j,n,m,maze,path+"down ");
        }
        if (i>0){
            AllPaths(i-1,j,n,m,maze,path+"up ");
        }

        if (j<m-1){
            AllPaths(i,j+1,n,m,maze,path+"right ");
        }
        if (j>0){
            AllPaths(i,j-1,n,m,maze,path+"left ");
        }
        maze[i][j]=1;
    }
    public  static void printAllPaths(int i,int j,int n,int m,int[][] maze,String path,int[][] p,int steps){
        if (i==n-1 && j== m-1){
            p[i][j] =steps;
            for (int[] arr:p) {
                System.out.println(Arrays.toString(arr));
            }

            System.out.println(path);
            System.out.println();
            return;
        }
        if (maze[i][j]==0){
            return;
        }
        maze[i][j]=0;
        p[i][j] =steps;
        if (i<n-1){
            printAllPaths(i+1,j,n,m,maze,path+"down ",p,steps+1);
        }
        if (i>0){
            printAllPaths(i-1,j,n,m,maze,path+"up ",p,steps+1);
        }

        if (j<m-1){
            printAllPaths(i,j+1,n,m,maze,path+"right ",p,steps+1);
        }
        if (j>0){
            printAllPaths(i,j-1,n,m,maze,path+"left ",p,steps+1);
        }
        maze[i][j]=1;
        p[i][j]=0;
    }
    public static void main(String[] args) {
//        System.out.println(printPaths(0,0,3,3,""));
//        Subsequences("abc","",0);
        
        int[][] maze = {{1,1,1},{1,1,1},{1,1,1}};
//        AllPaths(0,0,3,3,maze,"");
        int[][] p =new int[3][3];
        printAllPaths(0,0,3,3,maze,"",p,1);
    }
}
