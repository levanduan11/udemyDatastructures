package SORTING;

import java.util.Arrays;
import java.util.Comparator;

public class quicksort {
    static<T> void sort(T arr[], Comparator<? super T> c) {
        sort(arr, 0, arr.length - 1, c);
    }

    static<T> void sort(T arr[], int l, int h, Comparator<? super T> c) {
        if (l > h) return;
        T x = arr[l];
        int i = l;
        int j = h;
        do {
            while (i <= j && c.compare((T)arr[i],(T)x)<=0) {
                i++;
            }
//            do {
//                i++;
//            }while (c.compare((T)arr[i],(T)x)<=0);
            while (i <=j && c.compare((T)arr[j],(T)x)>0) {
                j--;
            }
//            do {
//                j--;
//            }while (c.compare((T)arr[j],(T)x)>0);
            if (i < j) {
             T t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        } while (i <j);
       T t = x;
        arr[l] = arr[j];
        arr[j] = t;

        sort(arr, l, j-1,c);
        sort(arr, j + 1, h,c);
    }

    public static void main(String[] args) {
       Integer arr[] = {1,2,3,10,15,16,1,11,12,13};
        sort(arr,(a,b)->(a-b));

        for (int s : arr
        ) {
            System.out.println(s);
        }

    }
}
