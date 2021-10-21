package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class lesson3 {
static void find(int arr[]){
    int max=arr[0];
    for (int i = 1; i < arr.length; i++) {
        max=Math.max(max,arr[i]);
    }
    int cout[]=new int[max+1];
    for (int i = 0; i < arr.length; i++) {
        cout[arr[i]]++;
    }
    for (int i = 0; i < max; i++) {
        System.out.println(i+" =>"+cout[i]);
    }
}
static void findsum(int arr[],int k){
    int max=arr[0];
    for (int i = 1; i < arr.length; i++) {
        max=Math.max(max,arr[i]);
    }
    int cout[]=new int[max+1];
    for (int i = 0; i < arr.length; i++) {
        if(k-arr[i]>=0&&cout[k-arr[i]]!=0){
            System.out.println(arr[i]+"  "+(k-arr[i]));
        }
        cout[arr[i]]++;
    }
}
    static void fin(int arr[]){
        int j=0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]==arr[i+1]){
                j=i+1;
                while (j< arr.length&&arr[i]==arr[j])j++;
                System.out.println(arr[i]+" "+(j-i));
                i=j-1;

            }

        }
    }
    static void display(int arr[][], int j, int i) {
        if (i == arr.length - 1 && j == arr[0].length)
            return;
        if (j == arr[0].length) {
            System.out.println();
            System.out.println();
            i++;
            j = 0;
        }
        System.out.print("arr[" + i + "][" + j + "]= " + arr[i][j] + "  ");
        display(arr, j = j + 1, i);

    }

    public static void main(String[] args) {
    int arr[]={6,3,8,10,16,7,5,2,9,14};
   findsum(arr,10);




    }
}
