package SORTING;

import java.util.Comparator;

public class mersort {
    static <T> void sort(T arr[], Comparator<? super T> c) {
        T res[] = (T[]) new Object[arr.length];
        sort(arr, res, 0, arr.length - 1, c);
    }

    static <T> void sort(T arr[], T res[], int l, int r, Comparator<? super T> c) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        sort(arr, res, l, mid, c);
        sort(arr, res, mid + 1, r, c);
        merge(arr, res, l, r, mid, c);
    }

    static <T> void merge(T arr[], T res[], int l, int r, int mid, Comparator<? super T> c) {
        for (int i = l; i <= r; i++) {
            res[i] = arr[i];
        }
        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = res[j++];
            } else if (j > r) {
                arr[k] = res[i++];
            } else if (c.compare((T) res[j], (T) res[i]) < 0) {
                arr[k] = res[j++];
            } else {
                arr[k] = res[i++];
            }
        }
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];  // this copying is unneccessary
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }

    }
    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n - len; lo += len + len) {
                int mid = lo + len - 1;
                int hi = Math.min(lo + len + len - 1, n - 1);
                merge(a, aux, lo, mid, hi);
            }
        }
    }
    public static void main(String[] args) {
        Integer arr[] = {7, 6, 5, 4, 3, 2, 1, 2};
        sort(arr, (a, b) -> b - a);
Comparable a[]={7,6,5,4,3,2,1,-7,-4,-9,12,11};
sort(a);
        for (Comparable s : a
        ) {
            System.out.println(s);
        }
    }
}
