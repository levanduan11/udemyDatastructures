package ArrayADT;

public class insert {
    static void appen(int arr[], int value) {
        int n = arr.length;
        if (n == 0||arr==null) {
            throw new NullPointerException("mang co do dai bang khong");
        }
        int narr[] = new int[n + 1];
        System.arraycopy(arr, 0, narr, 0, n);
        narr[n] = value;
        arr=narr;
        for (int s : arr
        ) {
            System.out.println(s);
        }
    }

    static int[] is(int arr[], int index, int x) {
        int narr[] = new int[arr.length + 1];
        if (index == 0) {
            narr[0] = x;
            System.arraycopy(arr, 0, narr, 1, arr.length);
        } else {
            System.arraycopy(arr, 0, narr, 0, index);
            System.arraycopy(arr, index - 1, narr, index, arr.length - index + 1);
            narr[index] = x;
        }
        arr = narr;
        return arr;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
       int s[]=new int[0];

appen(s,99999);
    }
}