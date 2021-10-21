package ArrayADT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

public class arraytest {

    public static void main(String[] args) {


        int a[]={1,2,3,4};
        int b[]={4,5,6,7};//1,2,3,5,6,7
       int k[]= diff(a,b);
       print(k);
    }

    static int[] diff(int a[],int b[]){
        sort(a,true);
        sort(b,true);
       int res[]=new int[a.length+b.length];
       int k=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int o=binarySearch.search(b,a[i]);
                if(o==-1){
                    res[k++]=a[i];
                    break;
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < a.length; j++) {
                int o=binarySearch.search(a,b[i]);
                if(o==-1){
                    res[k++]=b[i];
                    break;
                }
            }

        }
        int r[]=new int[k];
        for (int i = 0; i < k; i++) {
          r[i]=res[i];

        }
return r;
    }
    static void sort(int arr[],boolean order){
        mergesort.sort(arr,order);
    }
    static void k(int n){
        if(n==0)return;
        k(n-1);
        k(n/2);
        System.out.println(n);
    }
    static void print(int arr[]) {
        for (int s : arr
        ) {
            System.out.print(s + "  ");
        }
    }

    static int[] mergesorted(int[]a,int[]b){
        int m=a.length,n=b.length,z=m+n,i=0,j=0;
        int res[]=new int[z];
        if(m==0)return (res=b);
        if(n==0)return (res=a);
        for ( int k = 0; k <z ; k++) {
            if(i>m-1)res[k]=b[j++];
            else if(j>n-1)res[k]=a[i++];
            else if(a[i]>b[j])res[k]=b[j++];
            else res[k]=a[i++];
        }
        return res;
    }
    static int[] merge(int a[], int b[], int[] res) {
        return merge(a, b, res, a.length, b.length, 0, a.length, 0);
    }

    private static int[] merge(int a[], int b[], int res[], int n, int m, int i, int j, int k) {
        if (n == 0) {
            return (res = b);
        }
        if (m == 0) {
            return (res = a);
        }
        if (i < n) {
            res[i] = a[i++];
        }
        if (j < (n + m)) {
            res[j++] = b[k++];
        }
        if (i == n && j == (m + n)) return res;
        return merge(a, b, res, n, m, i, j, k);
    }

    static int[] mer(int a[], int b[]) {
        int n = a.length, m = b.length;
        int res[] = new int[n + m];
        if (n == 0) {
            return (res = b);
        }
        if (m == 0) {
            return (res = a);
        }
        System.arraycopy(a, 0, res, 0, n);
        System.arraycopy(b, 0, res, n, m);
        return res;
    }

    static int[] merge(int a[], int b[]) {

        int n = a.length, m = b.length, z = m + n;
        int res[] = new int[z];
        if (n == 0) {
            return (res = b);
        }
        if (m == 0) {
            return (res = a);
        }
        for (int i = 0, j = n, k = 0; j < z; k++, j++) {
            if (i < n) {
                res[i] = a[i++];

            }
            res[j] = b[k];
        }
        return res;
    }

    static boolean container(int arr[], int x) {
        return binarySearch.search(arr, x) != -1;
    }

    static int get(int arr[], int index) {
        if (index < 0 || index > arr.length - 1) throw new ArrayIndexOutOfBoundsException("gia tri khong hop le");
        else {
            return arr[index];
        }
    }

    static boolean set(int arr[], int value, int index) {

        if (index < 0 || index > arr.length - 1) {

            throw new ArrayIndexOutOfBoundsException("gia tri khong hop le");

        } else {
            arr[index] = value;
            return true;
        }

    }

    static int sum(int arr[]) {
        return sum(arr, 0, arr.length, 0);
    }

    static int sum1(int arr[], int n) {
        if (n < 0) return 0;
        return sum1(arr, n - 1) + arr[n];
    }

    static int sum(int arr[], int i, int n, int s) {
        if (i == n) return s;
        else {
            s = arr[i] + s;
            return sum(arr, i = i + 1, n, s);
        }
    }

    static boolean checksorted(int arr[]) {
        int n = arr.length;
        int narr[] = new int[n];
        System.arraycopy(arr, 0, narr, 0, n);
        quicksort.sort(narr, true);
        for (int i = 0; i < n; i++) {
            if (arr[i] != narr[i]) return false;
        }
        return true;
    }

    static boolean checksoted(int arr[], int i, int j) {
        if (j == arr.length) return true;
        if (arr[i] > arr[j]) return false;
        return checksoted(arr, i = i + 1, j = j + 1);
    }

    static double avege(int arr[]) {
        int s = 0;
        for (int k : arr
        ) {
            s += k;
        }
        return (float) s / arr.length;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    static int max(int arr[]) {
        quicksort.sort(arr, true);
        return arr[arr.length - 1];
    }

    static int min(int arr[]) {
        quicksort.sort(arr, false);
        return arr[arr.length - 1];
    }

    static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void reverse(int arr[]) {
        int n = arr.length;
//    for (int i = 0,j=n-1; i <n/2 ; i++) {
//        swap(arr,i,j--);
//    }
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            swap(arr, i, j);
        }
        for (int s : arr
        ) {
            System.out.println(s);
        }
    }


}
