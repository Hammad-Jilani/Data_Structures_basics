package Practice;

//import static AdvancedRecursion.IntermediateRecursion.Conquer;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sorting {
    private static void quick(int startIndex,int endIndex,int[] array){
        if (startIndex<endIndex){
            int pivotIndex = partition(startIndex,endIndex,array);
            quick(startIndex,pivotIndex-1,array);
            quick(pivotIndex+1,endIndex,array);
        }
    }

    private static int partition(int startIndex, int endIndex, int[] array) {
        int i = startIndex-1;
        int pivot = array[endIndex];
        for (int j = startIndex; j < endIndex; j++) {
            if (array[j]<pivot){
                i++;
                int temp = array[j];
                array[j]=array[i];
                array[i] = temp;
            }
        }
        i++;
        int temp = array[endIndex];
        array[endIndex] = array[i];
        array[i]=temp;
        return i;
    }

    private static void divide(int startIndex,int endIndex,int[] array){
        if (startIndex>=endIndex){
            return;
        }
        int mid = startIndex+(endIndex-startIndex)/2;
        divide(startIndex,mid,array);
        divide(mid+1,endIndex,array);
        Conquer(startIndex,endIndex,mid,array);
    }

    private static void Conquer(int startIndex, int endIndex, int mid, int[] array) {
        int index1 = startIndex;
        int index2 = mid+1;
        int x = 0;
        int[] merge = new int[endIndex-startIndex+1];
        while (index1<=mid && index2<=endIndex){
            if (array[index1]<array[index2]){
                merge[x++]=array[index1++];
            }else{
                merge[x++]=array[index2++];
            }
        }
        while (index1<=mid)
            merge[x++]=array[index1++];
        while (index2<=endIndex)
            merge[x++]=array[index2++];
        for (int i = 0,j=startIndex; i < merge.length ; i++,j++) {
            array[j]=merge[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {43,12,3,54,6,32,1};
//        divide(0,array.length-1,array);
        quick(0,array.length-1,array);
        System.out.println(Arrays.toString(array));
    }
}
