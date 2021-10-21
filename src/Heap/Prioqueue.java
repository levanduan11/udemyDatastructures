package Heap;

import java.sql.PreparedStatement;

public class Prioqueue {
    int size = 0;
    int arr[];

    public Prioqueue(int n) {
        this.arr = new int[n];
    }

    public Prioqueue() {
        this(1);
    }

    public boolean compare(int a, int b) {
        return a <b;
    }

    public void swap(int i, int j, int arr[]) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public int size() {
        return this.size;
    }

    public void insert(int v) {
        if (size == arr.length) {
            grow();
        }
        arr[size++] = v;
        shiffup(size - 1);
    }

    public void grow() {
        int narr[] = new int[arr.length * 2];
        System.arraycopy(arr, 0, narr, 0, this.size);
        this.arr = narr;
    }

    public int remove() {
        if (this.size > 0) {
            int n = size - 1;
            size--;
            int re = arr[0];
            arr[0] = arr[n];
            arr[n] = 0;
            shiffdow(0);

            return re;
        }
        throw new NullPointerException("mang rong");
    }

    public void shiffup(int k) {
        while (k > 0 && compare(arr[k], arr[(k - 1) / 2])) {
            swap(k, (k - 1) / 2, arr);
            k = (k - 1) / 2;
        }
    }

    public void shiffdow(int k) {
        int s = size / 2;

        while (k < s) {
            int i = 2 * k + 1;
            if (!compare(arr[i], arr[i + 1]) && i < size - 1) {
                i++;
            }
            if (compare(arr[k], arr[i])) {
                break;
            }
            swap(k, i, arr);
            k = i;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void peek() {
        System.out.println(arr[0]);
    }

    public static void main(String[] args) {
        Prioqueue p = new Prioqueue();
        p.insert(5);
        p.insert(4);
        p.insert(3);
        p.insert(-3);
        p.insert(-37);
        p.insert(-2);
        p.insert(-27);
        p.insert(-82);
        p.insert(-32);
        p.insert(-92);
        p.insert(-278);

        while (!p.isEmpty()) {
            System.out.println(p.remove());
        }


    }
}
