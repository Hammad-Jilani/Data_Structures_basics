package AdvancedRecursion;

import java.util.Arrays;

public class IntermediateRecursion {
    public static int first=-1;
    public static int last=-1;
    public static boolean isSorted(int[] array , int index){
        if (index==array.length-1){
            return true;
        }
        if (array[index] < array[index+1] ){
            return isSorted(array,index+1);
        }
        return false;
    }

    public static boolean[] map = new boolean[26];
    public static void removeDuplicate(String string,int index,String newString){
        if (index==string.length()){
            System.out.println(newString);
            return;
        }
        char current=string.charAt(index);
        if (map[current-'a']){
            removeDuplicate(string,index+1,newString);
        }
        else{
            newString+=string.charAt(index);
            map[current-'a']=true;

            removeDuplicate(string,index+1,newString);
        }
    }
    public static void divide(int[] array,int startIndex,int endIndex){
        if (startIndex>=endIndex){
            return;
        }
        int mid = startIndex+(endIndex-startIndex)/2;
        divide(array,startIndex,mid);
        divide(array,mid+1,endIndex);
        Conquer(array,startIndex,mid,endIndex);
    }
    public static void Conquer(int[] array,int startIndex,int mid,int endIndex){
        int x = 0;
        int index1 = startIndex;
        int index2 = mid+1;
        int[] merge = new int[endIndex-startIndex+1];
        while (index1<=mid && index2<=endIndex){
            if (array[index1]<array[index2]){
                merge[x++] = array[index1++];
            }else{
                merge[x++] = array[index2++];
            }
        }
        while (index1<=mid){
            merge[x++] = array[index1++];
        }
        while (index2<=endIndex){
            merge[x++] = array[index2++];
        }
        for (int i = 0,j=startIndex; i < merge.length ;j++, i++) {
            array[j] = merge[i];
        }
    }
    public static void quick(int[] array,int low,int high){
        if (low<high){
            int pivotIndex = partition(array,low,high);
            quick(array, low,pivotIndex-1);
            quick(array,pivotIndex+1,high);
        }
    }
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low-1;
        for (int j = low; j < high; j++) {
            if (array[j]<pivot){
                i++;
                int temp = array[j];
                array[j]=array[i];
                array[i]=temp;
            }
        }
        i++;
        int temp = array[high];
        array[high]=array[i];
        array[i]=temp;
        return i;
    }
    public static void Radix(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length ; i++) {
            if (array[i]>max)
                max=array[i];
        }
        for (int emp = 1; max/emp >0 ; emp*=10) {
            Counting(array,emp);
        }
    }
    private static void Counting(int[] array, int emp) {
        int[] temp = new int[10];
        int[] result = new int[array.length];
        Arrays.fill(temp,0);
        for (int i = 0; i < array.length; i++) {
            temp[array[i]/emp%10]++;
        }
        for (int i = 1; i <10 ; i++) {
            temp[i]+=temp[i-1];
        }
        for (int i = array.length-1; i >= 0 ; i--) {
            result[temp[array[i]/emp%10]-1]=array[i];
            temp[array[i]/emp%10]--;
        }
        for (int i = 0; i < array.length; i++) {
            array[i]=result[i];
        }
    }
    private static void Sub(String string,String combination,int index){
        if (index==string.length()){
            System.out.println(combination);
            return;
        }
        Sub(string,combination+string.charAt(index),index+1);
        Sub(string,combination,index+1);
    }
    public static boolean[] repeat = new boolean[26];
    public static void RemoveDuplicates(String string,String newString,int index){
        if (index==string.length()){
            System.out.println(newString);
            return;
        }
        if(!repeat[string.charAt(index)-'a']){
            newString+=string.charAt(index);
            repeat[string.charAt(index)-'a']=true;
        }
        RemoveDuplicates(string,newString,index+1);
    }
    public static void main(String[] args) {
        int[] array = {3,2,63,12,43,210,9};
        System.out.println(isSorted(array,0));
        divide(array,0,array.length-1);
//        quick(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

}
