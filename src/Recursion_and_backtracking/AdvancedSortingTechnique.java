package Recursion_and_backtracking;

//import static AdvancedRecursion.Backtrack.conquer;

public class AdvancedSortingTechnique {
    public static  void divide(int[] array,int startIndex,int EndIndex){
        if (startIndex>=EndIndex){
            return;
        }
        int mid = startIndex+(EndIndex-startIndex)/2;
        divide(array,startIndex,mid);
        divide(array,mid+1,EndIndex);
        conquer(array,startIndex,mid,EndIndex);
    }

    private static void conquer(int[] array, int startIndex, int mid, int endIndex) {
        int[] merge = new int[endIndex-startIndex+1];
        int index1=startIndex;
        int index2 = mid+1;
        int x=0;
        while (index1<=mid && index2 <= endIndex){
            if (array[index1]<array[index2]){
                merge[x++] = array[index1++];
            }
            else merge[x++] = array[index2++];
        }
        while (index1<=mid)
            merge[x++] = array[index1++];
        while (index2 <= endIndex)
            merge[x++] = array[index2++];
        for (int i = 0,j=startIndex; i < merge.length ; i++,j++) {
            array[j]=merge[i];
        }
    }
    public static void quick(int[] array ,int low,int high){
        if (low<=high){
            int pivotIndex=partition(array,low,high);
            quick(array,low,pivotIndex-1);
            quick(array,pivotIndex+1,high);
        }
    }
    public static int partition(int[] array,int low,int high){
        int pivot = array[high];
        int i =low-1;
        for (int j = low; j <high ; j++) {
            if (array[j]<pivot){
                i++;
                int temp = array[j];
                array[j]=array[i];
                array[i]=temp;
            }
        }
        i++;
        int temp = array[i];
        array[i]=array[high];
        array[high]=temp;
        return i;
    }

    public static void main(String[] args) {
        int[] array = {3,2,21,23,11,211,5,1,0};
//        divide(array,0,array.length-1);
        quick(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }

    }
}
