package Recursion_and_backtracking;
public class array {
    public static int count(int i,int j,int n,int m){
        if (i==n || j==m){
            return 0;
        }
        if (i==n-1 && j==m-1){
            return 1;
        }
        return count(i+1,j,n,m)+count(i,j+1,n,m);
    }
    public static void printPaths(int i,int j,int n,int m,String paths){
        if (i==n || j==m){
            return;
        }
        if (i==n-1 && j==m-1){
            System.out.println(paths);
            return;
        }
        printPaths(i+1,j,n,m,paths+"down ");
        printPaths(i,j+1,n,m,paths+"right ");
    }
    public static void printDiagonalPaths(int i,int j,int n,int m,String paths){
        if (i==n || j==m){
            return;
        }
        if (i==n-1 && j==m-1){
            System.out.println(paths);
            return;
        }
        if (i<n){
            printDiagonalPaths(i+1,j,n,m,paths+"down ");
        }
        if (j<m){
            printDiagonalPaths(i,j+1,n,m,paths+"right ");
        }
        if (i<n-1 && j<m-1){
            printDiagonalPaths(i+1,j+1,n,m,paths+"diagonal ");
        }
    }
    public static void printAllPaths(int i,int j,int n,int m,String paths,int maze[][]){
        if (i==n || j==m){
            return;
        }
        if (i==n-1 && j==m-1){
            System.out.println(paths);
            return;
        }
        maze[i][j]=0;
        if (i<n-1){
            printAllPaths(i+1,j,n,m,paths+"down ",maze);
        }
        if (j<m-1){
            printAllPaths(i,j+1,n,m,paths+"right ",maze);
        }
        if (i>0){
            printAllPaths(i-1,j,n,m,paths+"up ",maze);
        }
        if (j>0){
            printAllPaths(i,j-1,n,m,paths+"left ",maze);
        }
        maze[i][j]=1;
    }
    public static void main(String[] args) {
        int[][] maze = {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(count(0,0,3,3));
        printAllPaths(0,0,3,3,"",maze);
//        printPaths(0,0,3,3,"");
//        printDiagonalPaths(0,0,3,3,"");
    }
}
