package Practice;

import java.util.Arrays;

public class BinarySearch {
    public static void Insertion(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j >0; j--) {
                if (array[j]<array[j-1]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }else{
                    break;
                }
            }
        }
    }
    public static void Selection(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int min = i;
            for (int j = i+1; j < array.length ; j++) {
                if (array[j]<array[min]){
                    min = j;
                }
            }
            if (min!=i){
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }
    public static void Bubble(int[] array){
        boolean swapped;
        for (int i = 0; i < array.length; i++) {
            swapped=false;
            for (int j = 1; j < array.length-i ; j++) {
                if ( array[j]<array[j-1]){
                    swapped=true;
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
            if (!swapped){
                break;
            }
        }
    }
    public static int BinarySearch(int[] array,int value){
        int first = 0;
        int last = array.length-1;
        while (first<=last) {
            int middleIndex = (last + first) / 2;
            if (array[middleIndex] == value) {
                return middleIndex;
            }
            if (value > array[middleIndex]) {
                first=middleIndex+1;

            } else if (value < array[middleIndex]) {
                last =middleIndex-1;
            }
        }
        return -1;
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
        int[] merge = new int[endIndex-startIndex+1];
        int index1 = startIndex;
        int index2 = mid+1;
        while (index1<=mid && index2<=endIndex){
            if (array[index1] < array[index2]){
                merge[x++]=array[index1++];
            }else{
                merge[x++]=array[index2++];
            }
        }
        while (index1<=mid)
            merge[x++]=array[index1++];
        while (index2<=endIndex)
            merge[x++]=array[index2++];
        for (int i = 0,j=startIndex; i < merge.length;j++, i++) {
            array[j]=merge[i];
        }
    }

    public static void main(String[] args) {
        int[] value = {45, 10, 7, 90, 12, 50, 13, 39, 57};
        divide(value,0, value.length-1);
        System.out.println(Arrays.toString(value));
        System.out.println(BinarySearch(value,50));
    }
}
