package AdvancedRecursion;
public class Advanced {
    public static void Permutation(String string,String permu){
        if (string.isEmpty()){
            System.out.println(permu);
            return;
        }
        for (int i = 0; i < string.length(); i++) {
            char curr = string.charAt(i);
            String newstring = string.substring(0,i)+string.substring(i+1);
            Permutation(newstring,permu+curr);
        }
    }
    public static void Subsequence (String string,int index,String combination){
        if (index==string.length()){
            System.out.println(combination);
            return;
        }
        Subsequence(string,index+1,combination+string.charAt(index));
        Subsequence(string,index+1,combination);
    }
    public static void main(String[] args) {
//        Subsequence("abc",0,"");
//        String string = "123456";
        System.out.println(Math.floor(104.0));
//        System.out.println(string.substring(2,4));
//        Permutation("abc","");
        int sum = 0;
        String string = "cat";
        for (int i = 0; i < string.length(); i++) {
            sum+=string.charAt(i);
        }
        System.out.println(sum);
        sum = string.charAt(1);
        System.out.println(sum);
    }
}
