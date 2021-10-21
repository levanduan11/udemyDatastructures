package SORTING;

import java.util.Comparator;

public class selection {
    static void sort(int arr[], Comparator c){
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            int min=i;
            for (int j =i; j <n ; j++) {
                int k=c.compare(arr[min],arr[j]);
                if(k>0){
                    min=j;
                }
            }
            int t=arr[i];
            arr[i]=arr[min];
            arr[min]=t;
        }

    }

    public static void main(String[] args) {
        int arr[] = {7, 6, 5, 4, 3, 2, 1, 2,-7,-9,44};
        sort(arr,(a,b)->((int)a-(int)b));
        for (int s : arr
        ) {
            System.out.println(s);
        }
    }
}
