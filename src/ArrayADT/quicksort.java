package ArrayADT;

public class quicksort {

    static void swap(int i, int j, int arr[]) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static void sort(int arr[], boolean check) {
        sort(arr, 0, arr.length - 1, check);
    }

    static void sort(int arr[], int l, int r, boolean check) {
        if (l > r) return;
        int i = l + 1;
        int j = r;
        do {
            if (check) {
                for (; i <= j && arr[i] <= arr[l]; i++) ;
                for (; i <= j &&arr[j] > arr[l]; j--) ;
            } else {
                for (; i <= j && arr[i] >= arr[l]; i++) ;
                for (; i <= j &&arr[j] < arr[l]; j--) ;
            }
            if (i < j)
                swap(i, j, arr);
        } while (i < j);
        swap(l, j, arr);

        sort(arr, l, j - 1, check);
        sort(arr, j + 1, r, check);
    }

    public static void main(String[] args) {
        int arr[] = {77, -45, -99, 0, 45, 32, 1, 2, 3, 7, 9, 33};
        int a[] = {3, 2, 78, -77, -33, -22, 33, 45, 76, 0, 10, 9, 8, 9, 33};
        int k[] = {1, 2, 3, 4, 0, 7, -3, 8, 9, 10};
        sort(k, true);
        for (int s : k
        ) {
            System.out.println(s);
        }
    }
}
