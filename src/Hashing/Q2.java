package Hashing;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        int N=4,K=6;
        int arr1[] = {1,5,7,1};
        int min = mini(arr1);
        int max = maxi(arr1);
        int diff = max - min + 1;
        int count = 0;
        int[] arr2 = new int[diff];
        for (int i = 0; i < N; i++) {
            int complement = K - arr1[i];
            if(complement >= min && complement <= max) {
                count = count + arr2[complement - min];
            }
            arr2[arr1[i] - min]++;
        }
        System.out.println("Total pairs that make " + K + " are: " + count);
    }
    public static int maxi(int[] arr) {
        int MAX = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > MAX) {
                MAX = arr[i];
            }
        }
        return MAX;
    }
    public static int mini(int[] arr) {
        int MIN = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < MIN) {
                MIN = arr[i];
            }
        }
        return MIN;
    }
}