package SORTING;

public class insertsort {
    int arr[] = new int[10];
    int size = 0;

    void insert(int d) {
        insert(d, this.size);
    }

    void insert(int d, int index) {
        int j = size - 1;
        while (j >= 0) {
            if (d > arr[j]) break;

            arr[index] = arr[j];
            index = j;
            j--;


        }
        arr[index] = d;
        size++;
    }

    static void sort3(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j;
            int x = arr[i];
            for (j = i - 1; j >= 0; ) {
                if (arr[j] > x) {
                    arr[j + 1] = arr[j];
                    j--;
                }
            }
            int k = j + 1;
            arr[k] = x;
        }
    }

    static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int x = arr[i];
            int j;
            for (j = i; j > 0; ) {
                if (x >= arr[j - 1]) break;
                arr[j] = arr[j - 1];
                j--;

            }
            arr[j] = x;
        }

    }

    static void sort2(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int t = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = t;
                }
            }
        }
    }

    private static void insertionSort(int[] a) {
        for (int i, k = 0; ++k < a.length; ) {
            int ai = a[i = k];


            if (ai < a[i - 1]) {
                while (--i >= 0 && ai < a[i]) {
                    a[i + 1] = a[i];
                }
                a[i + 1] = ai;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 5, 3, 2, 1, 2};
        insertionSort(arr);
        int i = 0;
        /*
        i-->=0{
        b1 ktra
        b2 giam i di 1
        b3 thuc hien khoi lenh trong vong lap-> quay lai b1
        --i>=0
        b1 giam i di 1
        b2 ktra
        b3 thuc hien khoi lenh trong vong lap->quay lai b1
        i>=0;i--
        b1 ktran
        b2 thuc hien khoi lenh trong vong lap
        b3 giam i di 1 ->quay lai b1
        }

        *
        * */
        for (;i-- >= 0; ) {
            System.out.println(i);
        }
    }
}